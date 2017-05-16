/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.syncEngine;

import com.terralcode.framework.domain.DomainEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jmsuarez
 */
@Entity
public class SyncSession extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String code = "";
    protected Calendar startTime;
    protected Calendar endTime;
    protected SyncSessionState state;
    protected String rawData;
    
    protected List<ChangeLog> changes = new ArrayList<>();

    public SyncSession() {
        super();
        this.startTime = Calendar.getInstance();
        this.state = SyncSessionState.Opened;
    }

    public SyncSession(String code) {
        this();
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    @NotNull
    public SyncSessionState getState() {
        return state;
    }

    public void setState(SyncSessionState state) {
        this.state = state;
    }

    @Lob
    @Basic(fetch = FetchType.EAGER)
    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    @OneToMany(mappedBy = "syncSession", cascade = CascadeType.ALL, orphanRemoval=true)
    @Basic(fetch = FetchType.EAGER)
    public List<ChangeLog> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeLog> changes) {
        this.changes = changes;
    }

    public ChangeLog findCRMChange(String entityName, Long entityIdCRM){
        ChangeLog result = null;
        List<ChangeLog> found = 
                changes.stream().filter(c -> 
                        (c.getEntityName().equals(entityName)) && 
                        (c.getEntityIdCRM().equals(entityIdCRM))
                                        ).collect(Collectors.toList());
        if (!found.isEmpty()) {
            result = found.get(0);
        }
        return result;
    }
    
    public ChangeLog findGuestChange(String entityName, String entityIdGuest){
        ChangeLog result = null;
        List<ChangeLog> found = 
                changes.stream().filter(c -> 
                        (c.getEntityName().equals(entityName)) && 
                        (c.getEntityIdGuest().equals(entityIdGuest))
                                        ).collect(Collectors.toList());
        if (!found.isEmpty()) {
            result = found.get(0);
        }
        return result;
    }
    
    public void addChange(ChangeLog change){
        //Search for same Entity and EntityIdCRM.
        //if found, compare LastUpdate. Only latter updates will prevail
        List<ChangeLog> found = 
                changes.stream().filter(c -> 
                        (c.getEntityName().equals(change.getEntityName())) && 
                        (c.getEntityIdCRM().equals(change.getEntityIdCRM()))
                                        ).collect(Collectors.toList());
        if (found.isEmpty()) {
            change.setSyncSession(this);
            changes.add(change);
        } else
        {
            ChangeLog registered = found.get(0);
            if (registered.getUpdateTime().before(change.getUpdateTime())) {
                registered.setOperation(change.getOperation());
                registered.setEntityIdGuest(change.getEntityIdGuest());
                registered.setUpdateTime((Calendar)change.getUpdateTime().clone());
            }
        }
    }
    
    public enum SyncSessionState {
        Opened,
        Closed
    }
}
