package com.naoset.framework.frontend.component.entitytable;

import com.naoset.framework.business.commons.crud.CRUD;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

/**
 *
 * @author Ezequiel
 */
public class EntityTable<T> extends Table {

    Class<T> entityClass;
    public BeanItemContainer<T> tableContainer;
    public CRUD<T> crudService;
    public T selectedItem = null;

    private static final int MAX_PAGE_LENGTH = 15;

    public void setEntityClass(Class<T> entityClass)
    {
        this.entityClass = entityClass;
        tableContainer = new BeanItemContainer<>(entityClass);
        fillTableContainer(tableContainer);
        setContainerDataSource(tableContainer);
        setSelectable(true);       
    }

    private void fillTableContainer(BeanItemContainer<T> tableContainer)
    {
        for (T entity : crudService.findAll()) {
            tableContainer.addItem(entity);
        }
    }

}
