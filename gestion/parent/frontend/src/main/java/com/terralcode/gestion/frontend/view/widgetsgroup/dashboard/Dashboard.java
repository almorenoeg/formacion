package com.terralcode.gestion.frontend.view.widgetsgroup.dashboard;

import com.terralcode.gestion.frontend.view.widgets.incomingAppointments.IncomingAppointments;
import com.terralcode.gestion.frontend.view.widgets.notes.NotesView;
import com.naoset.framework.frontend.view.widgetsgroup.WidgetGroup;
import com.terralcode.frontend.vista.widgets.alumno.AlumnoVista;
import com.terralcode.frontend.vista.widgets.listados.ListadoAlumnosView;
import com.vaadin.cdi.CDIView;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
@CDIView
public class Dashboard extends WidgetGroup {

    @Inject
    ListadoAlumnosView listadoAlumnosView;
    
    @Inject
    AlumnoVista alumnosVista;
    
//    @Inject
//    NotesView notesView;
//    IncomingAppointments incomingAppointmentsView;

    @PostConstruct
    void init()
    {
        setTitle("Inicio");
        addWidgetPanel(listadoAlumnosView, "dashboard-panel-slot-full");
        addWidgetPanel(alumnosVista, "dashboard-panel-slot-full");
//        addWidgetPanel(alumnosVista, "dashboard-panel-slot");
        toggleMaximized(listadoAlumnosView.getParent().getParent(), true);
    }
}
