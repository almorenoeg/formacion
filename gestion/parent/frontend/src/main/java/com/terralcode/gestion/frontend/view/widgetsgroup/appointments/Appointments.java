/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgetsgroup.appointments;

import com.terralcode.gestion.frontend.view.widgets.incomingAppointments.IncomingAppointments;
import com.naoset.framework.frontend.view.widgetsgroup.WidgetGroup;
import com.vaadin.cdi.CDIView;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author jmsuarez
 */
@CDIView
public class Appointments extends WidgetGroup {
    @Inject
    IncomingAppointments incomingAppointmentsView;
    
    @PostConstruct
    void init()
    {
       setTitle("Próximas citas");
       setSizeFull();
       addWidgetPanel(incomingAppointmentsView, "dashboard-panel-slot-full");
       toggleMaximized(incomingAppointmentsView.getParent().getParent(), true);
    }
}
