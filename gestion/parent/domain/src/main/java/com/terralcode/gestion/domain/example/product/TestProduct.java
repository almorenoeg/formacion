/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.example.product;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class TestProduct extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected Integer code;
    protected String name;
    protected Double price;

    public TestProduct() {
        super();
    }

    public TestProduct(Integer code) {
        this.code = code;
    }

    public TestProduct(Integer code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @NotNull
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer value) {
        code = value;
    }

    @Size(min = 3, max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
