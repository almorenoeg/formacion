/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.syncEngine.integration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmsuarez
 */
@XmlRootElement
public class SyncEngineAppointment {
    protected String idCRM;
    protected String idGuest;
    protected String typeCode;
    protected String statusCode;
    protected String reasonCode;
    protected String contactNotes;
    protected String customerId;
    protected String plainAddressId;
    protected Date programDateStart;
    protected Date programDateEnd;
    protected Long distance;
    protected String notes;
    
    protected List<String> trades = new ArrayList<>();
    protected List<SyncEngineComplaint> complaints = new ArrayList<>();

    
    @XmlAttribute
    public String getIdCRM() {
        return idCRM;
    }

    public void setIdCRM(String idCRM) {
        this.idCRM = idCRM;
    }

    @XmlAttribute
    public String getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(String idGuest) {
        this.idGuest = idGuest;
    }

    @XmlAttribute
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @XmlAttribute
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @XmlAttribute
    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getContactNotes() {
        return contactNotes;
    }

    public void setContactNotes(String contactNotes) {
        this.contactNotes = contactNotes;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPlainAddressId() {
        return plainAddressId;
    }

    public void setPlainAddressId(String plainAddressId) {
        this.plainAddressId = plainAddressId;
    }

    public Date getProgramDateStart() {
        return programDateStart;
    }

    public void setProgramDateStart(Date programDateStart) {
        this.programDateStart = programDateStart;
    }

    public Date getProgramDateEnd() {
        return programDateEnd;
    }

    public void setProgramDateEnd(Date programDateEnd) {
        this.programDateEnd = programDateEnd;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlElementWrapper(name="trades")
    @XmlElement(name="trade")
    public List<String> getTrades() {
        return trades;
    }

    public void setTrades(List<String> trades) {
        this.trades = trades;
    }

    @XmlElementWrapper(name="complaints")
    @XmlElement(name="complaint")
    public List<SyncEngineComplaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<SyncEngineComplaint> complaints) {
        this.complaints = complaints;
    }
    
    
    
}
