/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.syncEngine.integration;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmsuarez
 */
@XmlRootElement
class SyncEngineComplaint {
    protected String idCRM;
    protected String idGuest;
    protected String typeCode;
    protected String name;
    protected String notes;
    protected Boolean done;

    @XmlAttribute
    public String getIdCRM() {
        return idCRM;
    }

    public void setIdCRM(String idCRM) {
        this.idCRM = idCRM;
    }

    @XmlAttribute
    public String getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(String idGuest) {
        this.idGuest = idGuest;
    }

    @XmlAttribute
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
    
    
}
