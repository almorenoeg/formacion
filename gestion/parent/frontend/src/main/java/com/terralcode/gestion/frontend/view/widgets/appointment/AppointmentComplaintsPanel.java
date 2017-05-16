/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.appointment;

import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.appointment.ComplaintType;
import com.terralcode.gestion.domain.appointment.Complaint;
//import com.naoset.framework.frontend.view.window.Window;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author jmsuarez
 */
public class AppointmentComplaintsPanel extends Panel {

    private FieldGroup fieldGroup;
    private Appointment appointment;
    
    private ComboBox complaintType;
    private VerticalLayout layout;
    
    public AppointmentComplaintsPanel() {
        super();
        layout = new VerticalLayout();
        createCombo();
        this.setContent(layout);
    }

    public void bindAppointment(Appointment appointment, BeanItemContainer<ComplaintType> containerComplaintType) {
        this.appointment = appointment;
        if (complaintType == null) {
            createCombo();
        }
        complaintType.setContainerDataSource(containerComplaintType);
        refreshBind();        
    }

    private void refreshBind() {
        clearComplaints();
        this.appointment.getComplaints().forEach(t -> addComplaint(t));
        
        addComplaintToolbar();
    }

    private void clearComplaints() {
        layout.removeAllComponents();
    }

    private void createCombo() {
        complaintType = new ComboBox();
        complaintType.setTextInputAllowed(false);
        complaintType.setInputPrompt("Seleccione un motivo...");
        complaintType.setWidth("100%"); 
    }
    private void addComplaint(Complaint complaint) {
        ComplaintButton newComplaint = new ComplaintButton(complaint);
        newComplaint.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                ComplaintButton button = (ComplaintButton) (event.getButton());
                openComplaintWindow(button.getComplaint());
            }
        });
        layout.addComponent(newComplaint);
    }

    private void addComplaintToolbar() {
        Button newComplaint = new Button("", FontAwesome.PLUS);
        newComplaint.addStyleName(ValoTheme.BUTTON_LINK);
        newComplaint.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                Complaint newComplaint = new Complaint();
                newComplaint.setAppointment(appointment);
                appointment.getComplaints().add(newComplaint);
                openComplaintWindow(newComplaint);
            }
        });
        layout.addComponent(newComplaint);
    }

    private void openComplaintWindow(Complaint complaint) {

        WebBrowser webBrowser = Page.getCurrent().getWebBrowser();
        
        Window window = new Window("Registro de Queja");
        window.setModal(true);
        if (webBrowser.getScreenWidth()<1024) {
            window.setSizeFull();
        } else {
            window.setHeight(90.0f, Unit.PERCENTAGE);
            window.setWidth(90.0f, Unit.PERCENTAGE);
        }

//        TextField nameField = new TextField();
//        nameField.setInputPrompt("Introduzca el tÃ­tulo de la queja");
//        nameField.setWidth("100%");
        TextArea notesArea = new TextArea();
        notesArea.setInputPrompt("Introduzca el contenido de la queja");
        notesArea.setSizeFull();
//        CheckBox doneField = new CheckBox("Atendido");
        
        HorizontalLayout horizontal = new HorizontalLayout();
        horizontal.setSpacing(true);
        horizontal.addComponent(createDeleteButton(window));
        horizontal.addComponent(createOkButton(window));

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.addComponent(complaintType);
        layout.addComponent(notesArea);
//        layout.addComponent(doneField);
        layout.addComponent(horizontal);
        layout.setComponentAlignment(horizontal, Alignment.MIDDLE_RIGHT);
        layout.setExpandRatio(complaintType, 1);
        layout.setExpandRatio(notesArea, 8);
//        layout.setExpandRatio(doneField, 1);
        layout.setExpandRatio(horizontal, 1);

        BeanItem beanItem = new BeanItem<>(complaint);
        fieldGroup = new BeanFieldGroup<>(Complaint.class);
        fieldGroup.setItemDataSource(beanItem);
        fieldGroup.bind(complaintType, "complaintType");
        fieldGroup.bind(notesArea, "notes");
//        fieldGroup.bind(doneField, "done");

        window.setContent(layout);
        getUI().addWindow(window);

//        Window windowComplaint = new Window(complaintView);
//        WidgetActions actions = new WidgetActions(){
//
//            @Override
//            public void saveAction() {
//                refreshBind();
//                windowComplaint.close();
//            }
//
//            @Override
//            public void deleteAction() {
//                appointment.getComplaints().remove(complaint);
//                refreshBind();
//                windowComplaint.close();
//            }
//            
//        };
//        complaintView.bind(complaint);
//        complaintView.setActions(actions);
//        getUI().addWindow(windowComplaint);
    }

    private Component createOkButton(Window window) {
        Button okButton = new Button("OK");
        okButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        okButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    fieldGroup.commit();
                    refreshBind();
                    window.close();
                } catch (FieldGroup.CommitException e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        return okButton;
    }

    private Component createDeleteButton(Window window) {
        Button delButton = new Button("Delete");
        delButton.setStyleName(ValoTheme.BUTTON_DANGER);
        delButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                BeanItem<Complaint> beanItem = (BeanItem<Complaint>) fieldGroup.getItemDataSource();
                Complaint complaint = beanItem.getBean();
                appointment.getComplaints().remove(complaint);
                refreshBind();
                window.close();
            }
        });
        return delButton;
    }
}
