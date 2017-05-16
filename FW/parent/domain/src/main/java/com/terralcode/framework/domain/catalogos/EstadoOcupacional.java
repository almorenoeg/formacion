/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.catalogos;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author almoreno
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class EstadoOcupacional extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String code="";
    protected String name="";

    public EstadoOcupacional() {
        super();
    }

    
    public EstadoOcupacional(String codigo, String nombre) {
        this();
        this.code= codigo;
        this.name = nombre;
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

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
