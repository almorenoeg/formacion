package com.terralcode.gestion.frontend.view.widgets.schedule;

import com.google.common.eventbus.Subscribe;
import com.terralcode.gestion.business.appointment.AppointmentService;
import com.terralcode.gestion.business.trade.TradeService;
import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.trade.Trade;
import com.terralcode.gestion.frontend.event.AppointmentUpdatedEvent;
import com.terralcode.gestion.frontend.view.widgets.appointment.AppointmentView;
import com.terralcode.framework.domain.profile.User;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.ViewScoped;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.components.calendar.CalendarComponentEvents;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.DateClickHandler;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClick;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClickHandler;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.handler.BasicEventMoveHandler;
import com.vaadin.ui.components.calendar.handler.BasicEventResizeHandler;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

@SuppressWarnings({"serial", "unchecked"})
@CDIView("calendar-widget")
@ViewScoped
public final class ScheduleView extends Widget {

    private Calendar calendar;
    private Mode mode;
    @Inject
    ScheduleController controller;
    @Inject
    AppointmentService appointmentService;
    @Inject
    TradeService tradeService;
    @Inject
    AppointmentView appointmentView;
    private Component tray;
    BeanItemContainer<BasicEvent> container;
    @Inject
    EventProvider eventProvider;

    protected Component buildContent()
    {
        final MenuBar.MenuItem previousMenuItem = new MenuBar().new MenuItem("", null, new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                previous();
            }
        });
        previousMenuItem.setIcon(FontAwesome.ARROW_CIRCLE_LEFT);
        final MenuBar.MenuItem nextMenuItem = new MenuBar().new MenuItem("", null, new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                next();
            }
        });
        nextMenuItem.setIcon(FontAwesome.ARROW_CIRCLE_RIGHT);
        final MenuBar.MenuItem dailyMenuItem = new MenuBar().new MenuItem("Diario", null, new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                setMode(Mode.DAY);
            }
        });
        final MenuBar.MenuItem weeklyMenuItem = new MenuBar().new MenuItem("Semanal", null, new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                setMode(Mode.WEEK);
            }
        });
        final MenuBar.MenuItem monthlyMenuItem = new MenuBar().new MenuItem("Mensual", null, new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                setMode(Mode.MONTH);
            }
        });

        final MenuBar.MenuItem separator = new MenuBar().new MenuItem("Separator", null, new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                next();
            }
        }).addSeparator();

        addMenuItems(
                previousMenuItem,
                nextMenuItem,
                monthlyMenuItem,
                weeklyMenuItem,
                dailyMenuItem
                );
        calendar = buildCalendar();
        tray = buildTray();

        Panel panel = new Panel();
        panel.setSizeFull();
        panel.setContent(calendar);

        return panel;
    }

    public Object randomObject(Object[] objects, float[] chances){
        //Implement here validations, about arrays size and chances values.
        
        float random = new Random().nextFloat();
        float acumulatedChance = 0f;
        
        for (int i = 0; i < chances.length; i++) {
            acumulatedChance += chances[i];
            if (acumulatedChance >= random) {
                return objects[i];
            }            
        }
        return objects[objects.length-1];        
    }
    
    
    private Calendar buildCalendar()
    {
        Calendar calendar = new Calendar();
        calendar.setLocale(new Locale("es", "ES"));
        calendar.setWeeklyCaptionFormat("dd-MM");
        calendar.setFirstVisibleHourOfDay(6);
        calendar.setWidth(100.0f, Unit.PERCENTAGE);
        calendar.setHeight(600.0f, Unit.PIXELS);
        calendar.setEventProvider(eventProvider);

        calendar.setHandler(new DateClickHandler() {

            @Override
            public void dateClick(CalendarComponentEvents.DateClickEvent event)
            {
                java.util.Calendar cal;
                Appointment app;
//                try {
                
                    app = appointmentService.newEntity();
                    cal = new java.util.Calendar.Builder().build();
                    cal.setTime(event.getDate());
                    app.setProgramDateStart(cal);

                    cal = new java.util.Calendar.Builder().build();
                    cal.setTime(event.getDate());
                    cal.add(java.util.Calendar.HOUR_OF_DAY, 1);
                    app.setProgramDateEnd(cal);
                    
                    //Add the current trade to the list of selected trades of the
                    //appointment
                    User user = (User) VaadinSession.getCurrent().getAttribute(User.class.getName());
                    if (user.getRoleUser().equals("trade")){
                        Trade trade = tradeService.findTradeByUser(user);
                        if (trade != null) {
                           app.getTrades().add(trade);
                        }
                    }

                    appointmentView.open(app);
//                } catch (InstantiationException ex) {
//                    Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IllegalAccessException ex) {
//                    Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
//                }

            }
        });

        calendar.setHandler(new EventClickHandler() {
            @Override
            public void eventClick(final EventClick event)
            {
                AppointmentEvent appEvent = (AppointmentEvent) (event.getCalendarEvent());
                Appointment app = appEvent.getAppointment();
                setTrayVisible(false);

                appointmentView.open(app);
            }
        });

        calendar.setHandler(new BasicEventMoveHandler() {
            @Override
            public void eventMove(final CalendarComponentEvents.MoveEvent event)
            {
            }

        });
        calendar.setHandler(new BasicEventResizeHandler() {
            @Override
            public void eventResize(final CalendarComponentEvents.EventResize event)
            {
            }
        });

        return calendar;
    }

    private void setTrayVisible(final boolean visible)
    {
        final String styleReveal = "v-animate-reveal";
        if (visible) {
            tray.addStyleName(styleReveal);
        } else {
            tray.removeStyleName(styleReveal);
        }
    }

    private Component buildTray()
    {
        final HorizontalLayout tray = new HorizontalLayout();
        tray.setWidth(100.0f, Unit.PERCENTAGE);
        tray.addStyleName("tray");
        tray.setSpacing(true);
        tray.setMargin(true);

        Label warning = new Label(
                "Tienes cambios sin confirmar en la agenda");
        warning.addStyleName("warning");
        warning.addStyleName("icon-attention");
        tray.addComponent(warning);
        tray.setComponentAlignment(warning, Alignment.MIDDLE_LEFT);
        tray.setExpandRatio(warning, 1);

        Button.ClickListener close = new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event)
            {
                setTrayVisible(false);
            }
        };

        Button confirm = new Button("Confirmar");
        confirm.addStyleName(ValoTheme.BUTTON_PRIMARY);
        confirm.addClickListener(close);
        tray.addComponent(confirm);
        tray.setComponentAlignment(confirm, Alignment.MIDDLE_LEFT);

        Button discard = new Button("Descartar");
        discard.addClickListener(close);
        discard.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event)
            {
                calendar.markAsDirty();
            }
        });
        tray.addComponent(discard);
        tray.setComponentAlignment(discard, Alignment.MIDDLE_LEFT);
        return tray;
    }

    @Override
    protected String caption()
    {
        return "Agenda";
    }

    public void setMode(Mode mode)
    {
        this.mode = mode;
        final java.util.Calendar now = java.util.Calendar.getInstance();
        java.util.Calendar firstDay = (java.util.Calendar) now.clone();
        java.util.Calendar lastDay = (java.util.Calendar) now.clone();
        switch (mode) {
            case DAY:
                break;
            case WEEK:
                firstDay.set(java.util.Calendar.DAY_OF_WEEK, firstDay.getFirstDayOfWeek());
                lastDay.set(java.util.Calendar.DAY_OF_WEEK, lastDay.getFirstDayOfWeek());
                lastDay.add(java.util.Calendar.WEEK_OF_YEAR, 1);
                lastDay.add(java.util.Calendar.DAY_OF_MONTH, -1);
                break;
            case MONTH:
                firstDay.set(java.util.Calendar.DAY_OF_MONTH, 1);
                lastDay.set(java.util.Calendar.DAY_OF_MONTH, 1);
                lastDay.roll(java.util.Calendar.DAY_OF_MONTH, -1);
                break;
        }
        calendar.setStartDate(firstDay.getTime());
        calendar.setEndDate(lastDay.getTime());
    }

    public void next()
    {
        Date startDate = calendar.getStartDate();
        Date endDate = calendar.getEndDate();
        java.util.Calendar start = java.util.Calendar.getInstance();
        start.setTime(startDate);
        java.util.Calendar end = java.util.Calendar.getInstance();
        end.setTime(endDate);
        switch (mode) {
            case DAY:
                start.add(java.util.Calendar.DAY_OF_MONTH, 1);
                end.add(java.util.Calendar.DAY_OF_MONTH, 1);
                break;
            case WEEK:
                start.add(java.util.Calendar.DAY_OF_MONTH, 7);
                end.add(java.util.Calendar.DAY_OF_MONTH, 7);
                break;
            case MONTH:
                start.add(java.util.Calendar.MONTH, 1);
                end.add(java.util.Calendar.MONTH, 1);
                break;
        }
        calendar.setStartDate(start.getTime());
        calendar.setEndDate(end.getTime());
    }

    public void previous()
    {
        Date startDate = calendar.getStartDate();
        Date endDate = calendar.getEndDate();
        java.util.Calendar start = java.util.Calendar.getInstance();
        start.setTime(startDate);
        java.util.Calendar end = java.util.Calendar.getInstance();
        end.setTime(endDate);
        switch (mode) {
            case DAY:
                start.add(java.util.Calendar.DAY_OF_MONTH, -1);
                end.add(java.util.Calendar.DAY_OF_MONTH, -1);
                break;
            case WEEK:
                start.add(java.util.Calendar.DAY_OF_MONTH, -7);
                end.add(java.util.Calendar.DAY_OF_MONTH, -7);
                break;
            case MONTH:
                start.add(java.util.Calendar.MONTH, -1);
                end.add(java.util.Calendar.MONTH, -1);
                break;
        }
        calendar.setStartDate(start.getTime());
        calendar.setEndDate(end.getTime());
    }

    public enum Mode {

        DAY,
        WEEK,
        MONTH;
    }

    @Subscribe
    public void appointmentUpdate(AppointmentUpdatedEvent appointmentUpdatedEvent)
    {
        calendar.setImmediate(true);
    }
}
