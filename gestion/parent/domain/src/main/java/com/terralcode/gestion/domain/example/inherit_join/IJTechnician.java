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
public class IJTechnician extends IJEmployee {

        private int experienceYears = 0;

        
        public int getExperienceYears() {
                return experienceYears;
        }

        public void setExperienceYears(int experienceYears) {
                this.experienceYears = experienceYears;
        }
}