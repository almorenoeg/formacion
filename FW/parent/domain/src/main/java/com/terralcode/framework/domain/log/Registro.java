

package com.terralcode.framework.domain.log;

import com.terralcode.framework.domain.DomainEntity;
import com.terralcode.framework.domain.profesor.Profesor;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 * Clase para el control de quien hace la operacion y cuando.
 * @author almoreno
 */
@Entity
public class Registro extends DomainEntity {

    private static long serialVersionUID = 1L;

    private Calendar fechaRegistro;
    private Profesor profesor;

    /**
     * @return the fechaRegistro
     */
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Calendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the profesor
     */
    @NotNull
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    
}
