package com.terralcode.gestion.frontend.view.widgets.customers;

import com.google.common.eventbus.Subscribe;
import com.terralcode.gestion.business.customer.CustomerCRMService;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.frontend.view.widgets.customer.CustomerView;
import com.naoset.framework.frontend.event.DashboardEvent;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.cdi.CDIUI;
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
@CDIUI
public class Customers extends Widget {

    private VerticalLayout mainLayout;
    private BeanItemContainer<CustomerCRM> containerCustomers;
    private TextField searchText;
    //private Button searchButton;
    private Table table;

    @Inject
    CustomerCRMService customerCRMService;

    @Inject
    CustomerView customerView;

    @Override
    protected Component buildContent() {
        eventBus.register(this);

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.addComponent(addSearch());
        mainLayout.addComponent(buildTable());
        mainLayout.setExpandRatio(table, 1);
        
        findCustomers("");
        
        return mainLayout;
    }

    @Override
    protected String caption() {
        return "Clientes";
    }

    private Component addSearch() {
        searchText = new TextField();
        //searchText.setIcon(FontAwesome.EYE);
        searchText.setInputPrompt("Introduzca una cadena de búsqueda");
        searchText.addTextChangeListener(new FieldEvents.TextChangeListener() {

            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                String search = event.getText();
                findCustomers(search);
            }
        });
        searchText.setWidth("100%");
        return searchText;
    }

    private Component buildTable() {
        containerCustomers = new BeanItemContainer<>(CustomerCRM.class);

        table = new Table();
        table.setContainerDataSource(containerCustomers);
        table.addGeneratedColumn("details", new Table.ColumnGenerator() {

            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
                Button detailsButton = new Button(FontAwesome.EYE);
                detailsButton.addStyleName(ValoTheme.BUTTON_SMALL);
                //detailsButton.setCaption(((CustomerCRM) itemId).getCode());
                detailsButton.addClickListener(new Button.ClickListener() {

                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        customerView.open((CustomerCRM) itemId);
                    }
                });
                return detailsButton;
            }
        });
        table.setColumnHeader("details", "");
        table.setColumnWidth("details", 60);
        table.setColumnHeader("name", "Nombre");
        table.setColumnExpandRatio("name", 1);
        table.setColumnHeader("mainContactInfo", "Teléfono");
        //table.setColumnHeader("companyTaxCode", "CIF");
        table.setVisibleColumns(new Object[]{"details", "name", "mainContactInfo"});
        //table.setVisibleColumns(new Object[]{"details", "name", "mainContactInfo", "companyTaxCode"});
        table.setSizeFull();

        //addButtonAtTable(allCustomer);
        return table;
    }

//    private void addButtonAtTable(List<Customer> customers) {
//        if (customers != null && customers.size() > 0) {
//            table.setSelectable(true);
//            table.setImmediate(true);
//            //table.setPageLength(10);
//            table.addContainerProperty("Nombre", Label.class, null);
//            table.addContainerProperty("CIF", Label.class, null);
//            table.addContainerProperty("Codigo", Label.class, null);
//            table.addContainerProperty("Detalle", Button.class, null);
//
//            customers.sort(new Comparator() {
//                @Override
//                public int compare(Object o1, Object o2) {
//                    return (((CustomerCRM)o1).toString().toUpperCase()).compareTo(((CustomerCRM)o2).toString().toUpperCase());
//                }
//            });
//            int tableSize = customers.size();
//
//            for (int i = 0; i < tableSize; i++) {
//                Label taxCodeLabel = new Label(customers.get(i).getCompanyTaxCode());
//                Label codeLabel = new Label(customers.get(i).getCode());
//                Label nameLabel = new Label(customers.get(i).getName());
//
//                Button detailsField = new Button(FontAwesome.EYE);
//                Integer itemId = i;
//                detailsField.setData(itemId);
//
//                detailsField.addClickListener(new Button.ClickListener() {
//                    @Override
//                    public void buttonClick(Button.ClickEvent event) {
//                        Integer selectedId = (Integer) event.getButton().getData();
//                        customerView.open((CustomerCRM) customers.get(selectedId));
//                    }
//                });
//
//                table.addItem(new Object[]{nameLabel, taxCodeLabel, codeLabel, detailsField}, itemId);
//
//            }
//        }
//    }
    private void findCustomers(String searchString) {
        containerCustomers.removeAllItems();
        if (searchString.isEmpty()) {
            containerCustomers.addAll(customerCRMService.findAll());
        } else {
            containerCustomers.addAll(customerCRMService.findByName(searchString));
        }
        containerCustomers.sort(new Object[]{"name"}, new boolean[]{true});
    }

//    private void reloadDataTable() {
//        if (!table.removeAllItems()) {
//            Notification.show("No se ha podido recargar los clientes", Notification.Type.ERROR_MESSAGE);
//        } else {
//            searchText.setValue("");
//            buildTable();
//        }
//    }
    @Subscribe
    public void customerSelectedEvent(final DashboardEvent.CustomerEvent event) {

        if (event.reloadCustomersTable()) {
            String search = searchText.getValue();
            findCustomers(search);
        }

    }

}
