/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.frontend.view.window;

import com.naoset.framework.frontend.event.WidgetsEventBus;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
public class Window extends com.vaadin.ui.Window {

    @Inject
    WidgetsEventBus eventBus;
    
    Window mySelf;
    Component body;
    HorizontalLayout footer;

    public Window(Component component)
    {
        mySelf = this;
        this.body = component;
        
        //addStyleName("moviedetailswindow");
        Responsive.makeResponsive(this);

        setCaption(body.getCaption());
        center();
        setCloseShortcut(ShortcutAction.KeyCode.ESCAPE, null);
        setResizable(false);
        setClosable(false);
        setHeight(90.0f, Unit.PERCENTAGE);

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        setContent(layout);

        Panel bodyWrapper = new Panel(body);
        bodyWrapper.setSizeFull();
        bodyWrapper.addStyleName(ValoTheme.PANEL_BORDERLESS);
        bodyWrapper.addStyleName("scroll-divider");
        layout.addComponent(bodyWrapper);
        layout.setExpandRatio(bodyWrapper, 1f);

        footer = buildFooter();
        layout.addComponent(footer);
    }

    private HorizontalLayout buildFooter()
    {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
        layout.setWidth(100.0f, Unit.PERCENTAGE);

        //Si el objeto a mostrar hereda de Widget, mostraremos su cabecera con el menú en la ventana.
        if (Widget.class.isInstance(body)) {
        //if (details.getClass().isInstance(Widget.class)) {
            Widget aux = (Widget)body;
            HorizontalLayout header = aux.getHeader();
            header.setWidth(100.0f, Unit.PERCENTAGE);
            layout.addComponent(header);
            //layout.setComponentAlignment(header, Alignment.TOP_LEFT);
            layout.setExpandRatio(header, 1);
        }
        
        Button ok = new Button("Cerrar");
        ok.addStyleName(ValoTheme.BUTTON_PRIMARY);
        ok.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event)
            {
                Boolean canClose = true;
                if (Widget.class.isInstance(body)) {
                    Widget aux = (Widget)body;
                    canClose = ! aux.isModified();
                }
                if (canClose) {
                    close();
                } else{
                    
                    buildConfirmCloseDialog();
                    
                }
                
            }
        });
        ok.focus();
        layout.addComponent(ok);
        layout.setComponentAlignment(ok, Alignment.TOP_RIGHT);
        return layout;
    }
    
    protected void buildConfirmCloseDialog(){
        VerticalLayout vl = new VerticalLayout();
        vl.setWidth("100%");
        vl.addComponent(new Label("Hay cambios sin grabar."));
        vl.addComponent(new Label("Si continúa, perderá estos cambios."));
        vl.addComponent(new Label(""));
        vl.addComponent(new Label("¿Desea continuar?"));
        DialogWindow dlgWin = new DialogWindow("Confirmación de cierre", vl, DialogWindow.DialogButton.YES, DialogWindow.DialogButton.NO){

            @Override
            protected void onButtonNoClicked() {
                close();
            }
            
            @Override
            protected void onButtonYesClicked() {
                close();
                mySelf.close();
            }
            
        };
        UI.getCurrent().addWindow(dlgWin);
        dlgWin.focus();
    }
}
