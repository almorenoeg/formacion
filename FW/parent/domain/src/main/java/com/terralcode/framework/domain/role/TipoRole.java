/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.framework.domain.role;

/**
 *
 * @author TerralCode01
 */
public enum TipoRole {
    ADMIN(1), CAPTADOR(2), VALIDADOR(3), GESTOR_ACCION(4), GESTOR_PLATAFORMA(5);
   
    private int code;
    
    private TipoRole(Integer cod) {
        code = cod;
    }

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Set the value of code
     *
     * @param code new value of code
     */
    public void setCode(int code) {
        this.code = code;
    }
 
    
}
