/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.catalogos;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author almoreno
 */
@Entity
public class Colectivo extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String code="";
    protected String name="";

    public Colectivo() {
        super();
    }
    
    
    public Colectivo(String codigo, String nombre) {
        this();
        code = codigo;
        name = nombre;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
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
