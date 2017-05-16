package com.terralcode.gestion.frontend.view.widgets.customers;

import com.naoset.framework.business.commons.crud.CRUD;
import com.naoset.framework.business.company.relationship.customer.CustomerService;
import com.naoset.framework.domain.company.relationship.customer.Customer;
import com.naoset.framework.frontend.view.widgets.crudtable.CrudTableWidget;
import java.util.Map;
import java.util.TreeMap;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
public class CustomersTable extends CrudTableWidget<Customer> {

    @Inject
    CustomerService customerService;

    @Override
    protected String caption()
    {
        return "Listado de cliente";
    }

    @Override
    protected CRUD<Customer> getCrudService()
    {
        return customerService;
    }

    @Override
    protected Class<Customer> getEntityClass()
    {
        return Customer.class;
    }

    @Override
    protected Map<String, String> getBinds()
    {
        Map<String, String> binds = new TreeMap<>();
        binds.put("Nombre", "name");
        return binds;
    }

}
