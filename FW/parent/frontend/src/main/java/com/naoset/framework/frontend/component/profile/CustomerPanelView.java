/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.frontend.component.profile;

import com.naoset.framework.business.company.CompanyService;
import com.naoset.framework.domain.company.relationship.customer.Customer;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author TerralCode01
 */
public class CustomerPanelView extends Panel{
    @PropertyId("id")
    private TextField code;
    @PropertyId("name")
    private TextField name;
    @PropertyId("male")
    private OptionGroup sexField;
    @PropertyId("email")
    private TextField emailField;
    @PropertyId("location")
    private TextField locationField;
    @PropertyId("phone")
    private TextField phoneField;
    @PropertyId("address")
    private Table address;
    @PropertyId("species")
    private OptionGroup species;
    
//    private final BeanFieldGroup<Customer> customerFieldGroup;
    
    private CompanyService companyService;

    public CustomerPanelView() {
//        customerFieldGroup = new BeanFieldGroup<>(Customer.class);
//        customerFieldGroup.bindMemberFields(this);
//        customerFieldGroup.setItemDataSource((Customer) companyService.find(1));
    }
    
    
    
    public Component buildCustomerPanel(Customer customer) {
        
        
        
        VerticalLayout content = new VerticalLayout();
        
        content.addComponent(builtData());
        content.setSizeFull();
        content.setMargin(new MarginInfo(true, false, false, false));
         
        return content;
    }
    private Component builtData() {
        FormLayout details = new FormLayout();
        details.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        
        code = new TextField("First Name");
        details.addComponent(code);
        name = new TextField("Last Name");
        details.addComponent(name);

        sexField = new OptionGroup("Sex");
        sexField.addItem(Boolean.FALSE);
        sexField.setItemCaption(Boolean.FALSE, "Female");
        sexField.addItem(Boolean.TRUE);
        sexField.setItemCaption(Boolean.TRUE, "Male");
        sexField.addStyleName("horizontal");
        details.addComponent(sexField);

//        Label section = new Label("Contact Info");
//        section.addStyleName(ValoTheme.LABEL_H4);
//        section.addStyleName(ValoTheme.LABEL_COLORED);
//        details.addComponent(section);

        emailField = new TextField("Email");
        emailField.setWidth("100%");
        emailField.setRequired(true);
        emailField.setNullRepresentation("");
        details.addComponent(emailField);

        locationField = new TextField("Dirección");
        locationField.setWidth("100%");
        locationField.setNullRepresentation("");
        locationField.setComponentError(new UserError("This address doesn't exist"));
        details.addComponent(locationField);

        phoneField = new TextField("Telefono");
        phoneField.setWidth("100%");
        phoneField.setNullRepresentation("");
        details.addComponent(phoneField);
        
        
        details.addComponent(buildSpecies());
        
        return details;
    }
    
    private Component buildSpecies() {
        
        species = new OptionGroup("Especies");
        species.setMultiSelect(true);
        species.addStyleName("horizontal");
        species.addItems("Porcino Iberico", "Porcino Blanco", "Ovino", 
                "Vacuno Carne", "Vacuno Leche", "Avicultura", "Otras", "Agricultor");
      
        return species;
    }
    
}
