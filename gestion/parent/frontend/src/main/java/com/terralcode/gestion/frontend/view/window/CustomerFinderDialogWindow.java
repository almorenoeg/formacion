/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.window;

import com.terralcode.gestion.business.customer.CustomerCRMService;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.naoset.framework.frontend.view.window.DialogWindow;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author jmsuarez
 */
public class CustomerFinderDialogWindow extends DialogWindow {

    protected CustomerCRMService dataService;
    protected BeanItemContainer<CustomerCRM> containerCustomers;
    protected CustomerCRM selectedCustomer;

    protected TextField searchText;
    protected Table resultsTable;

    public CustomerCRM getSelectedCustomer() {
        return selectedCustomer;
    }

    public CustomerFinderDialogWindow(CustomerCRM defaultCustomer, CustomerCRMService dataService) {
        super("Buscador de clientes");

        this.dataService = dataService;
        this.selectedCustomer = defaultCustomer;
        this.containerCustomers = new BeanItemContainer<>(CustomerCRM.class);

        buildLayout();

        if (selectedCustomer != null) {
            //searchText.setValue(selectedCustomer.getName());
            findCustomer(selectedCustomer.getName());
        }
        okButton.setEnabled(selectedCustomer != null);
    }

    private void buildLayout() {
        VerticalLayout vlayout = new VerticalLayout();
        vlayout.setSizeFull();

        searchText = new TextField();
        searchText.setInputPrompt("Introduzca una cadena de búsqueda");
        searchText.addTextChangeListener(new FieldEvents.TextChangeListener() {

            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                String search = event.getText();
                if (search.length() > 3) {
                    findCustomer(search);
                }
            }
        });
        searchText.setWidth("100%");
        vlayout.addComponent(searchText);

        resultsTable = new Table();
        resultsTable.setContainerDataSource(containerCustomers);
        resultsTable.setVisibleColumns(new Object[]{"code", "name", "customerStatus", "customerType"});
        resultsTable.setSelectable(true);
        resultsTable.setNullSelectionAllowed(false);
        resultsTable.addItemClickListener(new ItemClickEvent.ItemClickListener() {

            @Override
            public void itemClick(ItemClickEvent event) {
                selectedCustomer = (CustomerCRM) event.getItemId();
                okButton.setEnabled(selectedCustomer != null);
            }
        });
        resultsTable.setSizeFull();
        vlayout.addComponent(resultsTable);
        vlayout.setExpandRatio(resultsTable, 1);

        setBody(vlayout);
        setFooterButtons(DialogButton.OK, DialogButton.CANCEL);
    }

    private void findCustomer(String name) {
        containerCustomers.removeAllItems();
        selectedCustomer = null;
        containerCustomers.addAll(dataService.findByName(name));

        okButton.setEnabled(selectedCustomer != null);
    }

}
