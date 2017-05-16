/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.syncEngine.integration;

/**
 *
 * @author jmsuarez
 */
public class SyncEngineResult {
    protected String entityName;
    protected String entityIdCRM;
    protected String entityIdGuest;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityIdCRM() {
        return entityIdCRM;
    }

    public void setEntityIdCRM(String entityIdCRM) {
        this.entityIdCRM = entityIdCRM;
    }

    public String getEntityIdGuest() {
        return entityIdGuest;
    }

    public void setEntityIdGuest(String entityIdGuest) {
        this.entityIdGuest = entityIdGuest;
    }
    
    
}
