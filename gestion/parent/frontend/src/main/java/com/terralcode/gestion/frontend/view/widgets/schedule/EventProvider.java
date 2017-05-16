package com.terralcode.gestion.frontend.view.widgets.schedule;

import com.terralcode.gestion.business.appointment.AppointmentService;
import com.terralcode.gestion.business.trade.TradeService;
import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.trade.Trade;
import com.terralcode.framework.domain.profile.User;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
public class EventProvider implements CalendarEventProvider {

    @Inject
    AppointmentService appointmentService;
    @Inject
    TradeService tradeService;

    @Override
    public List<CalendarEvent> getEvents(Date startDate, Date endDate) {
        List<Appointment> appointments = new ArrayList<>();
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        
        //Un administrador puede ver todas las citas. Un comercial, sólo las propias.
        User user = (User) VaadinSession.getCurrent().getAttribute(User.class.getName());
        if (user.getRoleUser().equals("admin")) {
            appointments = appointmentService.find(start, end);
        } else if(user.getRoleUser().equals("trade")){
            Trade trade = tradeService.findTradeByUser(user);
            if (trade != null) {
                appointments = appointmentService.findByTrade(trade, start, end);
            }
        }
        
        List<CalendarEvent> events = new ArrayList<>();
        appointments.stream()
                .map((appointment) -> new AppointmentEvent(appointment))
                .forEach((event) -> {
                    events.add(event);
                });

        return events;
    }

}
