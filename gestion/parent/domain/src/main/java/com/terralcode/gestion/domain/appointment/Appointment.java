/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.appointment;

import com.terralcode.gestion.domain.customer.CustomerCRM;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.terralcode.gestion.domain.trade.Trade;
import com.terralcode.framework.domain.DomainEntity;
import com.terralcode.framework.domain.commons.contactinfo.ContactInfo;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import com.naoset.framework.domain.commons.timing.TimeLapse;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Álvaro
 */
@Entity
@XmlRootElement
public class Appointment extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected Calendar lastUpdate;
    protected CustomerCRM customer;
    protected Calendar programDateStart;
    protected TimeLapse timeLapse;
    protected Calendar programDateEnd;
    protected AppointmentReason appointmentReason;
    protected PlainAddress address;
    protected ContactInfo contactInfo;
    protected String contactNotes="";
    protected String reasonNotes="";
    protected Integer distance;
    protected List<Trade> trades = new ArrayList<>();
    protected List<AppointmentPurpose> purposes = new ArrayList<>();
    protected String notes="";
    protected List<Complaint> complaints = new ArrayList<>();
    protected AppointmentStatus status;
    protected String statusNotes="";
    protected AppointmentType appointmentType;
    protected Boolean notifyChanges;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Calendar lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @NotNull
    @ManyToOne
    @XmlElement
    @XmlIDREF
    public CustomerCRM getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerCRM customer) {
        this.customer = customer;
    }

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getProgramDateStart() {
        return programDateStart;
    }

    public void setProgramDateStart(Calendar programDateStart) {
        this.programDateStart = programDateStart;
    }

    @ManyToOne
    public TimeLapse getTimeLapse() {
        return timeLapse;
    }

    public void setTimeLapse(TimeLapse timeLapse) {
        this.timeLapse = timeLapse;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getProgramDateEnd() {
        return programDateEnd;
    }

    

    public void setProgramDateEnd(Calendar programDateEnd) {
        this.programDateEnd = programDateEnd;
    }

    @NotNull
    @ManyToOne
    public AppointmentReason getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(AppointmentReason appointmentReason) {
        this.appointmentReason = appointmentReason;
    }

    public String getReasonNotes() {
        return reasonNotes;
    }

    public void setReasonNotes(String reasonNotes) {
        this.reasonNotes = reasonNotes;
    }

    @ManyToOne
    public PlainAddress getAddress() {
        return address;
    }

    public void setAddress(PlainAddress address) {
        this.address = address;
    }

    @ManyToOne
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getContactNotes() {
        return contactNotes;
    }

    public void setContactNotes(String contactNotes) {
        this.contactNotes = contactNotes;
    }
    
    @ManyToMany
    @Basic(fetch = FetchType.EAGER)
    @XmlElementWrapper(name="trades")
    @XmlElement(name="trade")
    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    @Lob
    @Basic(fetch = FetchType.EAGER)
    public String getNotes() {
        return notes;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval=true)
    @Basic(fetch = FetchType.EAGER)
    @XmlElementWrapper(name="complaints")
    @XmlElement(name="complaint")
    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    @OneToOne
    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getStatusNotes() {
        return statusNotes;
    }

    public void setStatusNotes(String statusNotes) {
        this.statusNotes = statusNotes;
    }

    /**
     * @return the appointmentType
     */
    @NotNull
    @ManyToOne
    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    /**
     * @param appointmentType the appointmentType to set
     */
    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Boolean getNotifyChanges() {
        return notifyChanges;
    }

    public void setNotifyChanges(Boolean notifyChanges) {
        this.notifyChanges = notifyChanges;
    }

//    /**
//     * @return the appointmentPurpose
//     */
//    public AppointmentPurpose getAppointmentPurpose() {
//        return appointmentPurpose;
//    }
//
//    /**
//     * @param appointmentPurpose the appointmentPurpose to set
//     */
//    public void setAppointmentPurpose(AppointmentPurpose appointmentPurpose) {
//        this.appointmentPurpose = appointmentPurpose;
//    }
    
    @ManyToMany
    @Basic(fetch = FetchType.EAGER)
    @XmlElementWrapper(name="purposes")
    @XmlElement(name="purpose")
    public List<AppointmentPurpose> getPurposes() {
        return purposes;
    }

    public void setPurposes(List<AppointmentPurpose> purposes) {
        this.purposes = purposes;
    }
    
}
