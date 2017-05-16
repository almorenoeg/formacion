/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author almoreno
 */
@Entity
public class Empresa extends DomainEntity {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    private String nombre="";
    private String cifNifEmpresa="";
    private String telefono = "";
    private Direccion direccion;
    private Integer numeroEmpleados;

    public Empresa() {
        super();
    }

    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cifNifEmpresa
     */
    public String getCifNifEmpresa() {
        return cifNifEmpresa;
    }

    /**
     * @param cifNifEmpresa the cifNifEmpresa to set
     */
    public void setCifNifEmpresa(String cifNifEmpresa) {
        this.cifNifEmpresa = cifNifEmpresa;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    @OneToOne
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the numeroEmpleados
     */
    public Integer getNumeroEmpleados() {
        return numeroEmpleados;
    }

    /**
     * @param numeroEmpleados the numeroEmpleados to set
     */
    public void setNumeroEmpleados(Integer numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
    
    
}
