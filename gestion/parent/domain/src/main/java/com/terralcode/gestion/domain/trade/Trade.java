/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.trade;

import com.terralcode.framework.domain.DomainEntity;
import com.terralcode.framework.domain.profile.User;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Álvaro
 */
@Entity
@XmlRootElement
public class Trade extends DomainEntity {

    private static final long serialVersionUID = 1L;

    protected String name = "";
    private User user;

    public Trade()
    {
        super();
    }

    public Trade(String name, User user)
    {
        this();
        this.name = name;
        this.user = user;
    }

    @Override
    public String toString()
    {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    @NotEmpty
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the user
     */
    @OneToOne
    @XmlTransient
    public User getUser()
    {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user)
    {
        this.user = user;
    }

}
