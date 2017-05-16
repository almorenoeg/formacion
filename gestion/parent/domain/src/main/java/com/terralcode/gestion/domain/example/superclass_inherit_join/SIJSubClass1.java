/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.superclass_inherit_join;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author jmsuarez
 */
@Entity
@PrimaryKeyJoinColumn(name="baseId")
public class SIJSubClass1 extends SIJClass1{
    private String cadena11;

    public String getCadena11() {
        return cadena11;
    }

    public void setCadena11(String cadena11) {
        this.cadena11 = cadena11;
    }
    
    
}
