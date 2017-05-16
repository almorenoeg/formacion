/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.inherit_join;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author jmsuarez
 */
@Entity
//@Table(name = "Employee", catalog = "curso")
@Inheritance(strategy=InheritanceType.JOINED)
public class IJEmployee implements java.io.Serializable {

        Long id;

        private String nif;

        private String name;

        private String phone;

        private String email;

        public IJEmployee() {
        }

        public IJEmployee(String name) {
                this.name = name;
        }

        public IJEmployee(String nif, String name, String phone, String email) {
                this.nif = nif;
                this.name = name;
                this.phone = phone;
                this.email = email;
        }

        @Id
        @GeneratedValue
        @Column(name = "id", unique = true, nullable = false)
        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        @Column(name = "nif", length = 10)
        public String getNif() {
                return this.nif;
        }

        public void setNif(String nif) {
                this.nif = nif;
        }

        @Column(name = "name", nullable = false, length = 50)
        public String getName() {
                return this.name;
        }

        public void setName(String name) {
                this.name = name;
        }

        @Column(name = "phone", length = 20)
        public String getPhone() {
                return this.phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        @Column(name = "email", length = 50)
        public String getEmail() {
                return this.email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}
