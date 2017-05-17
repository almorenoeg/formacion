/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgetsgroup;

import com.naoset.framework.frontend.view.widgetsgroup.DashboardMenu;
import com.naoset.framework.frontend.view.widgetsgroup.DashboardViewType;
import com.vaadin.server.FontAwesome;
import java.util.Arrays;

/**
 *
 * @author Ezequiel
 */
public class CrmMenu extends DashboardMenu {

//    private static final DashboardViewType DAHSBOARD = new DashboardViewType("Inicio", "dashboard", FontAwesome.HOME, true);
//    private static final DashboardViewType CALENDAR = new DashboardViewType("Agenda", "schedule", FontAwesome.CALENDAR, false);
//    private static final DashboardViewType CUSTOMERS = new DashboardViewType("Clientes", "customers", FontAwesome.BRIEFCASE, false);
    private static final DashboardViewType LISTADOS = new DashboardViewType("Listados", "ListadoAlumnos", FontAwesome.LIST, true);
    private static final DashboardViewType ALUMNOS = new DashboardViewType("Alumnos", "FichaAlumnos", FontAwesome.MALE, false);

    @Override
    protected Iterable<DashboardViewType> getMenuItems()
    {
        return Arrays.asList(
//                DAHSBOARD,
//                CALENDAR,
//                CUSTOMERS, 
                ALUMNOS,
                LISTADOS);
    }

}
