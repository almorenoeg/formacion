/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.frontend.vista.widgetsgroup.alumnos;

import com.naoset.framework.frontend.view.widgetsgroup.WidgetGroup;
import com.terralcode.frontend.vista.widgets.alumno.AlumnoVista;
import com.vaadin.cdi.CDIView;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author almoreno
 */
@CDIView
public class Alumnos extends WidgetGroup {
    @Inject
    AlumnoVista alumnosVista;
    
    @PostConstruct
    void init() {
        setTitle("Alumnos");
        addWidgetPanel(alumnosVista, "dashboard-panel-slot-full");
        toggleMaximized(alumnosVista.getParent().getParent(), true);
    }
}
