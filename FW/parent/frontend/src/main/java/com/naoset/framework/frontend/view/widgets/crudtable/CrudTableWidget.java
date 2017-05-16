package com.naoset.framework.frontend.view.widgets.crudtable;

import com.naoset.framework.business.commons.crud.CRUD;
import com.naoset.framework.frontend.component.entitytable.EntityTable;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
public abstract class CrudTableWidget<T> extends Widget {

    protected abstract CRUD<T> getCrudService();

    protected abstract Class<T> getEntityClass();

    @Inject
    protected EntityTable<T> table;

    FieldGroup fieldGroup;
    private static final int MAX_PAGE_LENGTH = 15;

    @Override
    protected Component buildContent()
    {
        initTable();
        addComponent(table);
        table.setPageLength(table.size());
        setExpandRatio(table, 1);
        table.setSizeFull();
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
                try {
                    openItemWindow(new BeanItem<>(getEntityClass().newInstance()), "Añadir");
                } catch (InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(CrudTableWidget.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }

    private MenuBar.Command edit()
    {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                openItemWindow(new BeanItem<>((T) table.getValue()), "Editar");
            }
        };
    }

    private MenuBar.Command save()
    {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                for (T itemId : table.tableContainer.getItemIds()) {
                    T entity = table.tableContainer.getItem(itemId).getBean();
                    getCrudService().edit(entity);

                }
            }
        };
    }

    protected abstract Map<String, String> getBinds();
    
    private MenuBar.Command delete()
    {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                T item = (T) table.getValue();
                getCrudService().remove(item);
                table.tableContainer.removeItem(item);
            }
        };
    }

    void openItemWindow(Item beanItem, String caption)
    {
        Window window = new Window(caption);
        window.setModal(true);
        FormLayout layout = new FormLayout();
        layout.setMargin(true);
        window.setContent(layout);
        fieldGroup = new BeanFieldGroup<>(getEntityClass());
        fieldGroup.setItemDataSource(beanItem);
        addBindedFields();
//        fieldGroup.getUnboundPropertyIds().parallelStream().forEach(propertyId -> {
//            layout.addComponent(fieldGroup.buildAndBind(propertyId));
//        });
        layout.addComponent(createOkButton(window));
        getUI().addWindow(window);
    }

    Button createOkButton(final Window window)
    {
        Button okButton = new Button("OK");
        okButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                try {
                    fieldGroup.commit();
                    BeanItem<T> beanItem = (BeanItem<T>) fieldGroup.getItemDataSource();
                    table.tableContainer.addItem(beanItem.getBean());
                    updateTable();
                    window.close();
                } catch (FieldGroup.CommitException e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        return okButton;
    }

    void updateTable()
    {
        if (table.size() > MAX_PAGE_LENGTH) {
            table.setPageLength(MAX_PAGE_LENGTH);
        } else {
            table.setPageLength(table.size());
        }
        table.tableContainer.getItemIds().parallelStream().forEach((item) -> {
            getCrudService().edit(item);
        });
        table.markAsDirtyRecursive();
    }

    void initTable()
    {
        table.crudService = getCrudService();
        table.setEntityClass(getEntityClass());
    }

    void addBindedFields()
    {
        getBinds().forEach(
                (property, caption)-> 
                        fieldGroup.buildAndBind(property, caption));
    }

}
