/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.appointment;

import com.google.common.base.Strings;
import com.terralcode.gestion.business.appointment.AppointmentPurposeService;
import com.terralcode.gestion.business.appointment.AppointmentReasonService;
import com.terralcode.gestion.business.appointment.AppointmentService;
import com.terralcode.gestion.business.appointment.AppointmentStatusService;
import com.terralcode.gestion.business.appointment.AppointmentTypeService;
import com.terralcode.gestion.business.appointment.ComplaintTypeService;
import com.terralcode.gestion.business.customer.CustomerCRMService;
import com.terralcode.gestion.business.trade.TradeService;
import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.appointment.AppointmentPurpose;
import com.terralcode.gestion.domain.appointment.AppointmentReason;
import com.terralcode.gestion.domain.appointment.AppointmentStatus;
import com.terralcode.gestion.domain.appointment.AppointmentType;
import com.terralcode.gestion.domain.appointment.ComplaintType;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.trade.Trade;
import com.terralcode.gestion.frontend.event.AppointmentUpdatedEvent;
import com.terralcode.gestion.frontend.view.notification.PrettyNotification;
import com.terralcode.gestion.frontend.view.widgets.customer.CustomerView;
import com.naoset.framework.business.commons.timing.TimeLapseService;
import com.terralcode.framework.domain.commons.contactinfo.ContactInfo;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import com.naoset.framework.domain.commons.timing.TimeLapse;
import com.naoset.framework.domain.commons.timing.TimeLapseCalculator;
import com.naoset.framework.frontend.data.converters.DateToCalendarConverter;
import com.naoset.framework.frontend.data.converters.SetToListConverter;
import com.naoset.framework.frontend.event.DashboardEvent;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.naoset.framework.frontend.view.window.DialogWindow;
import com.naoset.framework.frontend.view.window.Window;
import com.vaadin.cdi.CDIView;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.WebBrowser;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Ezequiel
 */
@CDIView
public class AppointmentView extends Widget {

    @Inject
    CustomerView customerView;

    @Inject
    CustomerCRMService customerCRMService;
    @Inject
    AppointmentReasonService appointmentReasonService;
    @Inject
    TradeService tradeService;
    @Inject
    AppointmentStatusService appointmentStatusService;
    @Inject
    AppointmentService appointmentService;
    @Inject
    TimeLapseService timeLapseService;
    @Inject
    ComplaintTypeService complaintTypeService;
    @Inject
    AppointmentTypeService appointmentTypeService;
    @Inject
    AppointmentPurposeService appointmentPurposeService;

    //<editor-fold defaultstate="collapsed" desc="Model">
    protected Appointment appointment;
    protected BeanItem<Appointment> beanItem;
    protected FieldGroup fieldGroup;
    protected BeanItemContainer<CustomerCRM> containerCustomers;
    protected BeanItemContainer<AppointmentType> containerTypes;
    protected BeanItemContainer<PlainAddress> containerAddresses;
    protected BeanItemContainer<ContactInfo> containerContacts;
    protected BeanItemContainer<TimeLapse> containerTimeLapses;
    protected BeanItemContainer<AppointmentReason> containerReasons;
    protected BeanItemContainer<Trade> containerTrades;
    protected BeanItemContainer<AppointmentStatus> containerStatuses;
    protected BeanItemContainer<ComplaintType> containerComplaintTypes;
    protected BeanItemContainer<AppointmentPurpose> containerPurposes;

    TimeLapseCalculator timeLapseCalculator = new TimeLapseCalculator();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Definition action button">
    MenuBar menubar = new MenuBar();
    //private final MenuBar.MenuItem addOperation;
    //private final MenuBar.MenuItem editOperation;
    private final MenuBar.MenuItem saveOperation;
    private final MenuBar.MenuItem duplicateOperation;
    //private final MenuBar.MenuItem notifyOperation;
    //private final MenuBar.MenuItem trashOperation;
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Layout">
    private FormLayout rootLayout;
    private ComboBox customer;
    private Button customerDetails;
    private OptionGroup appointmentType;
    private ComboBox address;
    private Button addressDetails;
    private ComboBox contactInfo;
    private Button contactInfoDetails;
    private TextField contactNotes;
    private PopupDateField startTime;
    private ComboBox timeLapse;
    private ComboBox reason;
    private TextArea reasonNotes;
    private OptionGroup trades;
    private OptionGroup purposes;
    //private AppointmentTradesPanel2 appointmentTradesPanel;
    //private AppointmentTradesForm appointmentTradesForm;
    private TextArea notes;
    private AppointmentComplaintsPanel appointmentComplaintsPanel;
    private TextField distance;
    private ComboBox status;
    private CheckBox notifyChanges;
    private TextArea statusNotes;
    //</editor-fold>

    public AppointmentView() {
        super();
        saveOperation = menubar.addItem("", FontAwesome.SAVE, save());
        duplicateOperation = menubar.addItem("", FontAwesome.COPY, duplicate());
//        notifyOperation = menubar.addItem("Notificar", FontAwesome.BELL, toggleNotify());
//        notifyOperation.setCheckable(true);
    }

    @Override
    protected Component buildContent() {
        buildModel();
        addMenuItems(saveOperation, duplicateOperation);
        return buildAppointmentLayout();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event); //To change body of generated methods, choose Tools | Templates.
        if (!Strings.isNullOrEmpty(parameters) && NumberUtils.isNumber(parameters)) {
            Appointment find = appointmentService.find(Long.valueOf(parameters));
            if (find != null) {
                Window open = open(find);
                open.addCloseListener(new com.vaadin.ui.Window.CloseListener() {

                    @Override
                    public void windowClose(com.vaadin.ui.Window.CloseEvent e) {
                        UI.getCurrent().getNavigator().getDisplay().showView(event.getOldView());
                    }
                });
            } else {
                Notification.show("La cita no existe");
                getUI().getNavigator().getDisplay().showView(event.getOldView());
            }
        }
    }

    @Override
    protected String caption() {
        return "Cita";
    }

    public Window open() {
        WebBrowser webBrowser = Page.getCurrent().getWebBrowser();

        Window window = new Window(this);
        window.addStyleName("profile-window");
        window.setModal(true);
        if (webBrowser.getScreenWidth() < 1024) {
            window.setSizeFull();
        } else {
            window.setHeight(90.0f, Unit.PERCENTAGE);
            window.setWidth(90.0f, Unit.PERCENTAGE);
        }
        UI.getCurrent().addWindow(window);
        window.focus();
        return window;
    }

    public Window open(Appointment appointment) {
        bind(appointment);
        return open();
    }

    private void buildModel() {
        containerCustomers = new BeanItemContainer<>(CustomerCRM.class);
        containerTypes = new BeanItemContainer<>(AppointmentType.class);
        containerAddresses = new BeanItemContainer<>(PlainAddress.class);
        containerContacts = new BeanItemContainer<>(ContactInfo.class);
        containerTimeLapses = new BeanItemContainer<>(TimeLapse.class);
        containerReasons = new BeanItemContainer<>(AppointmentReason.class);
        containerTrades = new BeanItemContainer<>(Trade.class);
        containerStatuses = new BeanItemContainer<>(AppointmentStatus.class);
        containerComplaintTypes = new BeanItemContainer<>(ComplaintType.class);
        containerPurposes = new BeanItemContainer<>(AppointmentPurpose.class);
    }

    private FormLayout buildAppointmentLayout() {
        rootLayout = new FormLayout();

        rootLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        rootLayout.setMargin(new MarginInfo(true, false, false, false));

        buildAppointmentHeader();
        buildAppointmentContent();
        buildAppointmentStatus();

        return rootLayout;
    }

    private void buildAppointmentHeader() {
//        Label section = new Label("Objetivo");
//        section.addStyleName(ValoTheme.LABEL_H4);
//        section.addStyleName(ValoTheme.LABEL_COLORED);
//        rootLayout.addComponent(section);
        
        appointmentType = new OptionGroup("Tipo");
        appointmentType.setContainerDataSource(containerTypes);
        appointmentType.addStyleName("horizontal");
        appointmentType.setWidth("100%");
        //<editor-fold defaultstate="collapsed" desc="Enable customer and addresses combobox according to the selected appointment type">
        appointmentType.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                try {
                    AppointmentType appType = (AppointmentType) event.getProperty().getValue();
                    
                    if (appType.getCode().equals("VIS")) {
                        //customer.setEnabled(true);
                        //address.setEnabled(true);
                        //contactNotes.setEnabled(false);
                        
                        //contactNotes.setValue("");
                    }
                    if (appType.getCode().equals("COM")) {
                        //customer.setEnabled(true);
                        //address.setEnabled(false);
                        //contactNotes.setEnabled(false);
                        
                        //address.setValue(null);
                        //contactNotes.setValue("");
                    }
                    if (appType.getCode().equals("CON")) {
                        //customer.setEnabled(false);
                        //address.setEnabled(false);
                        //contactNotes.setEnabled(true);
                        
                        //customer.setValue(null);
                        //address.setValue(null);
                    }
                } catch (Exception e) {
                }

            }

        });
        //</editor-fold>
        rootLayout.addComponent(appointmentType);
        
        reason = new ComboBox("Motivo");
        reason.setContainerDataSource(containerReasons);
        reason.setTextInputAllowed(false);
        reason.setWidth("100%");
        rootLayout.addComponent(reason);
        
        Label customerSection = new Label("Cliente");
        customerSection.addStyleName(ValoTheme.LABEL_H4);
        customerSection.addStyleName(ValoTheme.LABEL_COLORED);
        rootLayout.addComponent(customerSection);
        buildCustomer();
        buildAddress();
        buildContactInfo();
        
        contactNotes = new TextField("Otro");
        contactNotes.setWidth("100%");
        contactNotes.setInputPrompt("Introduzca contacto o dirección...");
        rootLayout.addComponent(contactNotes);
        
        Label scheduleSection = new Label("Programación");
        scheduleSection.addStyleName(ValoTheme.LABEL_H4);
        scheduleSection.addStyleName(ValoTheme.LABEL_COLORED);
        rootLayout.addComponent(scheduleSection);
        
        startTime = new PopupDateField("Fecha");
        startTime.setTextFieldEnabled(false);
        startTime.setLocale(new Locale("es", "ES"));
        startTime.setResolution(Resolution.MINUTE);
        startTime.setDateFormat("dd/MM/yyyy HH:mm");
        startTime.setConverter(new DateToCalendarConverter());
        //startTime.setWidth(15, Unit.EM);
        rootLayout.addComponent(startTime);
        
//        aqui los comerciales
        trades = new OptionGroup("Comerciales");
        trades.setContainerDataSource(containerTrades);
        trades.setConverter(new SetToListConverter());
        trades.setNullSelectionAllowed(false);
        trades.setMultiSelect(true);
        trades.setImmediate(true);
        rootLayout.addComponent(trades); 
        
//        // Los propositos de la visita
//        purpose = new OptionGroup("Propósito");
//        purpose.setContainerDataSource(containerPurpose);
//        purpose.setConverter(new SetToListConverter());
//        purpose.setNullSelectionAllowed(false);
//        purpose.setMultiSelect(true);
//        purpose.setImmediate(true);
//        rootLayout.addComponent(purpose);
        
//        HorizontalLayout wrapper = new HorizontalLayout();
//        wrapper.setCaption("Fecha");
//        wrapper.addComponent(startTime);
//        wrapper.addComponent(timeLapse);
//        //wrapper.setComponentAlignment(timeLapse, Alignment.TOP_LEFT);
//        wrapper.setWidth("100%");
//        wrapper.setExpandRatio(startTime, 1);
//        wrapper.setExpandRatio(timeLapse, 1);
//        rootLayout.addComponent(wrapper);
//        contactInfo = new ComboBox();
//        contactInfo.setTextInputAllowed(false);
//        contactInfo.setInputPrompt("Seleccione un contacto...");
//        contactInfo.setWidth("100%");
//        rootLayout.addComponent(contactInfo);
        

//        reasonNotes = new TextArea("Notas previas");
//        reasonNotes.setWidth("100%");
//        reasonNotes.setInputPrompt("Anotaciones del motivo...");
//        rootLayout.addComponent(reasonNotes);

    }

    private void buildContactInfo() {
        contactInfo = new ComboBox();
        contactInfo.setContainerDataSource(containerContacts);
        contactInfo.setTextInputAllowed(false);
        contactInfo.setInputPrompt("Seleccione un contacto...");
        contactInfo.setWidth("100%");
        rootLayout.addComponent(contactInfo);
        
        contactInfoDetails = new Button(FontAwesome.PHONE);
        contactInfoDetails.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        contactInfoDetails.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (appointment.getContactInfo() != null) {
                    Notification.show("Funcionalidad en desarrollo.", Notification.Type.ASSISTIVE_NOTIFICATION);
                    //customerView.open(appointment.getCustomer());
                }
            }
        });
        
        HorizontalLayout wrapper = new HorizontalLayout();
        wrapper.setCaption("Contacto");
        wrapper.addComponent(contactInfo);
        wrapper.addComponent(contactInfoDetails);
        wrapper.setWidth("100%");
        wrapper.setExpandRatio(contactInfo, 1);
        rootLayout.addComponent(wrapper);
    }

    private void buildAddress() {
        address = new ComboBox();
        address.setContainerDataSource(containerAddresses);
        address.setTextInputAllowed(false);
        address.setInputPrompt("Seleccione una dirección...");
        address.setWidth("100%");
        rootLayout.addComponent(address);
        
        addressDetails = new Button(FontAwesome.MAP_MARKER);
        addressDetails.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        addressDetails.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (appointment.getAddress() != null) {
                    Notification.show("Funcionalidad en desarrollo.", Notification.Type.ASSISTIVE_NOTIFICATION);
                    //customerView.open(appointment.getCustomer());
                }
            }
        });
        
        HorizontalLayout wrapper = new HorizontalLayout();
        wrapper.setCaption("Dirección");
        wrapper.addComponent(address);
        wrapper.addComponent(addressDetails);
        wrapper.setWidth("100%");
        wrapper.setExpandRatio(address, 1);
        rootLayout.addComponent(wrapper);
    }

    private void buildCustomer() {
        customer = new ComboBox();
        customer.setContainerDataSource(containerCustomers);
        customer.setFilteringMode(FilteringMode.CONTAINS);
        customer.setInputPrompt("Seleccione un cliente...");
        customer.setWidth("100%");
        //<editor-fold defaultstate="collapsed" desc="Adjust ContactInfo and Addresses according to the selected Customer">
        customer.addValueChangeListener(new ValueChangeListener() {
            
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                updateCustomerCombos((CustomerCRM) event.getProperty().getValue());
            }
            
            private void updateCustomerCombos(CustomerCRM customerCRM) {
                if (customerCRM != null) {
                    containerAddresses.removeAllItems();
                    address.setValue(null);
                    containerAddresses.addAll(customerCRMService.find(customerCRM.getId()).getAddressList());
                    if (containerAddresses.size() > 0) {
                        address.select(containerAddresses.getIdByIndex(0));
                    }
                    
                    containerContacts.removeAllItems();
                    contactInfo.setValue(null);
                    containerContacts.addAll(customerCRMService.find(customerCRM.getId()).getContactInfoList());
                    if (containerContacts.size()> 0) {
                        contactInfo.select(containerContacts.getIdByIndex(0));
                    }
                } else {
                    containerAddresses.removeAllItems();
                    address.setValue(null);
                    
                    containerContacts.removeAllItems();
                    contactInfo.setValue(null);
                }
            }
        });
        //</editor-fold>
        
        customerDetails = new Button(FontAwesome.EYE);
        customerDetails.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        customerDetails.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (appointment.getCustomer() != null) {
                    customerView.open(appointment.getCustomer());
                }
            }
        });
        
        HorizontalLayout customerWrapper = new HorizontalLayout();
        customerWrapper.setCaption("Cliente");
        customerWrapper.addComponent(customer);
        customerWrapper.addComponent(customerDetails);
        customerWrapper.setWidth("100%");
        customerWrapper.setExpandRatio(customer, 1);
        rootLayout.addComponent(customerWrapper);
        
        //<editor-fold defaultstate="collapsed" desc="Antiguo buscador de clientes">
        //        Button searchCustomerBtn = new Button("Busca!");
//        searchCustomerBtn.addClickListener(new Button.ClickListener() {
//
//            @Override
//            public void buttonClick(Button.ClickEvent event) {
//                CustomerFinderDialogWindow dlgWin = new CustomerFinderDialogWindow(appointment.getCustomer(), customerCRMService){
//
//                    @Override
//                    protected void onButtonCancelClicked() {
//                        this.close();
//                    }
//
//                    @Override
//                    protected void onButtonOKClicked() {
//                        //appointment.setCustomer(this.getSelectedCustomer());
//                        customer.setValue(this.getSelectedCustomer());
//                        //updateCustomerCombos(appointment.getCustomer());
//                        this.close();
//                    }
//
//
//
//                };
//                UI.getCurrent().addWindow(dlgWin);
//                dlgWin.focus();
//            }
//        });
//        rootLayout.addComponent(searchCustomerBtn);
//</editor-fold>    
    }

    private void buildAppointmentContent() {
        Label section = new Label("Resultado");
        section.addStyleName(ValoTheme.LABEL_H4);
        section.addStyleName(ValoTheme.LABEL_COLORED);
        rootLayout.addComponent(section);

        //Duración de la cita
        timeLapse = new ComboBox("Duración");
        timeLapse.setContainerDataSource(containerTimeLapses);
        timeLapse.setTextInputAllowed(false);
        timeLapse.setInputPrompt("Duración...");
        rootLayout.addComponent(timeLapse);
        
        //Kilometraje
        distance = new TextField("Kms");
        distance.setNullRepresentation("");
        rootLayout.addComponent(distance);
        
        //Notas
        notes = new TextArea("Resumen");
        //notes.setSizeFull();
        notes.setInputPrompt("Introduzca notas...");
        rootLayout.addComponent(notes);
        
        // Los resultados de la visita
        purposes = new OptionGroup("Resultados");
        purposes.setContainerDataSource(containerPurposes);
        purposes.setConverter(new SetToListConverter());
        purposes.setNullSelectionAllowed(true);
        purposes.setMultiSelect(true);
        purposes.setImmediate(true);
        rootLayout.addComponent(purposes);
        
        //Quejas registradas
        buildAppointmentComplaints();
    }

    private void buildAppointmentComplaints() {
        appointmentComplaintsPanel = new AppointmentComplaintsPanel();
        appointmentComplaintsPanel.setWidth("100%");

        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setCaption("Quejas");
        wrapper.addComponent(appointmentComplaintsPanel);
        wrapper.setWidth("100%");
        rootLayout.addComponent(wrapper);
    }

    private void buildAppointmentStatus() {
        Label section = new Label("Estado");
        section.addStyleName(ValoTheme.LABEL_H4);
        section.addStyleName(ValoTheme.LABEL_COLORED);
        rootLayout.addComponent(section);

        status = new ComboBox();
        status.setContainerDataSource(containerStatuses);
        status.setWidth("100%");
        status.setTextInputAllowed(false);
        status.setNullSelectionAllowed(false);
        
        notifyChanges = new CheckBox();
        notifyChanges.setIcon(FontAwesome.BELL);
        notifyChanges.setImmediate(true);
        
        HorizontalLayout statusWrapper = new HorizontalLayout();
        statusWrapper.setCaption("Estado");
        statusWrapper.addComponent(status);
        statusWrapper.addComponent(notifyChanges);
        statusWrapper.setWidth("100%");
        statusWrapper.setExpandRatio(status, 1);
        rootLayout.addComponent(statusWrapper);
        
        statusNotes = new TextArea("Notas de estado");
        statusNotes.setWidth("100%");
        statusNotes.setInputPrompt("Anotaciones del estado...");
        rootLayout.addComponent(statusNotes);
    }
    
    private void bind(Appointment model) throws FieldGroup.BindException {

        this.appointment = model;
        
        containerCustomers.addAll(customerCRMService.findAll());
        containerCustomers.sort(new Object[]{"name"}, new boolean[]{true});
        
        containerTypes.addAll(appointmentTypeService.findAll());

        //Address and contact comboboxes. Pickup from customers's values
        if (appointment.getCustomer() != null) {
            containerAddresses.addAll(customerCRMService.find(appointment.getCustomer().getId()).getAddressList());
            containerContacts.addAll(customerCRMService.find(appointment.getCustomer().getId()).getContactInfoList());
        }
        
        //TimeLapse combobox...
        timeLapseCalculator.setLapses(timeLapseService.findAll());
        containerTimeLapses.addAll(timeLapseCalculator.getMinuteLapses());
        containerTimeLapses.addAll(timeLapseCalculator.getHourLapses());

        containerReasons.addAll(appointmentReasonService.findAll());
        containerTrades.addAll(tradeService.findAll());
        containerPurposes.addAll(appointmentPurposeService.findAll());
        containerComplaintTypes.addAll(complaintTypeService.findAll());
        containerStatuses.addAll(appointmentStatusService.findAll());

        beanItem = new BeanItem<>(appointment);
        fieldGroup = new BeanFieldGroup<>(Appointment.class);
        fieldGroup.setItemDataSource(beanItem);
        fieldGroup.bind(customer, "customer");
        fieldGroup.bind(appointmentType, "appointmentType");
        fieldGroup.bind(address, "address");
        fieldGroup.bind(contactInfo, "contactInfo");
        fieldGroup.bind(contactNotes, "contactNotes");
        fieldGroup.bind(startTime, "programDateStart");
        fieldGroup.bind(timeLapse, "timeLapse");        
        fieldGroup.bind(reason, "appointmentReason");
//        fieldGroup.bind(reasonNotes, "reasonNotes");
        fieldGroup.bind(trades, "trades");
        fieldGroup.bind(purposes, "purposes");
        fieldGroup.bind(notes, "notes");
        fieldGroup.bind(distance, "distance");
        fieldGroup.bind(status, "status");
        fieldGroup.bind(statusNotes, "statusNotes");
        fieldGroup.bind(notifyChanges, "notifyChanges");

        //Bind complaints
        appointmentComplaintsPanel.bindAppointment(appointment, containerComplaintTypes);

        //Set default 'enabled' value for combos and other controls related.
//        customer.setEnabled(appointment.getAppointmentType().getCode().equals("VIS") || appointment.getAppointmentType().getCode().equals("COM"));
//        address.setEnabled(appointment.getAppointmentType().getCode().equals("VIS"));
//        contactInfo.setEnabled(appointment.getAppointmentType().getCode().equals("COM"));
//        contactNotes.setEnabled(appointment.getAppointmentType().getCode().equals("CON"));
        
        //notifyOperation.setChecked(appointment.getNotifyChanges());
    }

    private MenuBar.Command save() {
        return (MenuBar.MenuItem selectedItem) -> {

            if (fieldGroup.isValid()) {

                try {
                    fieldGroup.commit();

                    if (appointment.getTimeLapse() != null) 
                    {
                        appointment.setProgramDateEnd(timeLapseCalculator.calculateLapse(appointment.getProgramDateStart(), appointment.getTimeLapse()));
                    } else
                    {
                        //Si no se ha especificado intervalo de tiempo, se pone la hora de inicio
                        appointment.setProgramDateEnd(appointment.getProgramDateStart());
                    }
                    appointment = appointmentService.edit(appointment);

                    Notification success = new PrettyNotification("Cita guardada correctamente.");
                    success.show(Page.getCurrent());

                    eventBus.post(new DashboardEvent.NotificationsCountUpdatedEvent());
                    eventBus.post(new AppointmentUpdatedEvent());
                } catch (Validator.InvalidValueException | FieldGroup.CommitException e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            } else {
                Notification.show("Complete los datos obligatorios.", Notification.Type.ERROR_MESSAGE);
            }

        };
    }

    private MenuBar.Command duplicate() {

        return (MenuBar.MenuItem selectedItem) -> {
            if (this.fieldGroup.isModified()) {
                Notification.show("Guarde los cambios pendientes antes de continuar.");
            } else {
                duplicateAppointment(appointment);
            }
        };
    }

//    private MenuBar.Command toggleNotify() {
//        return (MenuBar.MenuItem selectedItem) -> {
//            appointment.setNotifyChanges(selectedItem.isChecked());
//        };
//    }

    private void duplicateAppointment(Appointment app) {

        InlineDateField date = new InlineDateField();
        //date.setTextFieldEnabled(false);
        date.setLocale(new Locale("es", "ES"));
        date.setResolution(Resolution.MINUTE);
        date.setValue(app.getProgramDateStart().getTime());
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(date);
        layout.setComponentAlignment(date, Alignment.MIDDLE_CENTER);

        DialogWindow dlgWin = new DialogWindow("Seleccione una fecha", layout,
                DialogWindow.DialogButton.OK, DialogWindow.DialogButton.CANCEL) {

                    @Override
                    protected void onButtonCancelClicked() {
                        this.close();
                    }

                    @Override
                    protected void onButtonOKClicked() {
                        java.util.Calendar cal;
                        cal = new java.util.Calendar.Builder().build();
                        cal.setTime(date.getValue());
                        try {
                            Appointment newAppointment = appointmentService.duplicate(app, cal);

                            Notification success = new PrettyNotification("Cita duplicada correctamente");
                            success.show(Page.getCurrent());

                            
                            eventBus.post(new DashboardEvent.NotificationsCountUpdatedEvent());
                            eventBus.post(new AppointmentUpdatedEvent());
                            this.close();
                            
                            bind(newAppointment);
                        } catch (InstantiationException | IllegalAccessException ex) {
                            Logger.getLogger(AppointmentView.class.getName()).log(Level.SEVERE, null, ex);
                            Notification.show(ex.getMessage(), Notification.Type.ERROR_MESSAGE);
                        }
                    }

                };

        dlgWin.setModal(true);
        dlgWin.setCaption("Seleccione nueva fecha");
        UI.getCurrent().addWindow(dlgWin);
        dlgWin.focus();
    }

    private PlainAddress searchAddresDefaultValue(List<PlainAddress> address) {

        PlainAddress defaultAddres = null;

        for (PlainAddress dAddres : address) {
            if (dAddres.getDefaultValue() != null && dAddres.getDefaultValue()) {
                defaultAddres = dAddres;
            }
        }
        return defaultAddres;
    }

    private void openAndBackOnClose(Appointment find) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isModified() {
        return fieldGroup.isModified();
    }
}
