/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author almoreno
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Direccion extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String direccion = "";
    protected String direccion2 = "";
    protected String ciudad = "";
    protected String provincia = "";
    protected String codigoPostal = "";

    public Direccion() {
        super();
    }


    @Override
    public String toString()
    {
        String address = Objects.toString(direccion, "") + " ";
        address += Objects.toString(direccion2, "") + " ";
        address += Objects.toString(codigoPostal, "") + " ";      
        address += Objects.toString(provincia, "") + " ";
        address += Objects.toString(ciudad, "") + " ";
        return address;
    }

    /**
     * @return the addressLine1
     */
//    @NotEmpty
    public String getDireccion()
    {
        return direccion;
    }

    /**
     * @param direccion the addressLine1 to set
     */
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    /**
     * @return the addressLine2
     */
    public String getDireccion2()
    {
        return direccion2;
    }

    /**
     * @param direccion the addressLine2 to set
     */
    public void setDireccion2(String direccion)
    {
        this.direccion2 = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad()
    {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    /**
     * @return the province
     */
    public String getProvincia()
    {
        return provincia;
    }

    /**
     * @param provincia the province to set
     */
    public void setProvincia(String provincia)
    {
        this.provincia = provincia;
    }

    
    /**
     * @return the postalCode
     */
    public String getCodigoPostal()
    {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the postalCode to set
     */
    public void setCodigoPostal(String codigoPostal)
    {
        this.codigoPostal = codigoPostal;
    }

   

}

