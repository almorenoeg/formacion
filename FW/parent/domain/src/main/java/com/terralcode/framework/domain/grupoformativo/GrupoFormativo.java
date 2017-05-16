/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.grupoformativo;

import com.terralcode.framework.domain.DomainEntity;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author almoreno
 */
@Entity
public class GrupoFormativo extends DomainEntity {
    private static final long serialVersionUID = 1L;
    
    private String numeroGrupo;
    private String accion;
    private Calendar fechaInicio;
    private Calendar fechaFin;
    private Integer numeroAlumnosIniciales;
    private Integer numeroAlumnosReserva;
    private EstadoGrupo estadoGrupo;

    /**
     * @return the numeroGrupo
     */
    public String getNumeroGrupo() {
        return numeroGrupo;
    }

    /**
     * @param numeroGrupo the numeroGrupo to set
     */
    public void setNumeroGrupo(String numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the fechaInicio
     */
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Calendar getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the numeroAlumnosIniciales
     */
    public Integer getNumeroAlumnosIniciales() {
        return numeroAlumnosIniciales;
    }

    /**
     * @param numeroAlumnosIniciales the numeroAlumnosIniciales to set
     */
    public void setNumeroAlumnosIniciales(Integer numeroAlumnosIniciales) {
        this.numeroAlumnosIniciales = numeroAlumnosIniciales;
    }

    /**
     * @return the numeroAlumnosReserva
     */
    public Integer getNumeroAlumnosReserva() {
        return numeroAlumnosReserva;
    }

    /**
     * @param numeroAlumnosReserva the numeroAlumnosReserva to set
     */
    public void setNumeroAlumnosReserva(Integer numeroAlumnosReserva) {
        this.numeroAlumnosReserva = numeroAlumnosReserva;
    }

    /**
     * @return the estadoGrupo
     */
    @OneToOne
    public EstadoGrupo getEstadoGrupo() {
        return estadoGrupo;
    }

    /**
     * @param estadoGrupo the estadoGrupo to set
     */
    public void setEstadoGrupo(EstadoGrupo estadoGrupo) {
        this.estadoGrupo = estadoGrupo;
    }
    
    
    
    

}
