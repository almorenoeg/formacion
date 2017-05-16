/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.base_inherit;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author jmsuarez
 */
@Entity
@PrimaryKeyJoinColumn(name="baseId")
public class InheritedEntity extends BaseEntity {
    
    protected String name2;

//    public InheritedEntity() {
//    }

    
    
    /**
     * Get the value of name2
     *
     * @return the value of name2
     */
    
    public String getName2() {
        return name2;
    }

    /**
     * Set the value of name2
     *
     * @param name2 new value of name2
     */
    public void setName2(String name2) {
        this.name2 = name2;
    }

}
