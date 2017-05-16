/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.base_inherit;

import javax.persistence.Entity;

@Entity
public class BaseEntityImpl extends BaseEntity {

        protected String quepasa;

    /**
     * Get the value of quepasa
     *
     * @return the value of quepasa
     */
    public String getQuepasa() {
        return quepasa;
    }

    /**
     * Set the value of quepasa
     *
     * @param quepasa new value of quepasa
     */
    public void setQuepasa(String quepasa) {
        this.quepasa = quepasa;
    }

    
    public BaseEntityImpl() {
    }

    public BaseEntityImpl(Long id, String name) {
        super(id, name);
    }
    
}
