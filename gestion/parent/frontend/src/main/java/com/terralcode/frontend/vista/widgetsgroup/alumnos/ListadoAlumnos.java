/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.frontend.vista.widgetsgroup.alumnos;

import com.naoset.framework.frontend.view.widgetsgroup.WidgetGroup;
import com.terralcode.frontend.vista.widgets.listados.ListadoAlumnosView;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author almoreno
 */
public class ListadoAlumnos extends WidgetGroup{

     @Inject
   ListadoAlumnosView listadoAlumnosView;
    
    @PostConstruct
    void init() {
        setTitle("Listado");
        addWidgetPanel(listadoAlumnosView, "dashboard-panel-slot-full");
        toggleMaximized(listadoAlumnosView.getParent().getParent(), true);
    }
}
