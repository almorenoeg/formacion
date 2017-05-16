package com.terralcode.gestion.business.customer;

import com.terralcode.gestion.business.syncEngine.ChangeLogService;
import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.syncEngine.ChangeLog;
import com.terralcode.gestion.domain.syncEngine.integration.SyncEngineCustomer;
import com.naoset.framework.business.commons.crud.CRUD;
import com.naoset.framework.business.company.relationship.customer.CustomerStatusService;
import com.naoset.framework.business.company.relationship.customer.CustomerTypeService;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 *
 * @author jmsuarez
 */
@Stateless
public class CustomerCRMService extends CRUD<CustomerCRM> {

    @Inject
    ChangeLogService changeLogService;
    
    @Inject
    CustomerStatusService customerStatusService;
    
    @Inject
    CustomerTypeService customerTypeService;
    
    @Override
    public CustomerCRM create(CustomerCRM entity) {
        entity = super.create(entity);
        
        //Log change...
        ChangeLog changeLog = changeLogService.newEntity();
        changeLog.setEntityName("CustomerCRM");
        changeLog.setOperation(ChangeLog.ChangeLogOperation.CRM_CREATION);
        changeLog.setEntityIdCRM(entity.getId());
        changeLog.setEntityIdGuest(entity.getExternalId());
        changeLogService.create(changeLog);
        
        return entity;
    }
    
    public CustomerCRM createWithinSyncSession(CustomerCRM entity) {
        //To be used withing a Synchronization Session. No log change...
        return super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public CustomerCRM edit(CustomerCRM entity) {
        entity = super.edit(entity);
        
        //Log change...
        ChangeLog changeLog = changeLogService.newEntity();
        changeLog.setEntityName("CustomerCRM");
        changeLog.setOperation(ChangeLog.ChangeLogOperation.CRM_MODIFICATION);
        changeLog.setEntityIdCRM(entity.getId());
        changeLog.setEntityIdGuest(entity.getExternalId());
        changeLogService.create(changeLog);
        
        return entity;
    }
    
    public CustomerCRM editWithinSyncSession(CustomerCRM entity) {
        //To be used withing a Synchronization Session. No log change...
        return super.edit(entity);
    }

    @Override
    public void remove(CustomerCRM entity) {
        
        super.remove(entity);

        //Log change...
        ChangeLog changeLog = changeLogService.newEntity();
        changeLog.setEntityName("CustomerCRM");
        changeLog.setOperation(ChangeLog.ChangeLogOperation.CRM_DELETION);
        changeLog.setEntityIdCRM(entity.getId());
        changeLog.setEntityIdGuest(entity.getExternalId());
        changeLogService.create(changeLog);
    }
    
    public void removeWithinSyncSession(CustomerCRM entity) {
        super.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }

    public List<CustomerCRM> findByName(String nameSearch) {
        String jpql = "SELECT c "
                + "FROM CustomerCRM c "
                + "where " 
                + "c.name LIKE :search "
                + "order by c.name";
        
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("search", "%" + nameSearch + "%");
        
        return query.getResultList();
    }

    public CustomerCRM buildFromXml(SyncEngineCustomer external) {
        CustomerCRM customer = null;
        if (external.getIdCRM().isEmpty()) {
            customer = this.newEntity();
        } else
        {
            customer = this.find(Long.parseLong(external.getIdCRM()));
        }
        
        customer.setExternalId(external.getIdGuest());
        customer.setCode(external.getCode());
        customer.setCustomerStatus(customerStatusService.findByCode(external.getStatusCode()));
        customer.setCustomerType(customerTypeService.findByCode(external.getTypeCode()));
        customer.setCompanyTaxCode(external.getTaxCode());
        customer.setName(external.getName());
        
        //Addresses
        
        //Species
        
        return customer;
    }
}
