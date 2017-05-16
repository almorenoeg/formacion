/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.frontend.vista.widgets.alumno;

import com.naoset.framework.frontend.data.converters.DateToCalendarConverter;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.naoset.framework.frontend.view.window.Window;
import com.terralcode.framework.domain.Direccion;
import com.terralcode.framework.domain.alumno.Alumno;
import com.terralcode.framework.domain.alumno.NivelEstudios;
import com.terralcode.framework.domain.catalogos.Colectivo;
import com.terralcode.framework.domain.catalogos.EstadoOcupacional;
import com.terralcode.framework.domain.catalogos.Sexo;
import com.terralcode.gestion.business.alumnos.NivelEstudioService;
import com.terralcode.gestion.business.catalogos.EstadoOcupacionalService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.WebBrowser;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Locale;
import javax.inject.Inject;

/**
 *
 * @author almoreno
 */
public class AlumnoVista extends Widget {
    
    Alumno alumno;
    
    FieldGroup fieldGroup;
    
    // Alumnos
    private TextField idField;
    private TextField nombreField;
    private TextField apellido1Field;
    private TextField apellido2Field;
    private TextField dniField;
    private TextField emailField;
    private TextField movilAlumnoField;
    Sexo sexo;
    private OptionGroup sexoField;
    private OptionGroup exentoPracticasField;
    private OptionGroup estadosOcupacionalField;
    private OptionGroup derivadoINEMField;
    private OptionGroup reservaField;
    private OptionGroup discapacidadField;
    private PopupDateField fechaNacimientoField;
    
    
   
    private TextField numeroSSGGField;
//    private EstadoOcupacional estadoOcupacional;
//    private Colectivo colectivo;
//    private Boolean derivadoINEM;
//    private Boolean exentoPracticas;
//    private Boolean reserva;
//    private Boolean discapacidad;
    
    
    // Direccion
    protected TextField direccionField;
    protected TextField direccion2Field;
    protected TextField ciudadField;
    protected TextField provinciaField;
    protected TextField codigoPostalField;
    
    // Empresa
    protected TextField nombreEmpresaField;
    protected TextField  cifNifEmpresaField;
    protected TextField  telefonoEmpresaField;
    private Direccion direccionEmpresaField;
    protected TextField  numeroEmpleadosEmpresaField;
    protected TextField  codigoPostalEmpresaField;
    protected TextField  localidadEmpresaField;
    
    // Nivel de estudios
    private OptionGroup nivelEstudiosField;
    private OptionGroup abandonoEstudiosField;
    
    // Ayudas
    private OptionGroup manutencionField;
    private OptionGroup transporteField;
    private OptionGroup alojamientoField;

    MenuBar menubar = new MenuBar();
    //private final MenuBar.MenuItem addOperation;
    private final MenuBar.MenuItem editOperation;
    private final MenuBar.MenuItem saveOperation;
    private final MenuBar.MenuItem trashOperation;
    
    TabSheet tabDatos;

    protected BeanItemContainer<EstadoOcupacional> containerEstadosOcupacional;
    protected BeanItemContainer<NivelEstudios> containerNivelEstudios;
    
    private FormLayout mainLayout;

    Window window;
    
    @Inject
    EstadoOcupacionalService estadoOcupacionalService;
    
    @Inject
    NivelEstudioService nivelEstudiosService;

    public AlumnoVista() {
        super();
        saveOperation = menubar.addItem("", FontAwesome.SAVE, save());
        trashOperation = menubar.addItem("", FontAwesome.TRASH_O, delete());
        editOperation = menubar.addItem("", FontAwesome.EDIT, editar());
    }
    
    public void open(Alumno alumno) {
        this.alumno = alumno;
        bindModel();
        open();
    }
    
    public void open() {
        UI.getCurrent().addWindow(window);
        window.focus();
    }

    @Override
    protected Component buildContent() {
        
        createContainers();
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
        addMenuItems(saveOperation, trashOperation);
       
        return layout;
    }

    @Override
    protected String caption() {
        return "Ficha de Alumno";
    }

    private FormLayout buildLayout() {
        mainLayout = new FormLayout();
        mainLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        mainLayout.setMargin(new MarginInfo(true, false, false, false));
        
        buildDatosAlumno();
        
        tabDatos = new TabSheet();
        mainLayout.addComponent(tabDatos);         
        
        buildDatosAlumnoExtras();
        buildEmpresaTab();
        buildDireccion();
        buildEstudiosTab();
        buildAyudasTab();

        return mainLayout;
    }

    private MenuBar.Command save() {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {

//                if (fieldGroup.isValid()) {
//                    try {
//                        fieldGroup.commit();
//                        customerCRMService.edit(customer);
//                        Notification.show("Datos guardados correctamente");
//                    } catch (Validator.InvalidValueException e) {
//                        Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
//                    } catch (FieldGroup.CommitException e) {
//                        Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
//                    }
//                } else {
//                    Notification.show("Complete los datos obligatorios", Notification.Type.ERROR_MESSAGE);
//                }

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
    
    private MenuBar.Command editar() {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
            }
        };
    }

    private void buildDatosAlumno() {
        nombreField = new TextField("Nombre");
        apellido1Field = new TextField("Primer Apellido");
        apellido2Field = new TextField("Segundo Apellido");
//        idField = new TextField("Código");
        dniField = new TextField("CIF");
        numeroSSGGField = new TextField("SSGG");
        emailField = new TextField("Email");
        movilAlumnoField = new TextField("Movil");
        
        sexoField = new OptionGroup("Sexo");
        sexoField.addItem(Boolean.FALSE);
        sexoField.setItemCaption(Boolean.FALSE, "Mujer");
        sexoField.addItem(Boolean.TRUE);
        sexoField.setItemCaption(Boolean.TRUE, "Hombre");
        sexoField.addStyleName("horizontal");
        
        discapacidadField = new OptionGroup("Discapacitado");
        discapacidadField.addItem(Boolean.FALSE);
        discapacidadField.setItemCaption(Boolean.FALSE, "Si");
        discapacidadField.addItem(Boolean.TRUE);
        discapacidadField.setItemCaption(Boolean.TRUE, "No");
        discapacidadField.select("No");
        discapacidadField.addStyleName("horizontal");
        
        fechaNacimientoField = new PopupDateField("Fecha Nacimiento");
        fechaNacimientoField.setTextFieldEnabled(false);
        fechaNacimientoField.setLocale(new Locale("es", "ES"));
        fechaNacimientoField.setResolution(Resolution.MINUTE);
        fechaNacimientoField.setDateFormat("dd/MM/yyyy");
        fechaNacimientoField.setConverter(new DateToCalendarConverter());
        
        HorizontalLayout dniSsggLayout = new HorizontalLayout();
        
        dniSsggLayout.addComponent(dniField);
        dniSsggLayout.addComponent(numeroSSGGField);
        mainLayout.addComponent(dniSsggLayout);
        
        HorizontalLayout nombresLayout = new HorizontalLayout();
        
        nombresLayout.addComponent(nombreField);
        nombresLayout.addComponent(apellido1Field);
        nombresLayout.addComponent(apellido2Field);        
        mainLayout.addComponent(nombresLayout);
        
        HorizontalLayout alumnoDatosLayout = new HorizontalLayout();
        
        alumnoDatosLayout.addComponent(sexoField);        
        alumnoDatosLayout.addComponent(fechaNacimientoField);        
        alumnoDatosLayout.addComponent(discapacidadField);
        mainLayout.addComponent(alumnoDatosLayout);
        
        mainLayout.addComponent(emailField);
        mainLayout.addComponent(movilAlumnoField);
    }
    
    
//    private void buildTabEmpresa() {
//        
//        
//        // Create the first tab
////        VerticalLayout layoutTab = new VerticalLayout();
////        layoutTab.addComponent(new Embedded(null, new ThemeResource("img/planets/Mercury.jpg")));
//        EmpresaVista empresa = new EmpresaVista();
////        tabEmpresa.addTab(empresa, "Empresa", new ThemeResource("img/planets/Mercury_symbol.png"));
//        tabDatos.addTab(empresa, "Empresa", FontAwesome.INSTITUTION);
//
//// This tab gets its caption from the component caption
////        VerticalLayout tab2 = new VerticalLayout();
////        tab2.addComponent(new Embedded(null, new ThemeResource("img/planets/Venus.jpg")));
////        tab2.setCaption("Venus");
////        tabEmpresa.addTab(tab2).setIcon( new ThemeResource("img/planets/Venus_symbol.png"));
//
//    }
    
//    private void buildTabDireccion() {
//
//        DireccionVista direccion = new DireccionVista(new Direccion());
//
//        tabDatos.addTab(direccion, "Dirección", FontAwesome.BOOK);
//
//
//    }
    
    private void buildDatosAlumnoExtras(){
        
        VerticalLayout layoutTabDatosExtras = new VerticalLayout();
        
        exentoPracticasField = new OptionGroup("Exento practicas");
        exentoPracticasField.addItem(Boolean.TRUE);
        exentoPracticasField.setItemCaption(Boolean.TRUE, "Si");
        exentoPracticasField.addItem(Boolean.FALSE);
        exentoPracticasField.setItemCaption(Boolean.FALSE, "No");
        exentoPracticasField.addStyleName("horizontal");
        
        derivadoINEMField = new OptionGroup("Derivado INEM");
        derivadoINEMField.addItem(Boolean.TRUE);
        derivadoINEMField.setItemCaption(Boolean.TRUE, "Si");
        derivadoINEMField.addItem(Boolean.FALSE);
        derivadoINEMField.setItemCaption(Boolean.FALSE, "No");
        derivadoINEMField.addStyleName("horizontal");
        
        reservaField = new OptionGroup("Reserva");
        reservaField.addItem(Boolean.TRUE);
        reservaField.setItemCaption(Boolean.TRUE, "Si");
        reservaField.addItem(Boolean.FALSE);
        reservaField.setItemCaption(Boolean.FALSE, "No");
        reservaField.addStyleName("horizontal");
        
        
        layoutTabDatosExtras.addComponent(exentoPracticasField);
        layoutTabDatosExtras.addComponent(derivadoINEMField);
        layoutTabDatosExtras.addComponent(reservaField);
        
        layoutTabDatosExtras.addComponent(buildEstadoOcupacional());
        
        tabDatos.addTab(layoutTabDatosExtras, "Datos Extras", FontAwesome.ARCHIVE);

    }
    
    private void buildDireccion(){
        
        VerticalLayout layoutTabDireccion = new VerticalLayout();
        
        HorizontalLayout direccionLayout = new HorizontalLayout();
        
        direccionField = new TextField("Dirección");
        direccion2Field = new TextField("Dirección 2");
        ciudadField = new TextField("Ciudad");
        provinciaField = new TextField("Provincia");
        codigoPostalField = new TextField("Código Postal");
        
        layoutTabDireccion.addComponent(direccionField);
        layoutTabDireccion.addComponent(direccion2Field);
        
        direccionLayout.addComponent(ciudadField);
        direccionLayout.addComponent(provinciaField);
        direccionLayout.addComponent(codigoPostalField);        
        layoutTabDireccion.addComponent(direccionLayout);

//        layoutTabDireccion.addComponent(ciudadField);
//        layoutTabDireccion.addComponent(provinciaField);
//        layoutTabDireccion.addComponent(codigoPostalField);
        
        tabDatos.addTab(layoutTabDireccion, "Dirección", FontAwesome.BOOK);

    }
    
    private void buildEmpresaTab(){
        
        VerticalLayout layoutTabEmpresa = new VerticalLayout();
    
        nombreEmpresaField = new TextField("Nombre");
        cifNifEmpresaField = new TextField("C.I.F.");
        telefonoEmpresaField = new TextField("Telefono");
//        direccionEmpresaField = new TextField("Provincia");
        numeroEmpleadosEmpresaField = new TextField("Número empleados");
        codigoPostalEmpresaField = new TextField("C.P.");
        localidadEmpresaField = new TextField("Localidad");

        HorizontalLayout datosLayoutEmpresa1 = new HorizontalLayout();
        datosLayoutEmpresa1.addComponent(cifNifEmpresaField);
        datosLayoutEmpresa1.addComponent(nombreEmpresaField);
        layoutTabEmpresa.addComponent(datosLayoutEmpresa1);
        
        HorizontalLayout datosLayoutEmpresa2 = new HorizontalLayout();
        datosLayoutEmpresa2.addComponent(codigoPostalEmpresaField);
        datosLayoutEmpresa2.addComponent(localidadEmpresaField);
        
        layoutTabEmpresa.addComponent(datosLayoutEmpresa2);
        
        HorizontalLayout datosLayoutEmpresa3 = new HorizontalLayout();
        
        datosLayoutEmpresa3.addComponent(numeroEmpleadosEmpresaField);
        datosLayoutEmpresa3.addComponent(telefonoEmpresaField);
        
        layoutTabEmpresa.addComponent(datosLayoutEmpresa3);
        tabDatos.addTab(layoutTabEmpresa, "Empresa", FontAwesome.INSTITUTION);

    }
    private void buildEstudiosTab(){
        
        VerticalLayout layoutTabEstudios = new VerticalLayout();
    
        layoutTabEstudios.addComponent(buildNivelEstudios());
        
        abandonoEstudiosField = new OptionGroup("Estudios finalizados");
        abandonoEstudiosField.addItem(Boolean.TRUE);
        abandonoEstudiosField.setItemCaption(Boolean.TRUE, "Si");
        abandonoEstudiosField.addItem(Boolean.FALSE);
        abandonoEstudiosField.setItemCaption(Boolean.FALSE, "No");
        abandonoEstudiosField.addStyleName("horizontal");
        
        layoutTabEstudios.addComponent(abandonoEstudiosField);
        
        tabDatos.addTab(layoutTabEstudios, "Estudios", FontAwesome.BOOK);

    }
    
    private void buildAyudasTab(){
        
        VerticalLayout layoutTabAyudas = new VerticalLayout();
        
        manutencionField = new OptionGroup("Manutencion");
        manutencionField.addItem(Boolean.TRUE);
        manutencionField.setItemCaption(Boolean.TRUE, "Si");
        manutencionField.addItem(Boolean.FALSE);
        manutencionField.setItemCaption(Boolean.FALSE, "No");
        manutencionField.addStyleName("horizontal");
        
        transporteField = new OptionGroup("Transporte");
        transporteField.addItem(Boolean.TRUE);
        transporteField.setItemCaption(Boolean.TRUE, "Si");
        transporteField.addItem(Boolean.FALSE);
        transporteField.setItemCaption(Boolean.FALSE, "No");
        transporteField.addStyleName("horizontal");
        
        alojamientoField = new OptionGroup("Alojamiento");
        alojamientoField.addItem(Boolean.TRUE);
        alojamientoField.setItemCaption(Boolean.TRUE, "Si");
        alojamientoField.addItem(Boolean.FALSE);
        alojamientoField.setItemCaption(Boolean.FALSE, "No");
        alojamientoField.addStyleName("horizontal");
        
        
        layoutTabAyudas.addComponent(manutencionField);
        layoutTabAyudas.addComponent(transporteField);
        layoutTabAyudas.addComponent(alojamientoField);
        
        tabDatos.addTab(layoutTabAyudas, "Ayudas", FontAwesome.CODE);

    }
    
    private void bindModel() throws FieldGroup.BindException {
        fieldGroup = new BeanFieldGroup<>(Alumno.class);
//        fieldGroup.bind(idField, "code");
        fieldGroup.bind(nombreField, "nombre");
        fieldGroup.bind(dniField, "dni");
        fieldGroup.bind(numeroSSGGField, "NumeroSSGG");
        fieldGroup.bind(numeroEmpleadosEmpresaField, "fechaNacimiento");
//        fieldGroup.bind(fechaNacimientoField, "fechaNacimiento");
//        fieldGroup.bind(fechaNacimientoField, "fechaNacimiento");
//        fieldGroup.bind(fechaNacimientoField, "fechaNacimiento");
//        fieldGroup.bind(fechaNacimientoField, "fechaNacimiento");
//        fieldGroup.bind(fechaNacimientoField, "fechaNacimiento");
//        fieldGroup.bind(fechaNacimientoField, "fechaNacimiento");
//        fieldGroup.bind(fechaNacimientoField, "fechaNacimiento");
        
        // Direccion
        fieldGroup.bind(direccionField, "direccion.direccion");
        fieldGroup.bind(direccion2Field, "direccion.direccion2");
        fieldGroup.bind(ciudadField, "direccion.ciudad");
        fieldGroup.bind(provinciaField, "direccion.provincia");
        fieldGroup.bind(codigoPostalField, "direccion.codigoPostal");
        
        // Empresa
        fieldGroup.bind(cifNifEmpresaField, "empresa.cifNifEmpresa");
        fieldGroup.bind(nombreEmpresaField, "empresa.nombre");
        fieldGroup.bind(telefonoEmpresaField, "empresa.telefono");
        fieldGroup.bind(numeroEmpleadosEmpresaField, "empresa.numeroEmpleados");
        
//        Alumno a = new Alumno();
//        a.getNumeroSSGG()
        
        
    }
    
    private Component buildEstadoOcupacional() {
//        containerEstadosOcupacional = new BeanItemContainer<>(EstadoOcupacional.class);
//        containerEstadosOcupacional.addAll(estadoOcupacionalService.findAll());
//        estadosOcupacionalField = new OptionGroup("Estado Ocupacional");
//        estadosOcupacionalField.setContainerDataSource(containerEstadosOcupacional);
//        estadosOcupacionalField.addStyleName("horizontal");
//        estadosOcupacionalField.setWidth("30%");
        
        ComboBox combo = new ComboBox("Estado Ocupacional", estadoOcupacionalService.findAll());
        combo.setItemCaptionPropertyId("description");
//        combo.
        
        return combo;
    }
    
    private Component buildNivelEstudios() {
//        containerNivelEstudios = new BeanItemContainer<>(NivelEstudios.class);
//        containerNivelEstudios.addAll(nivelEstudiosService.findAll());
//        nivelEstudiosField = new OptionGroup("Nivel Estudios");
//        nivelEstudiosField.setContainerDataSource(containerNivelEstudios);
//        nivelEstudiosField.addStyleName("horizontal");
//        nivelEstudiosField.setWidth("30%");
        
        ComboBox combo = new ComboBox("Estado Ocupacional", nivelEstudiosService.findAll());
        combo.setItemCaptionPropertyId("description");
//        combo.
        
        return combo;
    }
    
    private void createContainers() {
        containerEstadosOcupacional = new BeanItemContainer<>(EstadoOcupacional.class);
        containerNivelEstudios = new BeanItemContainer<>(NivelEstudios.class);
    }
}
