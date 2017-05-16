/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.frontend.vista.widgets.empresa;

import com.naoset.framework.frontend.view.widgets.Widget;
import com.naoset.framework.frontend.view.window.Window;
import com.terralcode.framework.domain.Empresa;
import com.vaadin.server.Page;
import com.vaadin.server.WebBrowser;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author almoreno
 */
public class EmpresaVista extends Widget {

    Empresa empresa;
    private FormLayout mainLayout;
    Window window;
    
    @Override
    protected Component buildContent() {
        Component layout = buildLayout();

        WebBrowser webBrowser = Page.getCurrent().getWebBrowser();
        window = new Window(this);
        window.addStyleName("profile-window");
        window.setModal(true);
        if (webBrowser.getScreenWidth() < 1024) {
            window.setSizeFull();
        } else {
            window.setHeight(90.0f, Unit.PERCENTAGE);
            window.setWidth(90.0f, Unit.PERCENTAGE);
        }

        return layout;
    }

    @Override
    protected String caption() {
        return "Empresa";
    }
    
    private FormLayout buildLayout() {
        mainLayout = new FormLayout();
        mainLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        mainLayout.setMargin(new MarginInfo(true, false, false, false));

//        buildAlumnoHeader();
//        buildCustomerSpecies();
//        buildCustomerAddresses();
//        buildCustomerContacts();
//        buildSales();
//        buildAppointments();

        return mainLayout;
    }

}
