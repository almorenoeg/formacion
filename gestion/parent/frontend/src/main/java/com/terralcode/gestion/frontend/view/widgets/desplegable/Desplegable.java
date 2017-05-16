/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.desplegable;

import com.vaadin.ui.ListSelect;

/**
 *
 * @author TerralCode01
 */
public class Desplegable extends ListSelect{
    
//    @Inject
//    DataProvider dataProvider;
    
    public Desplegable() {
        init();
    }

    public Desplegable(String caption) {
        super(caption);
    }
    
    
    
    public void init() {
        
        addItems("Pocino Ibérico", "Pocino Blanco", "Ovino", "Vacuno", "Avicultura", "Otros");
        setNullSelectionAllowed(false);
        setRows(2);

    }
    
}
