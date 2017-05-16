/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.grupoformativo;

import com.terralcode.framework.domain.catalogos.CatalogoBase;
import javax.persistence.Entity;

/**
 *
 * @author almoreno
 */
@Entity
public class EstadoGrupo extends CatalogoBase {
    private static final long serialVersionUID = 1L;

    public EstadoGrupo() {
    }

    public EstadoGrupo(String codigo, String nombre) {
        super(codigo, nombre);
    }
    
    

}
