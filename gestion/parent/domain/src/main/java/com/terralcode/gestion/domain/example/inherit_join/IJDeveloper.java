/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.inherit_join;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author jmsuarez
 */
@Entity
@PrimaryKeyJoinColumn(name="employeeId")
public class IJDeveloper extends IJTechnician {

        private String expertLanguajes = null;
        
        public String getExpertLanguajes() {
                return expertLanguajes;
        }

        public void setExpertLanguajes(String expertLanguajes) {
                this.expertLanguajes = expertLanguajes;
        }
}
