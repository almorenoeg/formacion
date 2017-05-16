/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.framework.domain;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jmsuarez
 */
@MappedSuperclass
public abstract class DomainEntity implements Serializable{
    protected Long id;
    protected String externalId;
    
    public DomainEntity() {
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof DomainEntity)) {
            return false;
        }
        DomainEntity other = (DomainEntity) obj;
        if (this.getClass() != other.getClass()) {
            return false;
        }
        if (this.id == null && other.id == null) {
            return super.equals(obj);
        }
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String className;
        className = this.getClass().getName();
        className = className + "[ id=" + id + " ]";
        return className; 
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlTransient
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    @Transient
    @XmlAttribute(name = "id")
    @XmlID
    public String getXmlId() {
        return getId() == null? "" : getId().toString();
    }
    
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
    
}
