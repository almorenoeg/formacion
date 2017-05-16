/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.frontend.vista.widgets.listados;

import com.naoset.framework.frontend.view.widgets.Widget;
import com.terralcode.framework.domain.alumno.Alumno;
import com.terralcode.frontend.vista.widgets.alumno.AlumnoVista;
import com.terralcode.gestion.business.alumnos.AlumnosService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.inject.Inject;

/**
 *
 * @author almoreno
 */
public class ListadoAlumnosView extends Widget {

    private VerticalLayout mainLayout;
    private BeanItemContainer<Alumno> containerAlumnos;
    private TextField searchText;
    
    private Table table;
    
    @Inject
    AlumnoVista alumnoVista;
    
    @Inject
    AlumnosService alumnosService;
    
    
    @Override
    protected Component buildContent() {
        eventBus.register(this);

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.addComponent(addSearch());
        mainLayout.addComponent(buildTable());
        mainLayout.setExpandRatio(table, 1);
        
//        Component layout = buildLayout();
        
        return mainLayout;
    }

    @Override
    protected String caption() {
        return "Listado";
    }
    
    
    private Component addSearch() {
        searchText = new TextField();
        //searchText.setIcon(FontAwesome.EYE);
        searchText.setInputPrompt("Introduzca una cadena de búsqueda");
        searchText.addTextChangeListener(new FieldEvents.TextChangeListener() {

            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                String search = event.getText();
                buscarAlumnos(search);
            }
        });
        searchText.setWidth("100%");
        return searchText;
    }
    
     private void buscarAlumnos(String searchString) {
        containerAlumnos.removeAllItems();
        if (searchString.isEmpty()) {
            containerAlumnos.addAll(alumnosService.findAll());
        } else {
            containerAlumnos.addAll(alumnosService.findByName(searchString));
        }
        containerAlumnos.sort(new Object[]{"name"}, new boolean[]{true});
    }
     
     
     
     private Component buildTable() {
        containerAlumnos = new BeanItemContainer<>(Alumno.class);

        table = new Table();
        table.setContainerDataSource(containerAlumnos);
        table.addGeneratedColumn("details", new Table.ColumnGenerator() {

            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
                Button detailsButton = new Button(FontAwesome.EYE);
                detailsButton.addStyleName(ValoTheme.BUTTON_SMALL);
                //detailsButton.setCaption(((CustomerCRM) itemId).getCode());
                detailsButton.addClickListener(new Button.ClickListener() {

                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        alumnoVista.open((Alumno) itemId);
                    }
                });
                return detailsButton;
            }
        });
        table.setColumnHeader("nombre", "");
        table.setColumnWidth("nombre", 60);
        table.setColumnHeader("apellido1", "apellido");
        table.setColumnExpandRatio("nombre", 1);
        table.setColumnHeader("apellido2", "Apellido");
        //table.setColumnHeader("companyTaxCode", "CIF");
        table.setVisibleColumns(new Object[]{"nombre", "apellido1", "apellido2"});
        //table.setVisibleColumns(new Object[]{"details", "name", "mainContactInfo", "companyTaxCode"});
        table.setSizeFull();

        //addButtonAtTable(allCustomer);
        return table;
    }
    
//    private FormLayout buildLayout() {
//        mainLayout = new FormLayout();
//        mainLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
//        mainLayout.setMargin(new MarginInfo(true, false, false, false));
//
//        contruirListadoAlumnos();
//
//        return mainLayout;
//    }
//
//    private void contruirListadoAlumnos() {
//        tablaAlunos = new TablaAlumnos();
//        tablaAlunos.setWidth("100%");
//
//        VerticalLayout wrapper = new VerticalLayout();
//        wrapper.setCaption("Listado de Alumnos");
//        wrapper.addComponent(tablaAlunos);
//        wrapper.setWidth("100%");
//        mainLayout.addComponent(wrapper);
//    }
//
//    private void bindModel() throws FieldGroup.BindException {
//        tablaAlunos.loadData(alumnosService.findAll());
//    }
}
