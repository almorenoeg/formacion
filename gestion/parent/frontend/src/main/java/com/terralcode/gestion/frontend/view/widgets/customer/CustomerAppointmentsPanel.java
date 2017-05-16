/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.customer;

import com.terralcode.gestion.business.appointment.AppointmentService;
import com.terralcode.gestion.domain.appointment.Appointment;
import com.terralcode.gestion.domain.trade.Trade;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jmsuarez
 */
public class CustomerAppointmentsPanel extends Panel {
    
    private Table table;    
    private final HorizontalLayout layout;
   
    @Inject
    AppointmentService appointmentsService;

    public CustomerAppointmentsPanel() {
        super();
        layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.addComponent(createTable());
        
        this.setContent(layout);
    }

    private Component createTable() {
        table = new Table();
        table.setSizeFull();
        table.setSortAscending(true);
        

        table.setImmediate(true);
        table.setPageLength(3);
        table.addContainerProperty("Fecha", Label.class, null);
        table.addContainerProperty("Comerciales", Label.class, null);
        table.addContainerProperty("Resultado", Label.class, null);

        return table;
    }
    
    public Table loadData(List<Appointment> appointments) {
        
        if (appointments != null && !appointments.isEmpty()) {
            loadDataTable(appointments);
        }
        
        return table;
    }
    
    private void loadDataTable(List<Appointment> appointments) {
        layout.removeComponent(table);
        layout.addComponent(createTable());
        int tableSize;
        if (appointments != null) {
            table.setPageLength(appointments.size());
            tableSize = appointments.size();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
            
            //Sort appointments ProgramDateStart descending.  I miss LINQ....
            Collections.sort(appointments, new Comparator<Appointment>() {
                public int compare(Appointment a1, Appointment a2) {
                    return a2.getProgramDateStart().compareTo(a1.getProgramDateStart());
                }
            });
            for (int i = 0; i < tableSize; i++) {
                
                //Compose trades text
                String tradesText = "";
                for(Trade t: appointments.get(i).getTrades()){
                    if (!"".equals(tradesText)) {
                        tradesText += ", ";
                    }
                    tradesText += t.getName();
                }
                
                Label appointmentDateLabel = new Label(sdf.format(appointments.get(i).getProgramDateStart().getTime()));
                Label appointmentTradesLabel = new Label(tradesText);
                Label appointmentNotesLabel = new Label(appointments.get(i).getNotes());

                Object obj = table.addItem(new Object[]{appointmentDateLabel, appointmentTradesLabel, appointmentNotesLabel},i);
            }
        }
           
    }
}
