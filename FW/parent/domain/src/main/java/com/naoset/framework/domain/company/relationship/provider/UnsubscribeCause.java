/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.domain.company.relationship.provider;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ezequiel
 */
@Entity
public class UnsubscribeCause extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String cause="";

    @NotEmpty
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

}
