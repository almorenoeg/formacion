/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.syncEngine;

import com.terralcode.framework.domain.DomainEntity;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jmsuarez
 */
@Entity
@XmlRootElement
public class ChangeLog extends DomainEntity {
    private static final long serialVersionUID = 1L;
    protected SyncSession syncSession;
    protected ChangeLogOperation operation;
    protected String entityName;
    protected Long entityIdCRM;
    protected String entityIdGuest;
    protected Calendar updateTime;
    
    @ManyToOne
    @XmlTransient
    public SyncSession getSyncSession() {
        return syncSession;
    }

    public void setSyncSession(SyncSession syncSession) {
        this.syncSession = syncSession;
    }

    @NotNull
    @XmlAttribute
    public ChangeLogOperation getOperation() {
        return operation;
    }

    public void setOperation(ChangeLogOperation operation) {
        this.operation = operation;
    }

    @NotEmpty
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @NotNull
    public Long getEntityIdCRM() {
        return entityIdCRM;
    }

    public void setEntityIdCRM(Long entityIdCRM) {
        this.entityIdCRM = entityIdCRM;
    }

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
    
    public void afterUnmarshal(Unmarshaller u, Object parent){
        this.syncSession = (SyncSession)parent;
    }
    
    public enum ChangeLogOperation{
        CRM_CREATION,
        CRM_MODIFICATION,
        CRM_DELETION,
        GUEST_CREATION,
        GUEST_MODIFICATION,
        GUEST_DELETION
    }
}
