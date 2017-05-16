/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.alumno;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;

/**
 *
 * @author almoreno
 */
@Entity
public class DatosExtrasAlumno extends DomainEntity {
    private static final long serialVersionUID = 1L;
    
    private NivelEstudios nivelEstudio;
    private String otraTitulacion;
    private Boolean estudiosFinalizados;

    public DatosExtrasAlumno() {
        super();
    }

    /**
     * @return the nivelEstudio
     */
    public NivelEstudios getNivelEstudio() {
        return nivelEstudio;
    }

    /**
     * @param nivelEstudio the nivelEstudio to set
     */
    public void setNivelEstudio(NivelEstudios nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    /**
     * @return the otraTitulacion
     */
    public String getOtraTitulacion() {
        return otraTitulacion;
    }

    /**
     * @param otraTitulacion the otraTitulacion to set
     */
    public void setOtraTitulacion(String otraTitulacion) {
        this.otraTitulacion = otraTitulacion;
    }

    /**
     * @return the estudiosFinalizados
     */
    public Boolean getEstudiosFinalizados() {
        return estudiosFinalizados;
    }

    /**
     * @param estudiosFinalizados the estudiosFinalizados to set
     */
    public void setEstudiosFinalizados(Boolean estudiosFinalizados) {
        this.estudiosFinalizados = estudiosFinalizados;
    }
    
    
}
