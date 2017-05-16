/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.syncEngine.integration;

import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.syncEngine.ChangeLog;
import com.terralcode.framework.domain.DomainEntity;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jmsuarez
 */
@XmlRootElement
public class SyncEngineChange {

    protected SyncEngineChangeOperation operation;
    protected String entityName;
    protected Long entityIdCRM;
    protected String entityIdGuest;
    protected Calendar updateTime;
    
    protected SyncEngineAppointment appointment;
    protected SyncEngineCustomer customer;
    
    public SyncEngineChange() {

    }

    public SyncEngineChange(ChangeLog changeLog) {
        this();
        ChangeLog.ChangeLogOperation clo = changeLog.getOperation();
        if (clo.equals(ChangeLog.ChangeLogOperation.CRM_CREATION) || clo.equals(ChangeLog.ChangeLogOperation.GUEST_CREATION)) {
            this.operation = SyncEngineChangeOperation.CREATION;
        }
        if (clo.equals(ChangeLog.ChangeLogOperation.CRM_MODIFICATION) || clo.equals(ChangeLog.ChangeLogOperation.GUEST_MODIFICATION)) {
            this.operation = SyncEngineChangeOperation.MODIFICATION;
        }
        if (clo.equals(ChangeLog.ChangeLogOperation.CRM_DELETION) || clo.equals(ChangeLog.ChangeLogOperation.GUEST_DELETION)) {
            this.operation = SyncEngineChangeOperation.DELETION;
        }
        this.entityName = changeLog.getEntityName();
        this.entityIdCRM = changeLog.getEntityIdCRM();
        this.entityIdGuest = changeLog.getEntityIdGuest();
        this.updateTime = (Calendar) changeLog.getUpdateTime().clone();
    }

    @NotNull
    @XmlAttribute
    public SyncEngineChangeOperation getOperation() {
        return operation;
    }

    public void setOperation(SyncEngineChangeOperation operation) {
        this.operation = operation;
    }

    @NotEmpty
    @XmlAttribute
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @NotNull
    @XmlAttribute
    public Long getEntityIdCRM() {
        return entityIdCRM;
    }

    public void setEntityIdCRM(Long entityIdCRM) {
        this.entityIdCRM = entityIdCRM;
    }

    @XmlAttribute
    public String getEntityIdGuest() {
        return entityIdGuest;
    }

    public void setEntityIdGuest(String entityIdGuest) {
        this.entityIdGuest = entityIdGuest;
    }

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute
    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }
    
    public SyncEngineAppointment getAppointment() {
        return appointment;
    }

    public void setAppointment(SyncEngineAppointment appointment) {
        this.appointment = appointment;
    }

    public SyncEngineCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SyncEngineCustomer customer) {
        this.customer = customer;
    }
    
    

    
    public enum SyncEngineChangeOperation{
        CREATION,
        MODIFICATION,
        DELETION
    }
}
