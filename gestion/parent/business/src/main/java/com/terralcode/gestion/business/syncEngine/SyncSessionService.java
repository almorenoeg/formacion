/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.business.syncEngine;

import com.terralcode.gestion.domain.syncEngine.ChangeLog;
import com.terralcode.gestion.domain.syncEngine.SyncSession;
import com.naoset.framework.business.commons.crud.CRUD;
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
public class SyncSessionService extends CRUD<SyncSession>{

    @Inject
    ChangeLogService changeLogService;
    
    @Override
    public SyncSession newEntity() {
        SyncSession session = super.newEntity();
        
        session.setStartTime(Calendar.getInstance());
        session.setState(SyncSession.SyncSessionState.Opened);
        session.setCode("CRM" + Calendar.getInstance().getTime().toLocaleString());
        
        List<ChangeLog> orphanChanges = changeLogService.findOrphans();
        for (ChangeLog orphanChange : orphanChanges) {
            session.addChange(orphanChange);
        }
        
        return session;
    }
    
    public SyncSession findOpen(){
        String sentence = "SELECT syncSession FROM SyncSession syncSession " + 
                          "WHERE syncSession.state = :state";
        Query query = getEntityManager().createQuery(sentence);
        //query.setParameter("code", "");
        query.setParameter("state", SyncSession.SyncSessionState.Opened);
                
        List<SyncSession> found = query.getResultList();
        if (found.isEmpty()) {
            return null;
        } else 
            return found.get(0);
    }
    
}
