/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.integration.customerxml_oze;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmsuarez
 */
@XmlRootElement
public class ExportAppointment extends ExportEntity {
    
    private String reasonCode;
    private ExportCustomer customer;
    private ExportAddress address;
    private ExportContactInfo contactInfo;
    private String contactNotes;
    
    private String start;
    private List<ExportTrade> trades;
    
    private ExportTimeLapse timeLapse;
    private Integer distance;
    private String notes;
    private List<ExportResult> results;
    private List<ExportComplaint> complaints;
    
    private String statusCode;
    private String statusNotes;

    public ExportAppointment() {
        trades = new ArrayList<ExportTrade>();
        results = new ArrayList<ExportResult>();
        complaints = new ArrayList<ExportComplaint>();
    }

    
    @XmlAttribute(name = "ReasonCode")
    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
    
    @XmlElement(name = "Customer")
    public ExportCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ExportCustomer customer) {
        this.customer = customer;
    }

    @XmlElement(name = "Address")
    public ExportAddress getAddress() {
        return address;
    }

    public void setAddress(ExportAddress address) {
        this.address = address;
    }

    @XmlElement(name = "ContactInfo")
    public ExportContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ExportContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @XmlElement(name = "ContactNotes")
    public String getContactNotes() {
        return contactNotes;
    }

    public void setContactNotes(String contactNotes) {
        this.contactNotes = contactNotes;
    }

    @XmlAttribute(name = "Start")
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @XmlElementWrapper(name="Trades")
    @XmlElement(name = "Trade")
    public List<ExportTrade> getTrades() {
        return trades;
    }

    public void setTrades(List<ExportTrade> trades) {
        this.trades = trades;
    }

    @XmlElement(name = "TimeLapse")
    public ExportTimeLapse getTimeLapse() {
        return timeLapse;
    }

    public void setTimeLapse(ExportTimeLapse timeLapse) {
        this.timeLapse = timeLapse;
    }

    @XmlElement(name = "Distance")
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @XmlElement(name = "Notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlElementWrapper(name="Results")
    @XmlElement(name = "Result")
    public List<ExportResult> getResults() {
        return results;
    }

    public void setResults(List<ExportResult> results) {
        this.results = results;
    }

    @XmlElementWrapper(name="Complaints")
    @XmlElement(name = "Complaint")
    public List<ExportComplaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<ExportComplaint> complaints) {
        this.complaints = complaints;
    }

    @XmlAttribute(name = "StatusCode")
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @XmlElement(name = "StatusNotes")
    public String getStatusNotes() {
        return statusNotes;
    }

    public void setStatusNotes(String statusNotes) {
        this.statusNotes = statusNotes;
    }
}
