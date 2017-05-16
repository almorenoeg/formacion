/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.framework.domain.commons.contactinfo.address;

import com.terralcode.framework.domain.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jmsuarez
 */
@Entity
public class Country extends DomainEntity{
    private static final long serialVersionUID = 1L;
    protected String code = "";
    protected String name = "";
    protected List<Province> provinceList = new ArrayList<>();
    
    public Country() {
        super();
    }
    public Country(String code, String name) {
        this();
        this.code = code;
        this.name = name;
    }
    
    @NotEmpty
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    public List<Province> getProvinceList() {
//        if (provinceList == null) {
//            provinceList = new ArrayList<>();
//        }
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }
    
}
