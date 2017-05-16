/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgetsgroup.customers;

import com.naoset.framework.frontend.view.widgetsgroup.WidgetGroup;
import com.vaadin.cdi.CDIView;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author almoreno
 */
@CDIView
public class Customers extends WidgetGroup {
    @Inject
    com.terralcode.gestion.frontend.view.widgets.customers.Customers allCustomerView;
    
    @PostConstruct
    void init()
    {
       setTitle("Cliente");
       setSizeFull();
       addWidgetPanel(allCustomerView, "dashboard-panel-slot-full");
       toggleMaximized(allCustomerView.getParent().getParent(), true);
    }
}
