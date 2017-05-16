/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.frontend.vista.widgets.alumno;

import com.naoset.framework.frontend.view.widgets.Widget;
import com.naoset.framework.frontend.view.window.Window;
import com.terralcode.framework.domain.Direccion;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author almoreno
 */
public class DireccionVista extends Widget {

    private Direccion direccion;

    private FormLayout mainLayout;
    
    FieldGroup fieldGroup;
    protected TextField direccionField;
    protected TextField direccion2Field;
    protected TextField ciudadField;
    protected TextField provinciaField;
    protected TextField codigoPostalField;

    Window window;

    public DireccionVista() {
        super();
        bindModel();
    }

    
    public DireccionVista(Direccion direccion) {
        super();
        this.direccion = direccion;
        bindModel();
        buildContent();
    }

    
    
    
    
    @Override
    protected Component buildContent() {
//        WebBrowser webBrowser = Page.getCurrent().getWebBrowser();
//        window = new Window(this);
//        window.addStyleName("profile-window");
//        window.setModal(true);
//        if (webBrowser.getScreenWidth() < 1024) {
//            window.setSizeFull();
//        } else {
//            window.setHeight(90.0f, Unit.PERCENTAGE);
//            window.setWidth(90.0f, Unit.PERCENTAGE);
//        }
        Component layout = buildLayout();

        return layout;
    }

    @Override
    protected String caption() {
        return "Direccion";
    }

    private FormLayout buildLayout() {
        mainLayout = new FormLayout();
        mainLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        mainLayout.setMargin(new MarginInfo(true, false, false, false));

        buildDireccion();
        
        return mainLayout;
    }
    
    
    private void buildDireccion(){
        direccionField = new TextField("Dirección");
        direccion2Field = new TextField("Dirección 2");
        ciudadField = new TextField("Ciudad");
        provinciaField = new TextField("Provincia");
        codigoPostalField = new TextField("Código Postal");

        mainLayout.addComponent(direccionField);
        mainLayout.addComponent(direccion2Field);
        mainLayout.addComponent(ciudadField);
        mainLayout.addComponent(provinciaField);
        mainLayout.addComponent(codigoPostalField);
    }

    private void bindModel() throws FieldGroup.BindException {
        fieldGroup = new BeanFieldGroup<>(Direccion.class);
        fieldGroup.bind(direccionField, "direccion");
        fieldGroup.bind(direccion2Field, "direccion2");
        fieldGroup.bind(ciudadField, "ciudad");
        fieldGroup.bind(provinciaField, "provincia");
        fieldGroup.bind(codigoPostalField, "codigoPostal");
    }
}
