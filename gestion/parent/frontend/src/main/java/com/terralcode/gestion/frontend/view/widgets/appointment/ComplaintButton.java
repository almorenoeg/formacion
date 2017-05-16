/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.appointment;

import com.terralcode.gestion.domain.appointment.Complaint;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author jmsuarez
 */
public class ComplaintButton extends Button{
    protected Complaint complaint;

    public ComplaintButton() {
        super();
        //this.addStyleName(ValoTheme.BUTTON_LINK);
    }

    public ComplaintButton(Complaint complaint) {
        super(complaint.getComplaintType().getName());
        //this.addStyleName(ValoTheme.BUTTON_LINK);
        this.complaint = complaint;
//        if (this.complaint.isDone()) {
//            this.addStyleName(ValoTheme.BUTTON_FRIENDLY);
//        }
//        else{
//            this.addStyleName(ValoTheme.BUTTON_DANGER);
//        }
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    
    
    
}
