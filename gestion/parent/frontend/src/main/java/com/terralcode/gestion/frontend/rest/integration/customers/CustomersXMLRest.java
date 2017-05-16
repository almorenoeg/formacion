package com.terralcode.gestion.frontend.rest.integration.customers;

import com.terralcode.gestion.business.customer.CustomerCRMService;
import com.terralcode.gestion.business.integration.Integrator;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.integration.customerxml_oze.Clientes;
import com.terralcode.gestion.domain.integration.customerxml_oze.ExportCRM;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ezequiel
 */
//@Path("customersXML")
//@Stateless
//@Produces("application/xml; charset=ISO-8859-1")
//@Consumes("application/xml; charset=ISO-8859-1")
public class CustomersXMLRest {

//    @Inject
//    CustomerCRMService customerService;
//    
////    @Inject
////    CustomerStatusService customerStatusService;
//
//    @Inject
//    Integrator integrator;
//    
//    @POST
//    @Path("/downloadAppointments")
//    public ExportCRM getExport(String startDate)
//    {
//        Calendar cal = Calendar.getInstance(new Locale("es", "ES"));
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        
//        try {
//            cal.setTime(formatter.parse(startDate));
//        } catch (ParseException ex) {
//            Logger.getLogger(Integrator.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return integrator.export(cal.getTime());
//    }
//    
////    @GET
////    public List<CustomerCRM> getAllCustomers()
////    {
////        return customerService.findAll();
////    }
//
//    @POST
//    @Path("/uploadAll")
//    public ExportCRM saveClientesFincas(Clientes clientes)
//    {
//        integrator.integrate(clientes);
//        return new ExportCRM();
//        
////        CustomerStatus statusClienteComercial = customerStatusService.findByCode("CC");
////        
////        for (Cliente c : clientes.getCliente()) {
////            CustomerCRM customer = ClienteToCustomerConverter.convert(c);
////            customer.setCustomerStatus(statusClienteComercial);
////            customerService.create(customer);
////        }
////        /*clientes.getCliente()
////                .parallelStream()
////                .map(ClienteToCustomerConverter::convert)
////                .forEach(customerService::create);        */
//    }

}
