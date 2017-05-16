/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.frontend.vista.widgets.listados;

import com.terralcode.framework.domain.alumno.Alumno;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Creacion de la tabla que contendrá la información de los alumnos
 * @author almoreno
 */
public class TablaAlumnos extends Panel {
    private Table table;    
    private final HorizontalLayout layout;
    
    public TablaAlumnos() {
        super();
        layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.addComponent(crearTabla());
        
        this.setContent(layout);
    }
    
    private Table crearTabla() {
        table = new Table();
        table.setSizeFull();
        table.setSortAscending(true);
        

        table.setImmediate(true);
        table.setPageLength(3);
        table.addContainerProperty("Nombre", Label.class, null);
        table.addContainerProperty("Apellido1", Label.class, null);
        table.addContainerProperty("Apellido2", Label.class, null);
        table.addContainerProperty("Fecha Nacimiento", Label.class, null);
        
        return table;
    }
    
    public Table loadData(List<Alumno> alumnos) {
        
        if (alumnos != null && !alumnos.isEmpty()) {
            loadDataTable(alumnos);
        }
        
        return table;
    }
    
    private void loadDataTable(List<Alumno> alumnos) {
        layout.removeComponent(table);
        layout.addComponent(crearTabla());
//        int tableSize;
        if (alumnos != null) {
            table.setPageLength(alumnos.size());
//            tableSize = alumnos.size();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
//            for (int i = 0; i < tableSize; i++) {
            for (Alumno alumno: alumnos)  {  
                Label nombreAlumnoLabel = new Label(alumno.getNombre());
                Label apellidosLabel1 = new Label(alumno.getApellido1() + " " + alumno.getApellido2());                
                Label fechaNacimientoLabel = new Label(sdf.format(alumno.getFechaNacimiento()));


                Object obj = table.addItem(new Object[]{nombreAlumnoLabel, apellidosLabel1, fechaNacimientoLabel}, 
                        alumno.getId());
                
                if (obj != null) {
                    
                }
            }
        }
           
    }
    
    
}
