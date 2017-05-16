/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.product;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jmsuarez
 */
@Entity
public class AwesomeTestProduct extends TestProduct{
    
    private static final long serialVersionUID = 1L;
    protected String slogan;

    public AwesomeTestProduct() {
    }

    public AwesomeTestProduct(String slogan, Integer code) {
        super(code);
        this.slogan = slogan;
    }

    public AwesomeTestProduct(String slogan, Integer code, String name, Double price) {
        super(code, name, price);
        this.slogan = slogan;
    }
    
    @NotNull
    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
    
    
}
