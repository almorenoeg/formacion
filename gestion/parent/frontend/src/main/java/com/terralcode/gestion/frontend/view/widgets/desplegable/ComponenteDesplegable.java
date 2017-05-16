/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.desplegable;

import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

/**
 *
 * @author TerralCode01
 */
public class ComponenteDesplegable extends Widget {

    protected Component buildContent() {
        return buildCustomerDetail();
    }

    @Override
    protected String caption() {
        return "Mi componente desplegable";
    }
    
     private Component buildCustomerDetail() {
//        GridLayout miGrid = new GridLayout(3, 2);
//        
//        ComboBox combo = new ComboBox();
//        combo.addItems("Pocino Ibérico", "Pocino Blanco", "Ovino", "Vacuno", "Avicultura", "Otros");
//        Label informacion = new Label();
//        Button botonMas = new Button("+");
//        Button botonMenos = new Button("-");
//        miGrid.addComponent(informacion, 0, 0, 2, 2);
//        miGrid.addComponent(combo, 1, 0);
//        miGrid.addComponent(botonMas, 1, 1);
//        miGrid.addComponent(botonMenos, 1, 2);
//        
//        return miGrid;
         return new ComponenteDesplegable(); 
    }

 
    
}
