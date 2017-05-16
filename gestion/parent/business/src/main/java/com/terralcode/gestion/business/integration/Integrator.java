/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.business.integration;

import com.terralcode.gestion.business.appointment.AppointmentReasonService;
import com.terralcode.gestion.business.appointment.AppointmentService;
import com.terralcode.gestion.business.appointment.AppointmentStatusService;
import com.terralcode.gestion.business.appointment.AppointmentTypeService;
import com.terralcode.gestion.business.appointment.ComplaintTypeService;
import com.terralcode.gestion.business.appointment.ComplaintsService;
import com.terralcode.gestion.business.customer.CustomerCRMService;
import com.terralcode.gestion.business.customer.SpeciesService;
import com.terralcode.gestion.business.sales.SalesService;
import com.terralcode.gestion.business.trade.TradeService;
import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.appointment.AppointmentPurpose;
import com.terralcode.gestion.domain.appointment.Complaint;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.integration.customerxml_oze.Cliente;
import com.terralcode.gestion.domain.integration.customerxml_oze.Clientes;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportAddress;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportAppointment;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportCRM;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportComplaint;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportContactInfo;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportCustomer;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportResult;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportTimeLapse;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportTrade;
import com.terralcode.gestion.domain.integration.customerxml_oze.Finca;
import com.terralcode.gestion.domain.integration.customerxml_oze.Venta;
import com.terralcode.gestion.domain.sales.Sales;
import com.terralcode.gestion.domain.trade.Trade;
import com.naoset.framework.business.commons.timing.TimeLapseService;
import com.naoset.framework.business.company.relationship.customer.CustomerStatusService;
import com.naoset.framework.business.company.relationship.customer.CustomerTypeService;
import com.naoset.framework.business.service.user.UserService;
import com.terralcode.framework.domain.commons.contactinfo.ContactInfo;
import com.terralcode.framework.domain.commons.contactinfo.ContactType;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import com.naoset.framework.domain.company.relationship.customer.CustomerStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author jmsuarez
 */
@Singleton
public class Integrator {

    @Inject
    UserService userService;
    @Inject
    TradeService tradeService;
    @Inject
    SpeciesService speciesService;
    @Inject
    CustomerStatusService customerStatusService;
    @Inject
    CustomerTypeService customerTypeService;
    @Inject
    CustomerCRMService customerCRMService;
    @Inject
    AppointmentService appointmentService;
    @Inject
    AppointmentStatusService appointmentStatusService;
    @Inject
    AppointmentReasonService appointmentReasonService;
    @Inject
    TimeLapseService timeLapseService;
    @Inject
    ComplaintTypeService complaintTypeService;
    @Inject
    AppointmentTypeService appointmentTypeService;
    @Inject
    ComplaintsService complaintService;
    @Inject
    SalesService salesService;

    public void integrate(Clientes clientes) {

        Boolean migrateCustomer = false;
        CustomerCRM customer;
        PlainAddress plainAddress;
        List<PlainAddress> plainAddressesFound;
        List<Finca> fincasFound;
        List<Cliente> clientesFound;
        
        List<ContactInfo> lci;
        List<ContactInfo> contactsFound;

        Calendar cal = Calendar.getInstance(new Locale("es", "ES"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (Cliente cliente : clientes.getCliente()) {

            try {
                cal.setTime(formatter.parse(cliente.getUltimaModificacion()));
            } catch (ParseException ex) {
                Logger.getLogger(Integrator.class.getName()).log(Level.SEVERE, null, ex);
            }

            customer = customerCRMService.findByExternalId(cliente.getId());
            if (customer != null) {
//                migrateCustomer = customer.getLastUpdate().before(cal);
                migrateCustomer = true;
            } else {
                customer = customerCRMService.newEntity();
                migrateCustomer = true;
            }

            if (migrateCustomer) {

                customer.setExternalId(cliente.getId());
//                customer.setLastUpdate((Calendar) cal.clone());
                customer.setCode(cliente.getCodigo());
                customer.setCompanyTaxCode(cliente.getCIF());
                customer.setName(cliente.getClienteNombreComercial());

                //Estado
                CustomerStatus customerStatus = null;
                switch(cliente.getClienteEstado()){
                    case "1":
                        customerStatus = customerStatusService.findByCode("CNC");
                        break;
                    case "2":
                        customerStatus = customerStatusService.findByCode("CO");
                        break;
                    case "3":
                        customerStatus = customerStatusService.findByCode("CC");
                        break;
                    case "4":
                        customerStatus = customerStatusService.findByCode("CPRU");
                        break;
                    case "5":
                        customerStatus = customerStatusService.findByCode("CPER");
                        break;
                    case "6":
                        customerStatus = customerStatusService.findByCode("CP");
                        break;
                }
                if(customerStatus != null){
                    customer.setCustomerStatus(customerStatus);
                }
                customer.setPrestige(cliente.getClienteImagenSN().equals("1"));
                customer.setExclusive(cliente.getClienteExclusSN().equals("1"));
                customer.setCanGrow(cliente.getClienteCrecerSN().equals("1"));
                customer.setConsultingLevel(cliente.getClienteNivelAsesora());
                customer.setSalesLevel(cliente.getClienteNivelVenta());
                
                if (!cliente.getClienteTelefono1().isEmpty()){
                    lci = this.parseContacts(cliente.getClienteTelefono1());
                    for (ContactInfo c: lci){
                        if (!c.getInfo().isEmpty()) {
                            contactsFound = customer.getContactInfoList().stream().filter(a -> a.getInfo().equals(c.getInfo())).collect(Collectors.toList());
                            if (contactsFound.isEmpty()) {
                                if(c.getContactPerson().isEmpty()){
                                    c.setContactPerson("TLF1");
                                }
                                customer.getContactInfoList().add(c);
                            }
                        }
                    }
                }
                if (!cliente.getClienteTelefono2().isEmpty()){
                    lci = this.parseContacts(cliente.getClienteTelefono2());
                    for (ContactInfo c: lci){
                        if (!c.getInfo().isEmpty()) {
                            contactsFound = customer.getContactInfoList().stream().filter(a -> a.getInfo().equals(c.getInfo())).collect(Collectors.toList());
                            if (contactsFound.isEmpty()) {
                                if(c.getContactPerson().isEmpty()){
                                    c.setContactPerson("TLF2");
                                }
                                customer.getContactInfoList().add(c);
                            }
                        }
                    }
                }
                
                
                plainAddressesFound = customer.getAddressList().stream().filter(a -> a.getDefaultValue()).collect(Collectors.toList());
                if (plainAddressesFound.isEmpty()) {
                    plainAddress = new PlainAddress();
                    plainAddress.setDefaultValue(Boolean.TRUE);
                    plainAddress.setExternalId("0");
                    customer.getAddressList().add(plainAddress);
                } else {
                    plainAddress = plainAddressesFound.get(0);
                }
                plainAddress.setAddressLine1("[SEDE] " + Optional.ofNullable(cliente.getClienteDireccion()).orElse(""));
                plainAddress.setPostalCode(cliente.getClienteCodigoPostal());
                plainAddress.setCity(cliente.getClienteCiudad());
                plainAddress.setProvince(cliente.getClienteProvincia());
                //plainAddress.setCountry(cliente.getClientePais());

                for (Finca finca : cliente.getFincas().getFinca()) {
                    if (finca.getId() != null) {
                        plainAddressesFound = customer.getAddressList().stream().filter(a -> a.getExternalId().equals(finca.getId())).collect(Collectors.toList());
                        if (plainAddressesFound.isEmpty()) {
                            plainAddress = new PlainAddress();
                            customer.getAddressList().add(plainAddress);
                        } else {
                            plainAddress = plainAddressesFound.get(0);
                        }
                        plainAddress.setExternalId(finca.getId());
                        plainAddress.setDefaultValue(false);
                        
                        plainAddress.setAddressLine1("[" + finca.getFincaNombre() + "] " + finca.getFincaDireccion());
                        //plainAddress.setPostalCode(finca.getFincaCodigoPostal());
                        plainAddress.setCity(finca.getFincaCiudad());
                        plainAddress.setProvince(finca.getFincaProvincia());
                        //plainAddress.setCountry(finca.getFincaPais()); 
                        
                        if (!finca.getFincaTelefono().isEmpty()){
                            lci = this.parseContacts(finca.getFincaTelefono());
                            for (ContactInfo c: lci){
                                if (!c.getInfo().isEmpty()) {
                                    contactsFound = customer.getContactInfoList().stream().filter(a -> a.getInfo().equals(c.getInfo())).collect(Collectors.toList());
                                    if (contactsFound.isEmpty()) {
                                        if(c.getContactPerson().isEmpty()){
                                            c.setContactPerson(finca.getFincaNombre());
                                        }
                                        customer.getContactInfoList().add(c);
                                    }
                                }
                            }
                        }
                        
                    }
                    
                }

                //Borrar las direcciones que ya no existan
                for (PlainAddress pa : customer.getAddressList().stream().filter(a -> (a.getExternalId() != null) && (!"0".equals(a.getExternalId()))).collect(Collectors.toList())) {
                    fincasFound = cliente.getFincas().getFinca().stream().filter(f -> (f.getId() != null) && (f.getId().equals(pa.getExternalId()))).collect(Collectors.toList());
                    if (fincasFound.isEmpty()) {
                        //Borrar pa
                        ;
                    }
                }

                //Borrar y recargar las tres últimas ventas
                customer.getSales().clear();
                //customer.getSales().removeAll(customer.getSales());
                //customer.getSales().removeIf(a -> (a.getId() > 0));
                for (Venta venta : cliente.getUltimasVentas().getVenta()) {
                    if (venta.getFecha() != null) {
                        Sales sale = new Sales();

                        sale.setCustomer(customer);
                        try {
                            cal.setTime(formatter.parse(venta.getFecha()));
                        } catch (ParseException ex) {
                            Logger.getLogger(Integrator.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        sale.setDateSale((Calendar) cal.clone());
                        sale.setDescription(venta.getVentaContenido());

                        customer.getSales().add(sale);
                    }
                }

                customer = customerCRMService.editWithinSyncSession(customer);
            }

        }

        //Borrar los clientes que ya no existan
        for (CustomerCRM externalCustomer : customerCRMService.findAll().stream().filter(c -> c.getExternalId() != null).collect(Collectors.toList())) {
            clientesFound = clientes.getCliente().stream().filter(c -> c.getId().equals(externalCustomer.getExternalId())).collect(Collectors.toList());
            if (clientesFound.isEmpty()) {
                //Borrar externalCustomer

            }
        }
    }
    
    public ExportCRM export(Date startDate)
    {
        ExportCRM exp = new ExportCRM();
        
        Calendar desde = java.util.Calendar.getInstance();
        desde.setTime(startDate);
        //Calendar hasta = (Calendar)desde.clone();
        //desde.add(java.util.Calendar.DAY_OF_MONTH, -7);
        //hasta.add(java.util.Calendar.MONTH, +6);
        
        List<Appointment> appointments = appointmentService.findModifications(desde);
        for (Appointment appointment : appointments) {
            ExportAppointment expApp = new ExportAppointment();
            
            expApp.setId(appointment.getId().toString());
            expApp.setExternalId(appointment.getExternalId());
            
            expApp.setReasonCode(appointment.getAppointmentReason().getCode());
            ExportCustomer expCust = new ExportCustomer();
                expCust.setId(appointment.getCustomer().getId().toString());
                expCust.setExternalId(appointment.getCustomer().getExternalId());
                expCust.setCode(appointment.getCustomer().getCode());
                expCust.setName(appointment.getCustomer().getName());
            expApp.setCustomer(expCust);
            
            ExportAddress expAdd = new ExportAddress();
            expAdd.setExternalId(appointment.getAddress().getExternalId());
            expAdd.setInfo(appointment.getAddress().toString());
            expApp.setAddress(expAdd);
            
            if (appointment.getContactInfo() != null) {
                ExportContactInfo expCont = new ExportContactInfo();
                expCont.setId(appointment.getContactInfo().getId().toString());
                expCont.setExternalId(appointment.getContactInfo().getExternalId());
                expCont.setPerson(appointment.getContactInfo().getContactPerson());
                expCont.setInfo(appointment.getContactInfo().getInfo());
                
                expApp.setContactInfo(expCont);
            }
            
            expApp.setContactNotes(appointment.getContactNotes());
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = appointment.getProgramDateStart().getTime();
            expApp.setStart(formatter.format(d));
            for (Trade trade: appointment.getTrades()){
                ExportTrade expTrade = new ExportTrade();
                expTrade.setId(trade.getId().toString());
                expTrade.setExternalId(trade.getExternalId());
                expTrade.setUserCode(trade.getUser().getId().toString());
                expTrade.setName(trade.getName());
                
                expApp.getTrades().add(expTrade);
            }
            if (appointment.getTimeLapse() != null) {
                ExportTimeLapse expTimeLapse = new ExportTimeLapse();
                expTimeLapse.setId(appointment.getTimeLapse().getId().toString());
                expTimeLapse.setExternalId(appointment.getTimeLapse().getExternalId());
                expTimeLapse.setCode(appointment.getTimeLapse().getCode());
                expTimeLapse.setName(appointment.getTimeLapse().getName());
                
                expApp.setTimeLapse(expTimeLapse);
            }
            
            expApp.setDistance(appointment.getDistance());
            
            expApp.setNotes(appointment.getNotes());
            
            for(AppointmentPurpose appPur: appointment.getPurposes()){
                ExportResult expRes = new ExportResult();
                expRes.setId(appPur.getId().toString());
                expRes.setExternalId(appPur.getExternalId());
                expRes.setCode(appPur.getCode());
                expRes.setName(appPur.getName());
                
                expApp.getResults().add(expRes);
            }
            
            for(Complaint comp: appointment.getComplaints()){
                ExportComplaint expComp = new ExportComplaint();
                expComp.setId(comp.getId().toString());
                expComp.setExternalId(comp.getExternalId());
                expComp.setTypeCode(comp.getComplaintType().getCode());
                expComp.setName(comp.getName());
                expComp.setNotes(comp.getNotes());
                
                expApp.getComplaints().add(expComp);
            }
            
            expApp.setStatusCode(appointment.getStatus().getCode());
            expApp.setStatusNotes(appointment.getStatusNotes());
            
            exp.getAppointments().add(expApp);
        }
        
        return exp;
    }
    
    private List<ContactInfo> parseContacts(String parse)
    {
        List<ContactInfo> contacts = new ArrayList<ContactInfo>();
        ContactInfo newContact = new ContactInfo();
        String readingMode = "NONE";
        String name = "";
        String phone = "";
        
        newContact.setContactType(ContactType.Telephone);
        
        for (char c : parse.toCharArray()) {
            
            switch (readingMode){
                case "NONE":
                    if (!Character.isSpaceChar(c)){
                        if (Character.isDigit(c)){
                            readingMode = "PHONE";
                            newContact.setInfo(newContact.getInfo() + String.valueOf(c));
                        } else
                        {
                            readingMode = "NAME";
                            newContact.setContactPerson(newContact.getContactPerson() + String.valueOf(c));
                        }
                    }
                    break;
                case "NAME":
                    if (!Character.isSpaceChar(c)){
                        if (Character.isDigit(c)){
                            readingMode = "PHONE";
                            if (!newContact.getInfo().isEmpty()){
                                contacts.add(newContact);
                                newContact = new ContactInfo();
                                newContact.setContactType(ContactType.Telephone);
                            }
                            newContact.setInfo(newContact.getInfo() + String.valueOf(c));
                        } else
                        {
                            newContact.setContactPerson(newContact.getContactPerson() + String.valueOf(c));
                        }
                    } else
                    {
                        newContact.setContactPerson(newContact.getContactPerson() + String.valueOf(c));
                    }
                    break;
                case "PHONE":
                     if (!Character.isSpaceChar(c)){
                        if (Character.isDigit(c)){
                            newContact.setInfo(newContact.getInfo() + String.valueOf(c));
                        } else
                        {
                            readingMode = "NAME";
                            if (!newContact.getContactPerson().isEmpty()){
                                contacts.add(newContact);
                                newContact = new ContactInfo();
                                newContact.setContactType(ContactType.Telephone);
                            }
                            newContact.setContactPerson(newContact.getContactPerson() + String.valueOf(c));
                        }
                    }  
                    break;
            }
            
            
        }
        
        if(!newContact.getContactPerson().isEmpty() || !newContact.getInfo().isEmpty()){
            contacts.add(newContact);
        }
        
        return contacts;
    }
    
    
}
