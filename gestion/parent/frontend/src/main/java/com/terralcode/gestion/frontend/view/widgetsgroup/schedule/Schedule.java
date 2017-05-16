package com.terralcode.gestion.frontend.view.widgetsgroup.schedule;

import com.terralcode.gestion.frontend.view.widgets.customers.CustomersTable;
import com.terralcode.gestion.frontend.view.widgets.example.crudtestform.TestCrudTable;
import com.terralcode.gestion.frontend.view.widgets.schedule.ScheduleView;
import com.naoset.framework.frontend.view.widgetsgroup.WidgetGroup;
import com.vaadin.cdi.CDIView;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
@CDIView
public class Schedule extends WidgetGroup {

    @Inject
    com.terralcode.gestion.frontend.view.widgets.schedule.ScheduleView calendarView;
    
    @PostConstruct
    void init()
    {
        setTitle("Agenda");
        setSizeFull();
        calendarView.setMode(ScheduleView.Mode.MONTH);
        addWidgetPanel(calendarView, "dashboard-panel-slot-full");
        toggleMaximized(calendarView.getParent().getParent(), true);
    }

}
