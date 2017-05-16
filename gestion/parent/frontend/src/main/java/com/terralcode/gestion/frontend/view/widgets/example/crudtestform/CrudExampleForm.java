/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.widgets.example.crudtestform;

import com.terralcode.gestion.business.example.ProductService;
import com.terralcode.gestion.domain.example.product.TestProduct;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;
import javax.inject.Inject;

/**
 *
 * @author jmsuarez
 */
public class CrudExampleForm extends Widget {

    @Inject
    ProductService productService;
    private Table table = new Table();
    private BeanItemContainer<TestProduct> tableContainer;
    private FieldGroup fieldGroup;
    private Action actionDelete = new Action("Delete");
    private int code = 1;
    private static final int MAX_PAGE_LENGTH = 15;

    //IMPORTANTE: La inicialización se hace en este metodo, no en el constructor.
    protected Component buildContent()
    {
        initTable();
        table.setPageLength(table.size());
        addMenuItems(
                new MenuBar().new MenuItem("", FontAwesome.PLUS, add()),
                new MenuBar().new MenuItem("", FontAwesome.EDIT, edit()),
                new MenuBar().new MenuItem("", FontAwesome.SAVE, save()),
                new MenuBar().new MenuItem("", FontAwesome.TRASH_O, delete())
        );
        return table;
    }

    private MenuBar.Command add()
    {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                openProductWindow(new BeanItem<TestProduct>(new TestProduct(code++)), "Add product");
            }
        };
    }

    private MenuBar.Command edit()
    {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                openProductWindow(new BeanItem<TestProduct>((TestProduct) table.getValue()), "Edit product");
            }
        };
    }

    private MenuBar.Command save()
    {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                for (TestProduct itemId : tableContainer.getItemIds()) {
                    TestProduct product = tableContainer.getItem(itemId).getBean();
                    if (product.getId() == null) {
                        productService.create(product);
                    } else {
                        productService.edit(product);

                    }
                }
            }
        };
    }

    private MenuBar.Command delete()
    {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                TestProduct item = (TestProduct) table.getValue();
                productService.remove(item);
                tableContainer.removeItem(item);
            }
        };
    }

    @Override
    protected String caption()
    {
        return "Test de CRUD Form";
    }

    private void initTable()
    {
        tableContainer = new BeanItemContainer<>(TestProduct.class);
        fillTableContainer(tableContainer);
        table.setContainerDataSource(tableContainer);
        table.setSelectable(true);

        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event)
            {
                if (event.isDoubleClick()) {
                    openProductWindow(event.getItem(), "Edit product");
                }
            }
        });

        table.addActionHandler(new Action.Handler() {
            @Override
            public void handleAction(Action action, Object sender, Object target)
            {
                if (actionDelete == action) {
                    tableContainer.removeItem(target);
                    updateTable();
                }
            }

            @Override
            public Action[] getActions(Object target, Object sender)
            {
                return new Action[]{actionDelete};
            }
        });
    }

    private void openProductWindow(Item beanItem, String caption)
    {
        Window window = new Window(caption);
        window.setModal(true);
        FormLayout layout = new FormLayout();
        layout.setMargin(true);
        window.setContent(layout);
        fieldGroup = new BeanFieldGroup<TestProduct>(TestProduct.class);
        fieldGroup.setItemDataSource(beanItem);
        for (Object propertyId : fieldGroup.getUnboundPropertyIds()) {
            layout.addComponent(fieldGroup.buildAndBind(propertyId));
        }
        layout.addComponent(createOkButton(window));
        getUI().addWindow(window);
    }

    private Button createOkButton(final Window window)
    {
        Button okButton = new Button("OK");
        okButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                try {
                    fieldGroup.commit();
                    BeanItem<TestProduct> beanItem = (BeanItem<TestProduct>) fieldGroup.getItemDataSource();
                    tableContainer.addItem(beanItem.getBean());
                    updateTable();
                    window.close();
                } catch (FieldGroup.CommitException e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        return okButton;
    }

    private void updateTable()
    {
        if (table.size() > MAX_PAGE_LENGTH) {
            table.setPageLength(MAX_PAGE_LENGTH);
        } else {
            table.setPageLength(table.size());
        }
        table.markAsDirtyRecursive();
    }

    private void fillTableContainer(BeanItemContainer<TestProduct> tableContainer)
    {
        for (TestProduct testProduct : productService.findAll()) {
            tableContainer.addItem(testProduct);
        }
    }



}
