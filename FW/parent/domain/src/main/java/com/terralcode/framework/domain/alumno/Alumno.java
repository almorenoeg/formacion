/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.alumno;

import com.terralcode.framework.domain.catalogos.Colectivo;
import com.terralcode.framework.domain.catalogos.EstadoOcupacional;
import com.terralcode.framework.domain.catalogos.CategoriaTrabajador;
import com.terralcode.framework.domain.Empresa;
import com.terralcode.framework.domain.Persona;
import com.terralcode.framework.domain.catalogos.Sexo;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author almoreno
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Alumno extends Persona {
    private static final long serialVersionUID = 1L;
    
    private Sexo sexo;
    private String dni;
    private String numeroSSGG;
    private EstadoOcupacional estadoOcupacional;
    private Colectivo colectivo;
    private Boolean derivadoINEM;
    private Boolean exentoPracticas;
    private Boolean reserva;
    private Boolean discapacidad;
    private Boolean pyme;
    private Empresa empresa;
    private CategoriaTrabajador categoria;
    private List<NivelEstudios> estudios;
    private Integer estadoAlumno;

    public Alumno() {
        super();
    }

    
    
    
    
    /**
     * @return the sexo
     */
    @OneToOne
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the numeroSSGG
     */
    public String getNumeroSSGG() {
        return numeroSSGG;
    }

    /**
     * @param numeroSSGG the numeroSSGG to set
     */
    public void setNumeroSSGG(String numeroSSGG) {
        this.numeroSSGG = numeroSSGG;
    }

    /**
     * @return the estadoOcupacional
     */
    @OneToOne
    public EstadoOcupacional getEstadoOcupacional() {
        return estadoOcupacional;
    }

    /**
     * @param estadoOcupacional the estadoOcupacional to set
     */
    public void setEstadoOcupacional(EstadoOcupacional estadoOcupacional) {
        this.estadoOcupacional = estadoOcupacional;
    }

    /**
     * @return the colectivo
     */
    @OneToOne
    public Colectivo getColectivo() {
        return colectivo;
    }

    /**
     * @param colectivo the colectivo to set
     */
    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    /**
     * @return the derivadoINEM
     */
    public Boolean getDerivadoINEM() {
        return derivadoINEM;
    }

    /**
     * @param derivadoINEM the derivadoINEM to set
     */
    public void setDerivadoINEM(Boolean derivadoINEM) {
        this.derivadoINEM = derivadoINEM;
    }

    /**
     * @return the exentoPracticas
     */
    public Boolean getExentoPracticas() {
        return exentoPracticas;
    }

    /**
     * @param exentoPracticas the exentoPracticas to set
     */
    public void setExentoPracticas(Boolean exentoPracticas) {
        this.exentoPracticas = exentoPracticas;
    }

    /**
     * @return the reserva
     */
    public Boolean getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Boolean reserva) {
        this.reserva = reserva;
    }

    /**
     * @return the discapacidad
     */
    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    /**
     * @param discapacidad the discapacidad to set
     */
    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * @return the pyme
     */
    public Boolean getPyme() {
        return pyme;
    }

    /**
     * @param pyme the pyme to set
     */
    public void setPyme(Boolean pyme) {
        this.pyme = pyme;
    }

    /**
     * @return the empresa
     */
    @OneToOne
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the categoria
     */
    @OneToOne
    public CategoriaTrabajador getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(CategoriaTrabajador categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the estudios
     */
    @ManyToMany
    @Basic(fetch = FetchType.EAGER)
    public List<NivelEstudios> getEstudios() {
        return estudios;
    }

    /**
     * @param estudios the estudios to set
     */
    public void setEstudios(List<NivelEstudios> estudios) {
        this.estudios = estudios;
    }

    /**
     * @return the estado
     */
    
    public Integer getEstado() {
        return estadoAlumno;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Integer estado) {
        this.estadoAlumno = estado;
    }

    
}
