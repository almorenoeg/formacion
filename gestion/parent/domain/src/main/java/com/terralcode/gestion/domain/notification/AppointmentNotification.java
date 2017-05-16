/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.notification;

import com.terralcode.framework.domain.notification.Notification;
import javax.persistence.Entity;

/**
 *
 * @author jmsuarez
 */
@Entity
public class AppointmentNotification extends Notification {
    protected Long appointmentID;

    public Long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }
    
}
