/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.superclass_inherit_join;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author jmsuarez
 */
@Entity
@Table(name="SIJ_CLASS2")
//@AttributeOverride(name="name", column=@Column(name="PROJECT_NAME"))
public class SIJClass2 extends SIJBase {
    private String cadena2;

    public String getCadena2() {
        return cadena2;
    }

    public void setCadena2(String cadena2) {
        this.cadena2 = cadena2;
    }
}
