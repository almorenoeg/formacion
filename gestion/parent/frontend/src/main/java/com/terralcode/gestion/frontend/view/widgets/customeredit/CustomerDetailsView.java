/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.customeredit;

import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.cdi.CDIUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Ezequiel
 */
@CDIUI
public class CustomerDetailsView extends Widget {

    protected Component buildContent()
    {
        return buildCustomerDetail();
    }

    @Override
    protected String caption()
    {
        return "Detalles de cliente";
    }

    private Component buildCustomerDetail()
    {
        VerticalLayout verticalLayout = new VerticalLayout();
        TextField id = new TextField("id");
        TextField companyName = new TextField("Empresa");
        TextField phoneNumber = new TextField("Número de telefono");
        TextField address = new TextField("Dirección");
        verticalLayout.addComponent(id);
        verticalLayout.addComponent(companyName);
        verticalLayout.addComponent(phoneNumber);
        verticalLayout.addComponent(address);

        return verticalLayout;
    }


}
