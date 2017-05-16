/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.framework.domain.commons.contactinfo.address;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jmsuarez
 */
@Entity
public class ComplexAddress extends DomainEntity{
    private static final long serialVersionUID = 1L;
    
    protected Province province;
    protected String city = "";
    protected TypeWay typeWay;
    protected String name = "";
    protected Integer number;
    protected Integer kilometer;
    protected String block = "";
    protected String stair = "";
    protected String floor = "";
    protected String door = "";
    
    public ComplexAddress() {
    }

    @OneToOne
    @NotNull
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToOne
    @NotNull
    public TypeWay getTypeWay() {
        return typeWay;
    }

    public void setTypeWay(TypeWay typeWay) {
        this.typeWay = typeWay;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public void setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStair() {
        return stair;
    }

    public void setStair(String stair) {
        this.stair = stair;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }
    
    
}