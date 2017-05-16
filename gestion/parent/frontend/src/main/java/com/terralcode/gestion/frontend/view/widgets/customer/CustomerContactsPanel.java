package com.terralcode.gestion.frontend.view.widgets.customer;

import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.framework.domain.commons.contactinfo.ContactInfo;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author jmsuarez
 */
class CustomerContactsPanel extends Panel {

    private FieldGroup fieldGroup;
    private CustomerCRM customer;
    private VerticalLayout layout;
    
    public CustomerContactsPanel() {
        super();
        layout = new VerticalLayout();
        this.setContent(layout);
    }
    
    public void bindCustomer(CustomerCRM customer) {
        this.customer = customer;
        refreshBind();
    }
    
    private void refreshBind() {
        clearContacts();
        this.customer.getContactInfoList().forEach(t -> addContact(t));
        addContactToolbar();
    }
    
    private void clearContacts() {
        layout.removeAllComponents();
    }
    
    private void addContact(ContactInfo contact) {
        ContactInfoButton newContact = new ContactInfoButton(contact);
        newContact.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                ContactInfoButton button = (ContactInfoButton) (event.getButton());
                openContactWindow(button.getContact());
            }
        });
        layout.addComponent(newContact);
    }
    
    private void addContactToolbar() {
        Button newContact = new Button("", FontAwesome.PLUS);
        newContact.addStyleName(ValoTheme.BUTTON_LINK);
        newContact.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                ContactInfo newContact = new ContactInfo();
                customer.getContactInfoList().add(newContact);
                openContactWindow(newContact);
            }
        });
        layout.addComponent(newContact);
    }
    
    private void openContactWindow(ContactInfo contact) {

        WebBrowser webBrowser = Page.getCurrent().getWebBrowser();
        
        Window window = new Window("Registro de contacto");
        window.setModal(true);
        if (webBrowser.getScreenWidth()<1024) {
            window.setSizeFull();
        } else {
            window.setHeight(90.0f, Unit.PERCENTAGE);
            window.setWidth(90.0f, Unit.PERCENTAGE);
        }

        TextField contactPersonField = new TextField();
        contactPersonField.setInputPrompt("Introduzca nombre...");
        contactPersonField.setWidth("100%");
        TextField infoField = new TextField();
        infoField.setInputPrompt("Introduzca teléfono...");
        infoField.setWidth("100%");
        TextField commentsField = new TextField();
        commentsField.setInputPrompt("Introduzca comentario...");
        commentsField.setWidth("100%");
        
        
        HorizontalLayout horizontal = new HorizontalLayout();
        horizontal.setSpacing(true);
        horizontal.addComponent(createDeleteButton(window));
        horizontal.addComponent(createOkButton(window));

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.addComponent(contactPersonField);
        layout.addComponent(infoField);
        layout.addComponent(commentsField);
        layout.addComponent(horizontal);
        layout.setComponentAlignment(horizontal, Alignment.MIDDLE_RIGHT);

        BeanItem beanItem = new BeanItem<>(contact);
        fieldGroup = new BeanFieldGroup<>(ContactInfo.class);
        fieldGroup.setItemDataSource(beanItem);
        fieldGroup.bind(contactPersonField, "contactPerson");
        fieldGroup.bind(infoField, "info");
        fieldGroup.bind(commentsField, "comments");

        window.setContent(layout);
        getUI().addWindow(window);
    }
    
    private Component createOkButton(Window window) {
        Button okButton = new Button("Aceptar");
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
        Button delButton = new Button("Borrar");
        delButton.setStyleName(ValoTheme.BUTTON_DANGER);
        delButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                BeanItem<ContactInfo> beanItem = (BeanItem<ContactInfo>) fieldGroup.getItemDataSource();
                ContactInfo contact = beanItem.getBean();
                customer.getContactInfoList().remove(contact);
                refreshBind();
                window.close();
            }
        });
        return delButton;
    }
}
