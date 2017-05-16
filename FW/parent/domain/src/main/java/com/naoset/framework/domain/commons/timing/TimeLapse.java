/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.domain.commons.timing;

import com.terralcode.framework.domain.DomainEntity;
import java.util.Calendar;
import javax.persistence.Entity;

/**
 *
 * @author jmsuarez
 */
@Entity
public class TimeLapse extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String code = "";
    protected String name = "";
    protected int type = Calendar.MINUTE;
    protected int value = 0;

    public TimeLapse() {
        super();
    }

    public TimeLapse(String code, String name, int type, int value) {
        this();
        this.code = code;
        this.name = name;
        this.type = type;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
