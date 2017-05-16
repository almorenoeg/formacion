/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.incomingAppointments;

import com.google.common.eventbus.Subscribe;
import com.terralcode.gestion.business.appointment.AppointmentService;
import com.terralcode.gestion.business.trade.TradeService;
import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.trade.Trade;
import com.terralcode.gestion.frontend.event.AppointmentUpdatedEvent;
import com.terralcode.gestion.frontend.view.widgets.appointment.AppointmentView;
import com.terralcode.framework.domain.profile.User;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.inject.Inject;

/**
 *
 * @author jmsuarez
 */
@CDIUI
public class IncomingAppointments extends Widget {
    
    @Inject
    protected AppointmentService appointmentService;
    @Inject
    protected TradeService tradeService;
    @Inject
    AppointmentView appointmentView;
    protected List<Appointment> appointmentList;
    
    Panel wrapper;
    VerticalLayout root;
    
    @Override
    protected Component buildContent() {
        wrapper = new Panel();
        wrapper.setSizeFull();
        
        root = new VerticalLayout();
        
        loadAppointments();
        
        wrapper.setContent(root);
        return wrapper;
    }
    
    private void loadAppointments() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.YEAR, 1);

        //Un administrador puede ver todas las citas. Un comercial, sólo las propias.
        User user = (User) VaadinSession.getCurrent().getAttribute(User.class.getName());
        if (user.getRoleUser().equals("admin")) {
            appointmentList = appointmentService.find(start, end);
        } else if (user.getRoleUser().equals("trade")) {
            Trade trade = tradeService.findTradeByUser(user);
            if (trade != null) {
                appointmentList = appointmentService.findByTrade(trade, start, end);
            }
        }
        //Sólo mostraremos las citas en estado PROGRAMADO
        List<Appointment> filteredAppointmentList
                = appointmentList.stream().filter(p -> p.getStatus().getCode().equals("PRG")).collect(Collectors.toList());
        filteredAppointmentList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (((Appointment) o1).getProgramDateStart()).compareTo(((Appointment) o2).getProgramDateStart());
            }
        });
        setAppointments(filteredAppointmentList);
    }
    
    @Override
    protected String caption() {
        return "Próximas citas";
    }
    
    public void setAppointments(List<Appointment> appointments) {
        Calendar cal1, cal2;
        
        root.removeAllComponents();
        
        cal1 = Calendar.getInstance();
        cal1.set(1900, 1, 1);
        for (Appointment appointment : appointments) {
            cal2 = (Calendar) appointment.getProgramDateStart().clone();
            cal2.set(Calendar.HOUR_OF_DAY, 0);
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.SECOND, 0);
            cal2.set(Calendar.MILLISECOND, 0);
            if (!cal1.equals(cal2)) {
                cal1 = (Calendar) cal2.clone();
                AppointmentDateLabel dateLabel = new AppointmentDateLabel(cal1);
                dateLabel.setWidth("100%");
                root.addComponent(dateLabel);
            }
            final AppointmentPreview appPreview = new AppointmentPreview(appointment) {
                
                @Override
                public void onAppointmentClicked(Appointment app) {
                    appointmentView.open(app); //To change body of generated methods, choose Tools | Templates.
                }
                
            };
            appPreview.setWidth("100%");
            root.addComponent(appPreview);
        }
    }
    
    @Subscribe
    public void appointmentUpdate(AppointmentUpdatedEvent appointmentUpdatedEvent) {
        loadAppointments();
    }
    
}

class AppointmentDateLabel extends Label {
    
    public AppointmentDateLabel(Calendar cal) {
        super();
        this.addStyleName(ValoTheme.LABEL_H2);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.setValue(sdf.format(cal.getTime()));
    }
    
}

class AppointmentPreview extends VerticalLayout {
    
    protected Appointment appointment;
    
    protected Button schedule;
    protected Label type;
    protected Label customer;
    protected Label address;
    protected Label contact;
    
    public AppointmentPreview(Appointment app) {
        this.appointment = app;
        this.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
        
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(false);
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String scheduleText = sdf.format(app.getProgramDateStart().getTime());
        if (app.getTimeLapse()!=null) {
                scheduleText += " (" + app.getTimeLapse().toString() + ")";
        }
        schedule = new Button(scheduleText);
        schedule.addClickListener(new Button.ClickListener() {
            
            @Override
            public void buttonClick(Button.ClickEvent event) {
                onAppointmentClicked(appointment);
            }
        });
        schedule.addStyleName(ValoTheme.BUTTON_LINK);
        schedule.setWidth("100%");
        hl.addComponent(schedule);
        //type = new Label();
        if (app.getAppointmentType().getCode().equals("VIS")) {
            schedule.setIcon(FontAwesome.HOME);
        }
        if (app.getAppointmentType().getCode().equals("COM")) {
            schedule.setIcon(FontAwesome.PHONE);
        }
        if (app.getAppointmentType().getCode().equals("CON")) {
            schedule.setIcon(FontAwesome.USER);
        }
        //hl.addComponent(type);
        //hl.setComponentAlignment(type, Alignment.MIDDLE_RIGHT);
        hl.setExpandRatio(schedule, 1);
        this.addComponent(hl);
        
        if (app.getAppointmentType().getCode().equals("VIS") || app.getAppointmentType().getCode().equals("COM")) {
            customer = new Label(app.getCustomer().toString());
            //customer.addStyleName(ValoTheme.LABEL_H3);
            customer.setWidth("100%");
            this.addComponent(customer);
        }
        
        if ("VIS".equals(app.getAppointmentType().getCode())) {
            address = new Label(Objects.toString(app.getAddress(), "Dirección no disponible"));
            //address.addStyleName(ValoTheme.LABEL_H3);
            address.setWidth("100%");
            this.addComponent(address);
        }
        if ("CON".equals(app.getAppointmentType().getCode())) {
            contact = new Label(app.getContactNotes());
            //address.addStyleName(ValoTheme.LABEL_H3);
            contact.setWidth("100%");
            this.addComponent(contact);
        }
        
    }
    
    public void onAppointmentClicked(Appointment app) {
        //Sobreescribir
    }
    
}
