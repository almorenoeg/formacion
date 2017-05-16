/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.panel.employee;

import com.naoset.framework.domain.company.employee.Employee;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author TerralCode01
 */
public class EmployeeView extends HorizontalLayout implements Serializable{
    public static final String COLUMNA_NOMBRE = "Nombre";
    public static final String COLUMNA_TELEFONO = "Telefono";
    
    private BeanItemContainer<Employee> tableContainer;
    private static final long serialVersionUID = 1L;
    
    
    public void init() throws Exception {
        builtBody();
    }
    
    private void builtBody() throws Exception {
        
        Panel panel = new Panel();
        
        panel.setContent(builtEmployeeTable());
        addComponent(panel);
    }
    
    private Table builtEmployeeTable() throws Exception{
        
        Table table = new Table();
        
        try {
            // Define two columns for the built-in container
            table.addContainerProperty(COLUMNA_NOMBRE, String.class, null);
            table.addContainerProperty(COLUMNA_TELEFONO,  String.class, null);
            
            Object newItemId = table.addItem();
            Item row = table.getItem(newItemId);
            row.getItemProperty(COLUMNA_NOMBRE).setValue("Antonio Prueba");
            row.getItemProperty(COLUMNA_TELEFONO).setValue("123456789");
            
            newItemId = table.addItem();
            row = table.getItem(newItemId);
            row.getItemProperty(COLUMNA_NOMBRE).setValue("Juan Prueba");
            row.getItemProperty(COLUMNA_TELEFONO).setValue("987654321");
        
            
            table.setPageLength(table.size());
            
        } catch (UnsupportedOperationException uoe) {
            table = null;
            throw new Exception();
        }
        
        return table;
    }
}
