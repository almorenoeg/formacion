/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.rest.syncEngine;

import com.terralcode.gestion.business.appointment.AppointmentService;
import com.terralcode.gestion.business.customer.CustomerCRMService;
import com.terralcode.gestion.business.syncEngine.SyncSessionService;
import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.syncEngine.ChangeLog;
import com.terralcode.gestion.domain.syncEngine.ChangeLog.ChangeLogOperation;
import com.terralcode.gestion.domain.syncEngine.SyncSession;
import com.terralcode.gestion.domain.syncEngine.integration.SyncEngineAppointment;
import com.terralcode.gestion.domain.syncEngine.integration.SyncEngineChange;
import com.terralcode.gestion.domain.syncEngine.integration.SyncEngineCustomer;
import com.terralcode.gestion.domain.syncEngine.integration.SyncEngineMessage;
import com.terralcode.gestion.domain.syncEngine.integration.SyncEngineMessage.SyncEngineMessageOperation;
import com.terralcode.framework.domain.DomainEntity;
import java.io.StringWriter;
import java.util.Calendar;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author jmsuarez
 */
//@Path("syncEngine")
//@Stateless
//@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class SyncEngineRest {

//    @Inject
//    SyncSessionService syncSessionService;
//
//    @Inject
//    CustomerCRMService customerCRMService;
//    
//    @Inject
//    AppointmentService appointmentService;
//
//    @GET
//    @Path("/test")
//    public SyncEngineMessage test() {
//        SyncEngineMessage result = new SyncEngineMessage();
//
//        return result;
//    }
//
//    @POST
//    @Path("/openSession")
//    public SyncEngineMessage openSession(SyncEngineMessage syncSessionMessage) {
//        //Expected: SyncSessionMessage with OpenSession Operation
//        SyncEngineMessage result = new SyncEngineMessage();
//        result.setOperation(SyncEngineMessage.SyncEngineMessageOperation.OPERATION_REPLY_OPEN_SESSION);
//        result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_NO_ERROR);
//
//        if (syncSessionMessage.getOperation().equals(SyncEngineMessageOperation.OPERATION_OPEN_SESSION)) {
//
//            //There must be only one opened session
//            SyncSession session = syncSessionService.findOpen();
//            if (session == null) {
//
//                session = syncSessionService.newEntity();
//                session = syncSessionService.create(session);
//                result.setSessionCode(session.getCode());
//
//            } else {
//                result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_SESSION_ALREADY_OPENED);
//                result.setErrorDescription("Ya hay una sesión de sincronización en curso");
//            }
//
//        } else {
//            result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_MESSAGE_INVALID);
//            result.setErrorDescription("El mensaje no corresponde a este servicio");
//        }
//
//        return result;
//    }
//
//    @POST
//    @Path("/exchangeData")
//    public SyncEngineMessage exchangeData(SyncEngineMessage syncSessionMessage) {
//        //Expected: SyncSessionMessage with ExchangeData Operation
//        SyncEngineMessage result = new SyncEngineMessage();
//        result.setOperation(SyncEngineMessage.SyncEngineMessageOperation.OPERATION_REPLY_EXCHANGE_DATA);
//        result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_NO_ERROR);
//
//        if (syncSessionMessage.getOperation().equals(SyncEngineMessageOperation.OPERATION_EXCHANGE_DATA)) {
//
//            SyncSession session = syncSessionService.findOpen();
//            if ((session != null) && (session.getCode().equals(syncSessionMessage.getSessionCode()))) {
//
//                result.setSessionCode(session.getCode());
//
//                //Save remote changes in xml format for future reference
//                try {
//                    StringWriter writer = new StringWriter();
//                    JAXBContext context = JAXBContext.newInstance(SyncEngineChange.class);
//                    Marshaller m = context.createMarshaller();
//                    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//                    m.marshal(syncSessionMessage.getSyncSessionChanges(), writer);
//                    session.setRawData(writer.toString());
//                } catch (Exception e) {
//                }
//
//                //Process remote changes
//                for (SyncEngineChange changeLog : syncSessionMessage.getSyncSessionChanges()) {
//                    
//                    Boolean mustAcquireChange = true;
//                    String entityName = changeLog.getEntityName();
//                    Long entityIdCRM = changeLog.getEntityIdCRM();
//                    Calendar cal = changeLog.getUpdateTime();
//                    
//                    //Look for the same entity in our changeLog. Only latter will prevail
//                    if (entityIdCRM != null) {
//                        ChangeLog myLocalChangeLog = session.findCRMChange(entityName, entityIdCRM);
//                        if ((myLocalChangeLog != null) && myLocalChangeLog.getUpdateTime().after(cal)){
//                            mustAcquireChange = false;
//                        }
//                    }
//                    
//                    if (mustAcquireChange) {
//                        acquireRemoteChange(changeLog, session);
//                    }
//                }
//
//                //Collect and return local changes
//                for (ChangeLog changeLog : session.getChanges()) {
//                    if ((changeLog.getOperation().equals(ChangeLogOperation.CRM_CREATION)) ||
//                        (changeLog.getOperation().equals(ChangeLogOperation.CRM_MODIFICATION)) ||
//                        (changeLog.getOperation().equals(ChangeLogOperation.CRM_DELETION))){
//
//                        SyncEngineChange sessionChange = new SyncEngineChange(changeLog);
//                        if (!sessionChange.getOperation().equals(ChangeLogOperation.CRM_DELETION)) {
//                            if (sessionChange.getEntityName().equals("Appointment")) {
//                                Appointment app = appointmentService.find(sessionChange.getEntityIdCRM());
//                                SyncEngineAppointment syncApp = appointmentService.exportToXml(app);
//                                sessionChange.setAppointment(syncApp);
//                            }
//                        }
//                        result.getSyncSessionChanges().add(sessionChange);
//                    }
//                }
//
//            } else {
//                result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_SESSION_INVALID);
//                result.setErrorDescription("La sesión de sincronización no es válida");
//            }
//
//        } else {
//            result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_MESSAGE_INVALID);
//            result.setErrorDescription("El mensaje no corresponde a este servicio");
//        }
//
//        return result;
//    }
//
//    @POST
//    @Path("/exchangeResults")
//    public SyncEngineMessage exchangeResults(SyncEngineMessage syncSessionMessage) {
//        SyncEngineMessage result = new SyncEngineMessage();
//        return result;
//    }
//
//    @POST
//    @Path("/closeSession")
//    public SyncEngineMessage closeSession(SyncEngineMessage syncSessionMessage) {
//        //Expected: SyncSessionMessage with CloseSession Operation
//        SyncEngineMessage result = new SyncEngineMessage();
//        result.setOperation(SyncEngineMessage.SyncEngineMessageOperation.OPERATION_REPLY_CLOSE_SESSION);
//        result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_NO_ERROR);
//
//        if (syncSessionMessage.getOperation().equals(SyncEngineMessageOperation.OPERATION_CLOSE_SESSION)) {
//
//            SyncSession session = syncSessionService.findOpen();
//            if ((session != null) && (session.getCode().equals(syncSessionMessage.getSessionCode()))) {
//
//                session.setEndTime(Calendar.getInstance());
//                session.setState(SyncSession.SyncSessionState.Closed);
//                syncSessionService.edit(session);
//
//            } else {
//                result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_SESSION_INVALID);
//                result.setErrorDescription("La sesión de sincronización no es válida");
//            }
//
//        } else {
//            result.setError(SyncEngineMessage.SyncEngineMessageError.ERROR_MESSAGE_INVALID);
//            result.setErrorDescription("El mensaje no corresponde a este servicio");
//        }
//
//        return result;
//    }
//
//    private void acquireRemoteChange(SyncEngineChange changeLog, SyncSession session) {
//        ChangeLog newChange = new ChangeLog();
//        
//        newChange.setEntityName(changeLog.getEntityName());
//        if (changeLog.getOperation().equals(SyncEngineChange.SyncEngineChangeOperation.CREATION)) {
//            newChange.setOperation(ChangeLogOperation.GUEST_CREATION);
//        }
//        if (changeLog.getOperation().equals(SyncEngineChange.SyncEngineChangeOperation.MODIFICATION)) {
//            newChange.setOperation(ChangeLogOperation.GUEST_MODIFICATION);
//        }
//        if (changeLog.getOperation().equals(SyncEngineChange.SyncEngineChangeOperation.DELETION)) {
//            newChange.setOperation(ChangeLogOperation.GUEST_DELETION);
//        }
//        newChange.setEntityIdCRM(changeLog.getEntityIdCRM());
//        newChange.setEntityIdGuest(changeLog.getEntityIdGuest());
//        newChange.setUpdateTime((Calendar)changeLog.getUpdateTime().clone());
//        
//                
//        //Do the creation/modification/deletion of the entiy
//        DomainEntity newEntity = null;
//        if (newChange.getEntityName().equals("Appointment")) {
//            newEntity = acquireExternalAppointment(newChange, changeLog.getAppointment());
//        }
//        if (newChange.getEntityName().equals("CustomerCRM")) {
//            newEntity = acquireExternalCustomer(newChange, changeLog.getCustomer());
//        }
//        
//        //Register the newly created local id (if applicable)
//        if (newEntity != null) {
//            newChange.setEntityIdCRM(newEntity.getId());
//        }
//        session.addChange(newChange);
//    }
//
//    private Appointment acquireExternalAppointment(ChangeLog changeLog, SyncEngineAppointment external) {
//        Appointment result = null;
//        
//        if (changeLog.getOperation().equals(ChangeLogOperation.GUEST_DELETION)) {
//            //Delete the Appointment
//            Appointment app = appointmentService.find(changeLog.getEntityIdCRM());
//            if (app != null) {
//                appointmentService.removeWithinSyncSession(app);
//            }
//        } else
//        {
//            Appointment app = appointmentService.buildFromXml(external);
//            result = appointmentService.editWithinSyncSession(app);
//        }
//        
//        return result;
//    }
//    
//    private CustomerCRM acquireExternalCustomer(ChangeLog changeLog, SyncEngineCustomer external) {
//        CustomerCRM result = null;
//        
//        if (changeLog.getOperation().equals(ChangeLogOperation.GUEST_DELETION)) {
//            //Delete the Customer
//            CustomerCRM cus = customerCRMService.find(changeLog.getEntityIdCRM());
//            if (cus != null) {
//                customerCRMService.removeWithinSyncSession(cus);
//            }
//        } else
//        {
//            CustomerCRM cus = customerCRMService.buildFromXml(external);
//            result = customerCRMService.editWithinSyncSession(cus);
//        }
//        
//        return result;
//    }
}
