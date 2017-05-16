/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author almoreno
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona extends DomainEntity {
    private static final long serialVersionUID = 1L;
    protected String nombre = "";
    protected String apellido1 = "";
    protected String apellido2 = "";
    protected String email = "";
    protected String telefono = "";
    protected String movil = "";    
    private Calendar fechaNacimiento;
    private Direccion direccion;
    

    @NotEmpty
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    @NotEmpty
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String surname) {
        this.apellido1 = surname;
    }
    
    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @NotEmpty
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @NotEmpty
    public String getMovil() {
        return movil;
    }

    public void setMovil(String mobile) {
        this.movil = mobile;
    }

    /**
     * @return the fechaNacimiento
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
