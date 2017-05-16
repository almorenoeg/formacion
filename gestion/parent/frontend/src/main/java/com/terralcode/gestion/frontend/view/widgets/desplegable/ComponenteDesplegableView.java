/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.desplegable;

import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TerralCode01
 */
public class ComponenteDesplegableView extends Widget {

    String seleccion;
    Map<Integer, String> valores;
    Map<Integer, String> especies;
    
    
    protected Component buildContent() {
        init();
        return buildCustomerDetail();
    }

    
    @Override
    public void init() {
        valores = new HashMap();
//        rellenarDatos();
    }
    
    @Override
    protected String caption() {
        return "Mi componente";
    }
    
    private Component buildCustomerDetail() {
        GridLayout miGrid = new GridLayout(3, 2);
        
        ComboBox combo = new ComboBox();
        combo.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                seleccion = (String) event.getProperty().getValue();
                
                
            }
        });
        combo.addItems("Pocino Ibérico", "Pocino Blanco", "Ovino", "Vacuno", "Avicultura", "Otros");
//        combo.addItem(especies);
        Label informacion = new Label("datos");
        Button botonMas = new Button("+");
        botonMas.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                Integer clave;
                if (valores.containsValue(seleccion)) {
                    clave = 1;
                    if (!valores.isEmpty()) {
                        clave = valores.size() + 1;
                    }
                    
                    valores.put(clave, seleccion);
                }
                informacion.setValue(mostrarValores());
                Notification.show(seleccion + " añadido"); 
            }
        });
        Button botonMenos = new Button("-");
        miGrid.addComponent(informacion, 0, 0);
        miGrid.addComponent(combo, 0, 1);
        miGrid.addComponent(botonMas, 1, 1);
        miGrid.addComponent(botonMenos, 2, 1);
        
        return miGrid;
  
    }
    
    private String mostrarValores() {
        String datos = "";
        for (int i= 0; i < valores.size(); i++) {
            datos += valores.get(i);
        }
        
        return datos;
    }
    
       
//    private void rellenarDatos() {
//        String listaEspecies[] = {"Pocino Ibérico", "Pocino Blanco", "Ovino", "Vacuno", "Avicultura", "Otros"};
//
//        especies = new HashMap<>();
//        
//        for (int i = 0; i < 6; i++) {
//            especies.put(i, listaEspecies[i]);
//        }
//        
//        
//    }


    
    
    
}
