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
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.inject.Inject;

/**
 *
 * @author jmsuarez
 */
public class DialogWindow extends com.vaadin.ui.Window {

    @Inject
    WidgetsEventBus eventBus;
    
    protected VerticalLayout layout;
    protected Panel bodyWrapper;
    protected Component body;
    protected HorizontalLayout footer;
    
    protected Button okButton;
    protected Button cancelButton;
    protected Button yesButton;
    protected Button noButton;
    protected Button closeButton;

    public DialogWindow() {
        super();
        this.setModal(true);
    }
    
    public DialogWindow(String title) {
        super(title);
        this.setModal(true);
        
        //addStyleName("moviedetailswindow");
        Responsive.makeResponsive(this);
        setCloseShortcut(ShortcutAction.KeyCode.ESCAPE, null);
        setResizable(false);
        setClosable(false);
        //setHeight(90.0f, Unit.PERCENTAGE);
        
        layout = new VerticalLayout();
        layout.setSizeFull();
        
        bodyWrapper = buildBodyWrapper();
        footer = buildFooter();
        
        layout.addComponent(bodyWrapper);
        layout.addComponent(footer);
        layout.setExpandRatio(bodyWrapper, 1f);
        
        setContent(layout);
        center();
        setHeight(layout.getHeight(), layout.getHeightUnits());
        setWidth(layout.getWidth(), layout.getWidthUnits());
    }

    
    public DialogWindow(String title, Component content, DialogButton... buttons)
    {
        this(title);
        
        this.body = content;
        bodyWrapper.setContent(body);
        setFooterButtons(buttons);
                
        center();
        setHeight(layout.getHeight(), layout.getHeightUnits());
        setWidth(layout.getWidth(), layout.getWidthUnits());
    }

    private Panel buildBodyWrapper() {
        Panel bodyWrapper = new Panel();
        bodyWrapper.setSizeFull();
        bodyWrapper.addStyleName(ValoTheme.PANEL_BORDERLESS);
        bodyWrapper.addStyleName("scroll-divider");
        return bodyWrapper;
    }
    public void setBody(Component body){
        this.body = body;
        bodyWrapper.setContent(body);
    }
    
    private HorizontalLayout buildFooter()
    {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
        layout.setWidth(100.0f, Unit.PERCENTAGE);
        return layout;
    }
    public void setFooterButtons(DialogButton... buttons)
    {
        footer.removeAllComponents();
        
        HorizontalLayout innerLayout = new HorizontalLayout();
        innerLayout.setSpacing(true);
        footer.addComponent(innerLayout);
        footer.setComponentAlignment(innerLayout, Alignment.TOP_RIGHT);
        
        for (DialogButton button : buttons) {
            Button btn = new Button();
            if(button.equals(DialogButton.OK)){
                btn.setCaption("OK");
                btn.addStyleName(ValoTheme.BUTTON_PRIMARY);
                btn.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(final Button.ClickEvent event)
                    {
                        onButtonOKClicked();
                    }
                });
                okButton = btn;
            }
            if(button.equals(DialogButton.CANCEL)){
                btn.setCaption("CANCEL");
                btn.addStyleName(ValoTheme.BUTTON_PRIMARY);
                btn.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(final Button.ClickEvent event)
                    {
                        onButtonCancelClicked();
                    }
                });
                cancelButton = btn;
            }
            if(button.equals(DialogButton.YES)){
                btn.setCaption("YES");
                btn.addStyleName(ValoTheme.BUTTON_PRIMARY);
                btn.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(final Button.ClickEvent event)
                    {
                        onButtonYesClicked();
                    }
                });
                yesButton = btn;
            }
            if(button.equals(DialogButton.NO)){
                btn.setCaption("NO");
                btn.addStyleName(ValoTheme.BUTTON_PRIMARY);
                btn.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(final Button.ClickEvent event)
                    {
                        onButtonNoClicked();
                    }
                });
                noButton = btn;
            }
            if(button.equals(DialogButton.CLOSE)){
                btn.setCaption("CLOSE");
                btn.addStyleName(ValoTheme.BUTTON_PRIMARY);
                btn.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(final Button.ClickEvent event)
                    {
                        onButtonCloseClicked();
                    }
                });
                closeButton = btn;
            }
            innerLayout.addComponent(btn);
        }
        
    }
    
    protected void onButtonOKClicked(){
        Notification.show("OK Button Clicked", Notification.Type.ASSISTIVE_NOTIFICATION);
    }
    protected void onButtonCancelClicked(){
        Notification.show("CANCEL Button Clicked", Notification.Type.ASSISTIVE_NOTIFICATION);
    }
    protected void onButtonYesClicked(){
        Notification.show("YES Button Clicked", Notification.Type.ASSISTIVE_NOTIFICATION);
    }
    protected void onButtonNoClicked(){
        Notification.show("NO Button Clicked", Notification.Type.ASSISTIVE_NOTIFICATION);
    }
    protected void onButtonCloseClicked(){
        Notification.show("CLOSE Button Clicked", Notification.Type.ASSISTIVE_NOTIFICATION);
    }
    
    public enum DialogButton {

        OK,
        CANCEL,
        YES,
        NO,
        CLOSE;
    }
}
