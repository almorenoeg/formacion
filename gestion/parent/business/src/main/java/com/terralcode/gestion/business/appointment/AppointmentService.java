/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.business.appointment;

import com.terralcode.gestion.business.syncEngine.ChangeLogService;
import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.converters.AppointmentToNotifications;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.syncEngine.ChangeLog;
import com.terralcode.gestion.domain.syncEngine.integration.SyncEngineAppointment;
import com.terralcode.gestion.domain.trade.Trade;
import com.naoset.framework.business.commons.crud.CRUD;
import com.naoset.framework.business.notification.NotificationService;
import com.naoset.framework.business.service.user.UserService;
import com.naoset.framework.domain.commons.timing.TimeLapseCalculator;
import com.naoset.framework.domain.company.relationship.customer.Customer;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 *
 * @author jmsuarez
 */
@Stateless
public class AppointmentService extends CRUD<Appointment> {

    @Inject
    AppointmentTypeService appointmentTypeService;
    @Inject
    AppointmentStatusService appointmentStatusService;
    @Inject
    NotificationService notificationService;
    @Inject
    UserService userService;
    @Inject
    ChangeLogService changeLogService;

    @Override
    public Appointment newEntity() {
        Appointment entity = super.newEntity(); //To change body of generated methods, choose Tools | Templates.

        entity.setAppointmentType(appointmentTypeService.findByCode("VIS"));
        entity.setStatus(appointmentStatusService.findByCode("PRG"));
        entity.setNotifyChanges(Boolean.FALSE);

        return entity;
    }

    @Override
    public Appointment create(Appointment entity) {
        
        entity.setLastUpdate(java.util.Calendar.getInstance());
        
        entity = super.create(entity);

        //Log change...
        ChangeLog changeLog = changeLogService.newEntity();
        changeLog.setEntityName("Appointment");
        changeLog.setOperation(ChangeLog.ChangeLogOperation.CRM_CREATION);
        changeLog.setEntityIdCRM(entity.getId());
        changeLog.setEntityIdGuest(entity.getExternalId());
        changeLogService.create(changeLog);

        if (entity.getNotifyChanges()) {
            new AppointmentToNotifications()
                    .apply(entity)
                    .forEach((notification) -> notificationService.create(notification));
        }

        return entity;
    }

    public Appointment createWithinSyncSession(Appointment entity) {
        //To be used withing a Synchronization Session. No log change nor notifications...
        entity = super.create(entity);
        return entity;
    }

    @Override
    public Appointment edit(Appointment entity) {
        entity.setLastUpdate(java.util.Calendar.getInstance());
        
        entity = super.edit(entity);

        //Log change...
        ChangeLog changeLog = changeLogService.newEntity();
        changeLog.setEntityName("Appointment");
        changeLog.setOperation(ChangeLog.ChangeLogOperation.CRM_MODIFICATION);
        changeLog.setEntityIdCRM(entity.getId());
        changeLog.setEntityIdGuest(entity.getExternalId());
        changeLogService.create(changeLog);

        if (entity.getNotifyChanges()) {
            new AppointmentToNotifications()
                    .apply(entity)
                    .forEach((notification) -> notificationService.create(notification));
        }

        return entity;
    }

    public Appointment editWithinSyncSession(Appointment entity) {
        //To be used withing a Synchronization Session. No log change nor notifications...
        entity = super.edit(entity);
        return entity;
    }

    @Override
    public void remove(Appointment entity) {
        super.remove(entity);

        //Log change...
        ChangeLog changeLog = changeLogService.newEntity();
        changeLog.setEntityName("Appointment");
        changeLog.setOperation(ChangeLog.ChangeLogOperation.CRM_DELETION);
        changeLog.setEntityIdCRM(entity.getId());
        changeLog.setEntityIdGuest(entity.getExternalId());
        changeLogService.create(changeLog);
    }

    public void removeWithinSyncSession(Appointment entity) {
        //To be used withing a Synchronization Session. No log change nor notifications...
        super.remove(entity);
    }

    public List<Appointment> find(Calendar startDate, Calendar endDate) {
        String sentence = "SELECT appointment FROM Appointment appointment "
                + "WHERE appointment.programDateStart >= :programDateStart AND appointment.programDateEnd <= :programDateEnd";

        Query query = getEntityManager().createQuery(sentence);
        query.setParameter("programDateStart", startDate);
        query.setParameter("programDateEnd", endDate);

        return query.getResultList();
    }

    public List<Appointment> findModifications(Calendar startDate) {
        String sentence = "SELECT appointment FROM Appointment appointment "
                + "WHERE appointment.lastUpdate >= :startDate";

        Query query = getEntityManager().createQuery(sentence);
        query.setParameter("startDate", startDate);
        

        return query.getResultList();
    }
    
    public List<Appointment> findByTrade(Trade trade, Calendar startDate, Calendar endDate) {
        String sql = "SELECT distinct Appointment.* "
                + "FROM Appointment "
                + "inner join Appointment_Trade on Appointment.id = Appointment_Trade.Appointment_id "
                + "where "
                + "Appointment.programDateStart >= :programDateStart AND "
                + "Appointment.programDateEnd <= :programDateEnd AND "
                + "Appointment_Trade.trades_id = :trade_id";

        Query query = getEntityManager().createNativeQuery(sql, Appointment.class);
        query.setParameter("programDateStart", startDate);
        query.setParameter("programDateEnd", endDate);
        query.setParameter("trade_id", trade.getId());

        return query.getResultList();
    }
    
    public List<Appointment> findByCustomer(CustomerCRM customer, Calendar startDate, Calendar endDate) {
        String sql = "SELECT distinct Appointment.* "
                + "FROM Appointment "
                + "where "
                + "Appointment.programDateStart >= :programDateStart AND "
                + "Appointment.programDateEnd <= :programDateEnd AND "
                + "Appointment.customer_id = :customer_id";

        Query query = getEntityManager().createNativeQuery(sql, Appointment.class);
        query.setParameter("programDateStart", startDate);
        query.setParameter("programDateEnd", endDate);
        query.setParameter("customer_id", customer.getId());

        return query.getResultList();
    }

    public Appointment duplicate(Appointment source, Calendar newDate) throws InstantiationException, IllegalAccessException {
        TimeLapseCalculator calculator = new TimeLapseCalculator();
        Appointment copy = this.newEntity();

        copy.setCustomer(source.getCustomer());
        copy.setAddress(source.getAddress());
        copy.setProgramDateStart(newDate);
        copy.setTimeLapse(source.getTimeLapse());
        copy.setProgramDateEnd(calculator.calculateLapse(newDate, copy.getTimeLapse()));
        copy.setAppointmentType(source.getAppointmentType());
        copy.setContactInfo(source.getContactInfo());
        copy.setAppointmentReason(source.getAppointmentReason());
        copy.setReasonNotes(source.getReasonNotes());
        copy.getTrades().addAll(source.getTrades());
        copy.setNotes(source.getNotes());
        copy.setStatusNotes(source.getStatusNotes());

        return create(copy);
    }

    public Appointment buildFromXml(SyncEngineAppointment external) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SyncEngineAppointment exportToXml(Appointment appointment){
        SyncEngineAppointment result = new SyncEngineAppointment();
        
        return result;
    }
}
