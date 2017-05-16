/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.panel.species;

import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.customer.Species;
import com.naoset.framework.frontend.data.converters.SetToListConverter;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author TerralCode01
 */
public class SpeciesPanel extends Panel {
    private FieldGroup fieldGroup;
    private CustomerCRM customer;
    private BeanItemContainer<Species> containerSpecies;
    private final String windowTitle;
    
    private final HorizontalLayout layout;

    public SpeciesPanel(String windowTitle) {
        super("");
        layout = new HorizontalLayout();
        this.windowTitle = windowTitle;
        
        this.setContent(layout);
    }
    
    public void bindElements(CustomerCRM customer, BeanItemContainer<Species> containerSpecies){
        this.customer = customer;
        this.containerSpecies = containerSpecies;
        refreshBind();
    }
    
    private void refreshBind(){
        layout.removeAllComponents();
//        this.customer.getSpecies().forEach(sp -> addElement(sp));
        
        for(Species species: this.customer.getSpecies()){
           Button newElement = new Button(species.getName());
           newElement.addStyleName(ValoTheme.BUTTON_BORDERLESS);
           layout.addComponent(newElement);
        }
        
        addElementToolbar();
    }    
    
     private void addElementToolbar(){
        Button newElement = new Button("", FontAwesome.ELLIPSIS_H);
        newElement.addStyleName(ValoTheme.BUTTON_LINK);
        newElement.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                openElementSelector();
                refreshBind();
            }
        });
        layout.addComponent(newElement);
    }
     
    private void openElementSelector(){
        Window window = new Window(this.windowTitle);
        window.setModal(true);
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMargin(true);
        window.setContent(verticalLayout);
        
        BeanItem beanItem = new BeanItem<>(customer);
        fieldGroup = new BeanFieldGroup<>(CustomerCRM.class);
        fieldGroup.setItemDataSource(beanItem);
        
        
        OptionGroup og = new OptionGroup();
        og.setConverter(new SetToListConverter());
        og.setContainerDataSource(containerSpecies);
        og.setNullSelectionAllowed(false);
        og.setMultiSelect(true);
        og.setImmediate(true);
        //tcs.setLeftColumnCaption("Disponibles");
        //tcs.setRightColumnCaption("Seleccionados");
        fieldGroup.bind(og, "species");
        
//        TwinColSelect tcs = new TwinColSelect();
//        tcs.setConverter(new SetToListConverter());
//        tcs.setContainerDataSource(containerSpecies);
//        tcs.setNullSelectionAllowed(false);
//        tcs.setMultiSelect(true);
//        tcs.setImmediate(true);
//        tcs.setLeftColumnCaption("Disponibles");
//        tcs.setRightColumnCaption("Seleccionados");
//        fieldGroup.bind(tcs, "species");
      
        
        verticalLayout.addComponent(og);
        verticalLayout.addComponent(createOkTradesButton(window));
        getUI().addWindow(window);
    }
    
        private Component createOkTradesButton(Window window) {
        Button okButton = new Button("OK");
        okButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                try {
                    fieldGroup.commit();
                    refreshBind();
                    window.close();
                } catch (FieldGroup.CommitException e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        return okButton;
    }
}
