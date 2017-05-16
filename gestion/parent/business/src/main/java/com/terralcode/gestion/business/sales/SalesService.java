/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.gestion.business.sales;

import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.sales.Sales;
import com.naoset.framework.business.commons.crud.CRUD;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author almoreno
 */
@Stateless
public class SalesService extends CRUD<Sales> {

    public static int SHOW_DATA = 5;
    
    
    public List<Sales> findSalesByCustomer(CustomerCRM customer) {
        
        String sentence = "SELECT sales FROM Sales sales WHERE sales.customer = :customer " +
                "ORDER BY sales.dateSale desc";
        Query query = getEntityManager().createQuery(sentence);
        query.setParameter("customer", customer);
//        query.setFirstResult(1);
//        query.setMaxResults(SHOW_DATA);
        
        List<Sales> sales = query.getResultList();
        
        if (sales.isEmpty()) {
            sales = null;
        } 
        
        return sales;
    }
}
