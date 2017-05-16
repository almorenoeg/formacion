/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.frontend.component.profile;

import com.naoset.framework.frontend.view.widgetsgroup.WidgetGroup;
import com.vaadin.cdi.CDIView;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author almoreno
 */
@CDIView
public class CustomerEditWindow extends WidgetGroup{
    @Inject
    CustomerEditWindowView customerEditWindowView;
    
     @PostConstruct
    void init()
    {
        setTitle("Clientes");
        addWidgetPanel(customerEditWindowView, "dashboard-panel-slot-full");
        
    }

   
    
}
