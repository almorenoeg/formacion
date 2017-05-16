package com.terralcode.gestion.frontend.view.widgets.customer;

import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
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
class CustomerAddressesPanel extends Panel {

    private FieldGroup fieldGroup;
    private CustomerCRM customer;

    private VerticalLayout layout;
    
    public CustomerAddressesPanel() {
        super();
        layout = new VerticalLayout();
        this.setContent(layout);
    }
    
    public void bindCustomer(CustomerCRM customer) {
        this.customer = customer;
        refreshBind();
    }

    private void refreshBind() {
        clearAddresses();
        this.customer.getAddressList().forEach(t -> addAddress(t));
        addAddressToolbar();
    }

    private void clearAddresses() {
        layout.removeAllComponents();
    }

    private void addAddress(PlainAddress address) {
        AddressButton newAddress = new AddressButton(address);
        newAddress.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                AddressButton button = (AddressButton) (event.getButton());
                openAddressWindow(button.getAddress());
            }
        });
        layout.addComponent(newAddress);
    }
    
    private void addAddressToolbar() {
        Button newAddress = new Button("", FontAwesome.PLUS);
        newAddress.addStyleName(ValoTheme.BUTTON_LINK);
        newAddress.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                PlainAddress newAddress = new PlainAddress();
                customer.getAddressList().add(newAddress);
                openAddressWindow(newAddress);
            }
        });
        layout.addComponent(newAddress);
    }
    
    private void openAddressWindow(PlainAddress address) {

        WebBrowser webBrowser = Page.getCurrent().getWebBrowser();
        
        Window window = new Window("Registro de dirección");
        window.setModal(true);
        if (webBrowser.getScreenWidth()<1024) {
            window.setSizeFull();
        } else {
            window.setHeight(90.0f, Unit.PERCENTAGE);
            window.setWidth(90.0f, Unit.PERCENTAGE);
        }

        TextField line1Field = new TextField();
        line1Field.setInputPrompt("Introduzca dirección...");
        line1Field.setWidth("100%");
        TextField line2Field = new TextField();
        line2Field.setInputPrompt("Introduzca dirección...");
        line2Field.setWidth("100%");
        TextField cpField = new TextField();
        cpField.setInputPrompt("Introduzca código postal...");
        cpField.setWidth("100%");
        TextField cityField = new TextField();
        cityField.setInputPrompt("Introduzca ciudad...");
        cityField.setWidth("100%");
        TextField provinceField = new TextField();
        provinceField.setInputPrompt("Introduzca provincia...");
        provinceField.setWidth("100%");
        TextField countryField = new TextField();
        countryField.setInputPrompt("Introduzca país...");
        countryField.setWidth("100%");
        
        HorizontalLayout horizontal = new HorizontalLayout();
        horizontal.setSpacing(true);
        horizontal.addComponent(createDeleteButton(window));
        horizontal.addComponent(createOkButton(window));

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.addComponent(line1Field);
        layout.addComponent(line2Field);
        layout.addComponent(cpField);
        layout.addComponent(cityField);
        layout.addComponent(provinceField);
        layout.addComponent(countryField);
        layout.addComponent(horizontal);
        layout.setComponentAlignment(horizontal, Alignment.MIDDLE_RIGHT);

        BeanItem beanItem = new BeanItem<>(address);
        fieldGroup = new BeanFieldGroup<>(PlainAddress.class);
        fieldGroup.setItemDataSource(beanItem);
        fieldGroup.bind(line1Field, "addressLine1");
        fieldGroup.bind(line2Field, "addressLine2");
        fieldGroup.bind(cpField, "postalCode");
        fieldGroup.bind(cityField, "city");
        fieldGroup.bind(provinceField, "province");
        fieldGroup.bind(countryField, "country");

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
                BeanItem<PlainAddress> beanItem = (BeanItem<PlainAddress>) fieldGroup.getItemDataSource();
                PlainAddress address = beanItem.getBean();
                customer.getAddressList().remove(address);
                refreshBind();
                window.close();
            }
        });
        return delButton;
    }
}
