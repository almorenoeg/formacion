/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.superclass_inherit_join;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author jmsuarez
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="SIJ_CLASS1")
//@AttributeOverride(name="name", column=@Column(name="PROJECT_NAME"))
public class SIJClass1 extends SIJBase {
    private String cadena1;

    public String getCadena1() {
        return cadena1;
    }

    public void setCadena1(String cadena1) {
        this.cadena1 = cadena1;
    }
}
