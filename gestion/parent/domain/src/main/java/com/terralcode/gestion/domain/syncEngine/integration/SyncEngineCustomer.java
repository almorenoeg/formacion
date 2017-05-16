/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.syncEngine.integration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmsuarez
 */
@XmlRootElement
public class SyncEngineCustomer {
    protected String idCRM;
    protected String idGuest;
    protected String code;
    protected String statusCode;
    protected String typeCode;
    protected String taxCode;
    protected String name;
    
    protected List<SyncEnginePlainAddress> adresses = new ArrayList<>();
    protected List<String> specieCodes = new ArrayList<>();
    protected List<SyncEngineSale> sales = new ArrayList<>();
    
    @XmlAttribute
    public String getIdCRM() {
        return idCRM;
    }

    public void setIdCRM(String idCRM) {
        this.idCRM = idCRM;
    }

    @XmlAttribute
    public String getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(String idGuest) {
        this.idGuest = idGuest;
    }

    @XmlAttribute
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlAttribute
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @XmlAttribute
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @XmlAttribute
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name="addresses")
    @XmlElement(name="address")
    public List<SyncEnginePlainAddress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<SyncEnginePlainAddress> adresses) {
        this.adresses = adresses;
    }

    @XmlElementWrapper(name="specieCodes")
    @XmlElement(name="specieCode")
    public List<String> getSpecieCodes() {
        return specieCodes;
    }

    public void setSpecieCodes(List<String> specieCodes) {
        this.specieCodes = specieCodes;
    }

    @XmlElementWrapper(name="sales")
    @XmlElement(name="sale")
    public List<SyncEngineSale> getSales() {
        return sales;
    }

    public void setSales(List<SyncEngineSale> sales) {
        this.sales = sales;
    }
    
    
}
