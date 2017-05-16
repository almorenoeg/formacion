/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.customer;

import com.terralcode.gestion.business.appointment.AppointmentService;
import com.terralcode.gestion.business.customer.CustomerCRMService;
import com.terralcode.gestion.business.customer.SpeciesService;
import com.terralcode.gestion.business.sales.SalesService;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.customer.Species;
import com.terralcode.gestion.domain.sales.Sales;
import com.terralcode.gestion.frontend.view.panel.species.SpeciesPanel;
import com.terralcode.gestion.frontend.view.widgets.sales.SalesPanel;
import com.naoset.framework.business.company.relationship.customer.CustomerStatusService;
import com.naoset.framework.business.company.relationship.customer.CustomerTypeService;
import com.naoset.framework.domain.company.relationship.customer.CustomerStatus;
import com.naoset.framework.domain.company.relationship.customer.CustomerType;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.naoset.framework.frontend.view.window.Window;
import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.WebBrowser;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jmsuarez
 */
public class CustomerView extends Widget {

    @Inject
    CustomerStatusService customerStatusService;
    @Inject
    CustomerCRMService customerCRMService;
    @Inject
    SpeciesService speciesService;
    @Inject
    CustomerTypeService customerTypeService;
    @Inject
    SalesService salesService;
    @Inject
    AppointmentService appointmentService;

    BeanItem<CustomerCRM> beanItem;
    protected CustomerCRM customer;
    FieldGroup fieldGroup;

    Window window;

    // <editor-fold defaultstate="collapsed" desc="Definition action button">
    MenuBar menubar = new MenuBar();
    //private final MenuBar.MenuItem addOperation;
    //private final MenuBar.MenuItem editOperation;
    private final MenuBar.MenuItem saveOperation;
    private final MenuBar.MenuItem trashOperation;
    // </editor-fold>

    private TextField codeField;
    private TextField nameField;
    private TextField taxCodeField;
    private TextField telephoneField;
    private ComboBox statusField;
    private ComboBox typeField;
    private CheckBox prestigeField;
    private CheckBox exclusiveField;
    private CheckBox canGrowField;
    private TextField consultingLevelField;
    private TextField salesLevelField;
    private CustomerAddressesPanel customerAddressesPanel;
    private CustomerContactsPanel customerContactsPanel;
    private SpeciesPanel customerSpeciesPanel;
    private SalesPanel salesPanel;
    private CustomerAppointmentsPanel appointmentsPanel;
    private FormLayout mainLayout;

    public CustomerView() {
        super();
        saveOperation = menubar.addItem("", FontAwesome.SAVE, save());
        trashOperation = menubar.addItem("", FontAwesome.TRASH_O, delete());
    }

    @Override
    protected Component buildContent() {
        addMenuItems(saveOperation);
        addMenuItems(trashOperation);

        Component layout = buildLayout();

        WebBrowser webBrowser = Page.getCurrent().getWebBrowser();
        window = new Window(this);
        window.addStyleName("profile-window");
        window.setModal(true);
        if (webBrowser.getScreenWidth() < 1024) {
            window.setSizeFull();
        } else {
            window.setHeight(90.0f, Unit.PERCENTAGE);
            window.setWidth(90.0f, Unit.PERCENTAGE);
        }

        return layout;
    }

    @Override
    protected String caption() {
        return "Ficha de Cliente";
    }

    public void open() {
        UI.getCurrent().addWindow(window);
        window.focus();
    }

    public void open(CustomerCRM customer) {
        this.customer = customer;
        bindModel();
        open();
    }

    private FormLayout buildLayout() {
        mainLayout = new FormLayout();
        mainLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        mainLayout.setMargin(new MarginInfo(true, false, false, false));

        buildCustomerHeader();
        buildCustomerSpecies();
        buildCustomerAddresses();
        buildCustomerContacts();
        buildSales();
        buildAppointments();

        return mainLayout;
    }

    private void buildCustomerHeader() {

        codeField = new TextField("Código");
        taxCodeField = new TextField("CIF");
        nameField = new TextField("Nombre");
        //telephoneField = new TextField("Teléfono");
        statusField = new ComboBox("Estado");
        statusField.setTextInputAllowed(false);
        typeField = new ComboBox("Tipo");
        typeField.setTextInputAllowed(false);
        
        prestigeField = new CheckBox("Imagen");
        prestigeField.setReadOnly(true);
        exclusiveField = new CheckBox("Exclusividad");
        exclusiveField.setReadOnly(true);
        canGrowField = new CheckBox("Puede crecer");
        canGrowField.setReadOnly(true);
        consultingLevelField = new TextField("Nivel Asesor.");
        consultingLevelField.setReadOnly(true);
        salesLevelField = new TextField("Nivel Ventas");
        salesLevelField.setReadOnly(true);
        
        codeField.setReadOnly(true);
        taxCodeField.setReadOnly(true);
        nameField.setReadOnly(true);

        mainLayout.addComponent(codeField);
        mainLayout.addComponent(taxCodeField);
        mainLayout.addComponent(nameField);
        //mainLayout.addComponent(telephoneField);
        mainLayout.addComponent(statusField);
        mainLayout.addComponent(typeField);
        mainLayout.addComponent(prestigeField);
        mainLayout.addComponent(exclusiveField);
        mainLayout.addComponent(canGrowField);
        mainLayout.addComponent(consultingLevelField);
        mainLayout.addComponent(salesLevelField);
    }

    private void buildCustomerSpecies() {
        customerSpeciesPanel = new SpeciesPanel("Especies con las que trabaja");
        customerSpeciesPanel.setWidth("100%");

        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setCaption("Especies con las que trabaja");
        wrapper.addComponent(customerSpeciesPanel);
        wrapper.setWidth("100%");
        mainLayout.addComponent(wrapper);
    }

    private void buildCustomerAddresses() {
        customerAddressesPanel = new CustomerAddressesPanel();
        customerAddressesPanel.setWidth("100%");

        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setCaption("Direcciones registradas");
        wrapper.addComponent(customerAddressesPanel);
        wrapper.setWidth("100%");
        mainLayout.addComponent(wrapper);
    }

    private void buildCustomerContacts() {
        customerContactsPanel = new CustomerContactsPanel();
        customerContactsPanel.setWidth("100%");

        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setCaption("Contactos registrados");
        wrapper.addComponent(customerContactsPanel);
        wrapper.setWidth("100%");
        mainLayout.addComponent(wrapper);
    }

    private void buildSales() {
        salesPanel = new SalesPanel();
        salesPanel.setWidth("100%");

        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setCaption("Últimas ventas");
        wrapper.addComponent(salesPanel);
        wrapper.setWidth("100%");
        mainLayout.addComponent(wrapper);
    }
    
    private void buildAppointments(){
        appointmentsPanel = new CustomerAppointmentsPanel();
        appointmentsPanel.setWidth("100%");
        
        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setCaption("Histórico citas");
        wrapper.addComponent(appointmentsPanel);
        wrapper.setWidth("100%");
        mainLayout.addComponent(wrapper);
    }

    private void bindModel() throws FieldGroup.BindException {

        //CustomerType combobox...
        BeanItemContainer<CustomerType> containerTypes = new BeanItemContainer<>(CustomerType.class);
        containerTypes.addAll(customerTypeService.findAll());
        typeField.setContainerDataSource(containerTypes);

        //CustomerStatus combobox...
        BeanItemContainer<CustomerStatus> containerStatuses = new BeanItemContainer<>(CustomerStatus.class);
        containerStatuses.addAll(customerStatusService.findAll());
        statusField.setContainerDataSource(containerStatuses);

        //Species
        BeanItemContainer<Species> containerSpecies = new BeanItemContainer<>(Species.class);
        containerSpecies.addAll(speciesService.findAll());

        beanItem = new BeanItem<>(customer);
        fieldGroup = new BeanFieldGroup<>(CustomerCRM.class);
        fieldGroup.setItemDataSource(beanItem);

        fieldGroup.bind(codeField, "code");
        fieldGroup.bind(nameField, "name");
        fieldGroup.bind(taxCodeField, "companyTaxCode");
        //fieldGroup.bind(telephoneField, "telephone");
        fieldGroup.bind(statusField, "customerStatus");
        fieldGroup.bind(typeField, "customerType");
        fieldGroup.bind(prestigeField, "prestige");
        fieldGroup.bind(exclusiveField, "exclusive");
        fieldGroup.bind(canGrowField, "canGrow");
        fieldGroup.bind(consultingLevelField, "consultingLevel");
        fieldGroup.bind(salesLevelField, "salesLevel");
        //fieldGroup.bind(notes, "notes");

        //Bind Species
        customerSpeciesPanel.bindElements(customer, containerSpecies);

        //Bind Addresses
        customerAddressesPanel.bindCustomer(customer);

        //Bind Contacts
        customerContactsPanel.bindCustomer(customer);
        
        //Bind last sales
        salesPanel.loadData(salesService.findSalesByCustomer(customer));
        
        //Bind Appointments. Will show appointments of the last three years
        Calendar start = Calendar.getInstance();
        start.add(Calendar.YEAR, -3);
        Calendar end = Calendar.getInstance();
        appointmentsPanel.loadData(appointmentService.findByCustomer(customer, start, end));

        codeField.setReadOnly(true);
        taxCodeField.setReadOnly(true);
        nameField.setReadOnly(true);
        statusField.setTextInputAllowed(false);
        prestigeField.setReadOnly(true);
        exclusiveField.setReadOnly(true);
        canGrowField.setReadOnly(true);
        consultingLevelField.setReadOnly(true);
        salesLevelField.setReadOnly(true);
    }

    private MenuBar.Command save() {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {

                if (fieldGroup.isValid()) {
                    try {
                        fieldGroup.commit();
                        customerCRMService.edit(customer);
                        Notification.show("Datos guardados correctamente");
                    } catch (Validator.InvalidValueException e) {
                        Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                    } catch (FieldGroup.CommitException e) {
                        Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                    }
                } else {
                    Notification.show("Complete los datos obligatorios", Notification.Type.ERROR_MESSAGE);
                }

            }
        };
    }

    private MenuBar.Command delete() {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
            }
        };
    }

    private Table loadSales(CustomerCRM customer) {

        SalesPanel salesView = new SalesPanel();
        List<Sales> sales = salesService.findSalesByCustomer(customer);

        return salesView.loadData(sales);

    }

    @Override
    public Boolean isModified() {
        return fieldGroup.isModified();
    }

}
