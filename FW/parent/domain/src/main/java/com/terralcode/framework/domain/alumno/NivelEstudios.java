/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.alumno;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;

/**
 *
 * @author almoreno
 */
@Entity
public class NivelEstudios extends DomainEntity {

    private static final long serialVersionUID = 1L;
    private String code="";
    private String name="";

    public NivelEstudios() {
        super();
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
