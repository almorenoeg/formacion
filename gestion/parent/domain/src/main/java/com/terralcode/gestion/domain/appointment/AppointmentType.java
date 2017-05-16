/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.appointment;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author almoreno
 */
@Entity
public class AppointmentType extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String code = "";
    protected String name = "";

    public AppointmentType() {
        super();
    }

    public AppointmentType(String code, String name) {
        this();
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @NotEmpty
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    @NotEmpty
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
