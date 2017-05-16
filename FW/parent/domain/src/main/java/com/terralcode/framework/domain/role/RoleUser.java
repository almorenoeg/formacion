/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.framework.domain.role;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;

/**
 *
 * @author almoreno
 */
@Entity
public class RoleUser extends DomainEntity {
    private static final long serialVersionUID = 1L;
    
    String nombre;
    Boolean activo;
    TipoRole tipoRole;
    
}
