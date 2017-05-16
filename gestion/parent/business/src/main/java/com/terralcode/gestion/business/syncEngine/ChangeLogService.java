/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.business.syncEngine;

import com.terralcode.gestion.domain.syncEngine.ChangeLog;
import com.naoset.framework.business.commons.crud.CRUD;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author jmsuarez
 */
@Stateless
public class ChangeLogService extends CRUD<ChangeLog> {
    
    public List<ChangeLog> findOrphans(){
        String sentence = "SELECT changeLog FROM ChangeLog changeLog " + 
                          "WHERE changeLog.syncSession is null";
        Query query = getEntityManager().createQuery(sentence);
                
        List<ChangeLog> found = query.getResultList();
        return found;
    }
    
    public ChangeLog findChange(String entityName, Long entityIdCRM){
        String sentence = "SELECT changeLog FROM ChangeLog changeLog " + 
                          "WHERE changeLog.entityName = :entityName and " + 
                          "changeLog.entityIdCRM = :entityIdCRM";
        Query query = getEntityManager().createQuery(sentence);
        query.setParameter("entityName", entityName);
        query.setParameter("entityIdCRM", entityIdCRM);
                
        List<ChangeLog> found = query.getResultList();
        if (found.isEmpty()) {
            return null;
        } else
        return found.get(0);
    }

    @Override
    public ChangeLog create(ChangeLog entity) {
        //Search for same Entity and CRMId.
        //There can be only one!!!
        ChangeLog priorChange = findChange(entity.getEntityName(), entity.getEntityIdCRM());
        if (priorChange != null) {
            //Override prior change
            priorChange.setOperation(entity.getOperation());
            priorChange.setExternalId(entity.getExternalId());
            priorChange.setUpdateTime((Calendar)entity.getUpdateTime().clone());
            return edit(priorChange);
        } else {
            return super.create(entity); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public ChangeLog newEntity() {
        ChangeLog changeLog = super.newEntity();
        
        changeLog.setUpdateTime(Calendar.getInstance());
        
        return changeLog;
    }
    
    
}
