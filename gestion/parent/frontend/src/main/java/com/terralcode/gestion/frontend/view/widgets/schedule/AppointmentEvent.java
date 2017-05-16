/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.schedule;

import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.appointment.AppointmentType;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import java.util.Calendar;

/**
 *
 * @author jmsuarez Especialización de evento de calendario para contener la
 * información de la cita.
 */
public class AppointmentEvent extends BasicEvent {

    protected Appointment appointment;

    public AppointmentEvent(Appointment appointment)
    {
        String eventText;

        this.appointment = appointment;
        this.setStart(appointment.getProgramDateStart().getTime());
        this.setEnd(appointment.getProgramDateEnd().getTime());
        setColor();
        if (appointment.getAppointmentType().getCode().equals("CON")) {
            this.setCaption(appointment.getContactNotes() == null ? "[CONTACTO]" : appointment.getContactNotes());
        } else {
            this.setCaption(appointment.getCustomer().getName());
        }
        this.setDescription(appointment.getReasonNotes());

        Calendar minimunEnd = (Calendar) appointment.getProgramDateStart().clone();
        minimunEnd.add(Calendar.HOUR_OF_DAY, 3);
        if (minimunEnd.after(appointment.getProgramDateEnd())) {
            this.setEnd(minimunEnd.getTime());
        } else {
            this.setEnd(appointment.getProgramDateEnd().getTime());
        }

    }

    public Appointment getAppointment()
    {
        return appointment;
    }

    private void setColor()
    {
        System.out.println(appointment.getAppointmentType().getCode());
        if ("COM".equals(appointment.getAppointmentType().getCode())) {
            this.setStyleName("color1");
        } else if ("VIS".equals(appointment.getAppointmentType().getCode())){
            this.setStyleName("color2");
        } else {
            this.setStyleName("color3");
            
        }
    }

}
