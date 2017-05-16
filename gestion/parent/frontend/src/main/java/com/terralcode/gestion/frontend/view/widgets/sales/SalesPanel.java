/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.gestion.frontend.view.widgets.sales;

import com.terralcode.gestion.business.sales.SalesService;
import com.terralcode.gestion.domain.sales.Sales;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author almoreno
 */
public final class SalesPanel extends Panel {

    private Table table;    
    private final HorizontalLayout layout;
   
    @Inject
    SalesService salesService;
    
    public SalesPanel() {
        super();
        layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.addComponent(createTable());
        //this.setCaption("Últimas Ventas");
        this.setContent(layout);
    }
    
    private Table createTable() {
        table = new Table();
        table.setSizeFull();
        table.setSortAscending(true);
        

        table.setImmediate(true);
        table.setPageLength(3);
        table.addContainerProperty("Fecha", Label.class, null);
        table.addContainerProperty("Descripcion", Label.class, null);
        //table.addContainerProperty("Cantidad", Label.class, null);
        //table.addContainerProperty("Precio", Label.class, null);
        //table.addContainerProperty("Total", Label.class, null);
        return table;
    }
    
    public Table loadData(List<Sales> sales) {
        
        if (sales != null && !sales.isEmpty()) {
            loadDataTable(sales);
        }
        
        return table;
    }
   
    
    private void loadDataTable(List<Sales> sales) {
        layout.removeComponent(table);
        layout.addComponent(createTable());
        int tableSize;
        if (sales != null) {
            table.setPageLength(sales.size());
            tableSize = sales.size();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
            for (int i = 0; i < tableSize; i++) {
                
                Label salesDateLabel = new Label(sdf.format(sales.get(i).getDateSale().getTime()));
                Label descriptionLabel = new Label(sales.get(i).getDescription());
          //      Label amountLabel = new Label(sales.get(i).getAmount().toString());
          //      Label priceLabel = new Label(sales.get(i).getPrice().toString());
          //      Label totalLabel = new Label(String.valueOf(sales.get(i).getPrice() * sales.get(i).getAmount()));

                Object obj = table.addItem(new Object[]{salesDateLabel, descriptionLabel/*, amountLabel, priceLabel, totalLabel*/},i);
                
                if (obj != null) {
                    
                }
            }
        }
           
    }
}
