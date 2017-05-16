/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgetsgroup.showroom;

import com.naoset.framework.frontend.view.widgetsgroup.WidgetGroup;
import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import javax.annotation.PostConstruct;

/**
 *
 * @author Ezequiel
 */
@CDIView
public class ShowroomView extends WidgetGroup {

    @PostConstruct
    void init()
    {
        setTitle("Showroom");
        addWidgetPanel(new Label("Ejemplo de componente en TOP"));
        addWidgetPanel(new Label("Ejemplo de componente en TOP 2"));
        addWidgetPanel(new Button("Ejemplo de componente en WigetPanel"));
        addWidgetPanel(new Button("sadasadsadsa"));
    }

}
