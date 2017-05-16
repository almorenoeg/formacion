package com.terralcode.gestion.frontend.view.widgets.example.crudtestform;

import com.naoset.framework.business.commons.contactinfo.address.PlainAddressService;
import com.naoset.framework.business.commons.crud.CRUD;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import com.naoset.framework.frontend.view.widgets.crudtable.CrudTableWidget;
import java.util.Map;
import java.util.TreeMap;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
public class TestCrudTable extends CrudTableWidget<PlainAddress> {

    @Inject
    PlainAddressService service;

    @Override
    protected String caption()
    {
        return "TestCrudTable";
    }

    @Override
    protected CRUD<PlainAddress> getCrudService()
    {
        return service;
    }

    @Override
    protected Class<PlainAddress> getEntityClass()
    {
        return PlainAddress.class;
    }
    
    @Override
    protected Map<String, String> getBinds()
    {
        Map<String, String> binds = new TreeMap<>();
        binds.put("Name", "name");
        return binds;
    }
}
