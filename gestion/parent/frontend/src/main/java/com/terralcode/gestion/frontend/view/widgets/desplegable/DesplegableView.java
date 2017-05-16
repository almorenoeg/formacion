/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.desplegable;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author TerralCode01
 */
public class DesplegableView  {

    public DesplegableView() {
        buildCustomerDetail();
    }

      
    
    private Component buildCustomerDetail()
    {
        VerticalLayout verticalLayout = new VerticalLayout();
        Desplegable miDesplegable = new Desplegable();
        verticalLayout.addComponent(miDesplegable);

        return verticalLayout;
    }
    
}
