package com.terralcode.gestion.domain.converters;

import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.notification.AppointmentNotification;
import com.terralcode.gestion.domain.trade.Trade;
import com.terralcode.framework.domain.notification.Notification;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author Ezequiel
 */
public class AppointmentToNotifications implements Function<Appointment, List<Notification>> {
    
    @Override
    public List<Notification> apply(Appointment appointment)
    {
        List<Notification> notifications = new ArrayList<>();
        for (Trade trade : appointment.getTrades()) {
            AppointmentNotification notification = new AppointmentNotification();
            notification.setAppointmentID(appointment.getId());
            notification.setUser(trade.getUser());
            notification.setAction(appointment.getAppointmentReason().getName());
            notification.setContent("Se ha creado/modificado la siguiente cita.\n "
                                    + "Cliente: " + (appointment.getCustomer()==null? "Sin cliente": appointment.getCustomer()) + "\n"
                                    + "Fecha: " + DateFormat.getDateInstance().format(appointment.getProgramDateStart().getTime()) + "\n"
                                    + "Razón: " + appointment.getAppointmentReason() + "\n"
                                    + "Comentarios: " + appointment.getNotes() + "\n");
            notification.setSendEmail(false);
            notification.setFirstName(appointment.getCustomer()==null? "Sin cliente" : appointment.getCustomer().getName());
            notification.setSentTime(Calendar.getInstance());
            notification.setUrl("appointment/" + appointment.getId());
            notifications.add(notification);
            
        }
        return notifications;
        
    }
}
