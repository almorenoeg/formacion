/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.framework.domain.commons.contactinfo.address;

import com.terralcode.framework.domain.DomainEntity;
import java.util.Objects;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ezequiel
 */
@Entity
public class PlainAddress extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String addressLine1 = "";
    protected String addressLine2 = "";
    protected String country = "";
    protected String province = "";
    protected String city = "";
    protected String postalCode = "";
    protected Boolean defaultValue;

    @Override
    public String toString()
    {
        String address = Objects.toString(addressLine1, "") + " ";
        address += Objects.toString(addressLine2, "") + " ";
        address += Objects.toString(postalCode, "") + " ";
        address += Objects.toString(city, "") + " ";
        address += Objects.toString(province, "") + " ";
        address += Objects.toString(country, "") + " ";
        return address;
    }

    /**
     * @return the addressLine1
     */
//    @NotEmpty
    public String getAddressLine1()
    {
        return addressLine1;
    }

    /**
     * @param addressLine1 the addressLine1 to set
     */
    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2()
    {
        return addressLine2;
    }

    /**
     * @param addressLine2 the addressLine2 to set
     */
    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * @return the province
     */
    public String getProvince()
    {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province)
    {
        this.province = province;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    /**
     * @return the defaultValue
     */
    public Boolean getDefaultValue()
    {
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(Boolean defaultValue)
    {
        this.defaultValue = defaultValue;
    }

}
