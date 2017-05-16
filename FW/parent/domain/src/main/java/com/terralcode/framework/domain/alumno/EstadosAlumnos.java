/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.alumno;

import com.terralcode.framework.domain.catalogos.CatalogoBase;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author almoreno
 */
@Entity
public class EstadosAlumnos extends CatalogoBase {

    public static final Integer INICIAL = 1;
    public static final Integer INTERESADO = 2;
    public static final Integer VALIDADO = 3;
    public static final Integer RESERVA = 4;
    public static final Integer BAJA = 5;
    public static final Integer FINALIZADO = 6;
    public static final Integer ABANDONO = 7;
    
    private static final long serialVersionUID = 1L;
    protected Integer estado;
    protected String name = "";

    public EstadosAlumnos() {
        super();
    }

    public EstadosAlumnos(Integer estado, String name) {
        this();
        this.estado = estado;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @NotEmpty
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    /**
     * @return the name
     */
    @NotEmpty
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
