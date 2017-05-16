/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.business.company.relationship.customer;

import com.naoset.framework.business.commons.crud.CRUD;
import com.naoset.framework.domain.company.relationship.customer.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author jmsuarez
 */
@Stateless
public class CustomerService extends CRUD<Customer>{
    
    public List<Customer> findByName(String name) {
        
        String hql = "from " + getEntityClass().getSimpleName() + " c where c.name like :arg1";
        Query query = getEntityManager().createQuery(hql); 
        query.setParameter("arg1", "%" + name + "%"); 
        return (List<Customer>) (query.getResultList());
        
    }
}
