/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.framework.domain.commons.contactinfo;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;

/**
 *
 * @author Ezequiel
 */
@Entity
public class ContactInfo extends DomainEntity {
    private static final long serialVersionUID = 1L;
    protected ContactType contactType;
    protected String contactPerson = "";
    protected String comments = "";
    protected String info = "";

    @Override
    public String toString() {
        return (contactPerson + " [" + info + "]"); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    /**
     * @return the contactType
     */
    public ContactType getContactType()
    {
        return contactType;
    }

    /**
     * @param contactType the contactType to set
     */
    public void setContactType(ContactType contactType)
    {
        this.contactType = contactType;
    }

    /**
     * @return the contactPerson
     */
    public String getContactPerson()
    {
        return contactPerson;
    }

    /**
     * @param contactPerson the contactPerson to set
     */
    public void setContactPerson(String contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    /**
     * @return the comments
     */
    public String getComments()
    {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments)
    {
        this.comments = comments;
    }

    /**
     * @return the info
     */
    public String getInfo()
    {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info)
    {
        this.info = info;
    }

}
