/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.appointment;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Álvaro
 */
@Entity
@XmlRootElement
public class Complaint extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String name = "";
    protected String notes = "";
    protected boolean done = false;
    protected Appointment appointment;
    protected ComplaintType complaintType;

    public Complaint() {
        super();
    }

    public Complaint(ComplaintType complaintType, String notes) {
        this();
        this.complaintType = complaintType;
        this.notes = notes;
    }

    @Override
    public String toString() {
        if (complaintType.getCode().equals("OTRO")) {
            return name;
        } else {
            return complaintType.toString();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Basic(fetch = FetchType.EAGER)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @NotNull
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @ManyToOne
    @XmlTransient
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    /**
     * @return the complaintType
     */
    @NotNull
    @ManyToOne
    public ComplaintType getComplaintType() {
        return complaintType;
    }

    /**
     * @param complaintType the complaintType to set
     */
    public void setComplaintType(ComplaintType complaintType) {
        this.complaintType = complaintType;
    }

}
