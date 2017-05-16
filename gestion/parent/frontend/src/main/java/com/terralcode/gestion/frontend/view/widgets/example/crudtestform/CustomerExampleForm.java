package com.terralcode.gestion.frontend.view.widgets.example.crudtestform;

import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.cdi.CDIUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@CDIUI
public class CustomerExampleForm extends Widget {
    
    private Label customerData = new Label("Datos del Cliente");
    private TextField customerName = new TextField("Nombre");
    private TextField customerSurname = new TextField("Apellidos");
    private TextField customerCif = new TextField("NIF/CIF");
    private TextField customerAddress = new TextField("Direccion");
    private TextField customerSpecies = new TextField("Especies");
    
    
    
    public void init() {
        // Create a text field TextField tf = new TextField("A Field");
    }
    
    protected Component buildContent() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(customerData);
        verticalLayout.addComponent(customerName);
        verticalLayout.addComponent(customerSurname);
        verticalLayout.addComponent(customerCif);
        verticalLayout.addComponent(customerAddress);
        return verticalLayout;
    }

    @Override
    protected String caption() {
        return "Datos Cliente";
    }


}
