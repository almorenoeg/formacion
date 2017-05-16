/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.gestion.domain.sales;

import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.framework.domain.DomainEntity;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author almoreno
 */
@Entity
public class Sales extends DomainEntity {

    private static long serialVersionUID = 1L;

    
    private CustomerCRM customer;
    
    private Calendar dateSale;
    private String description;
    private Double amount;
    private Double price;

    /**
     * @return the customer
     */
    @NotNull
    @ManyToOne
    public CustomerCRM getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerCRM customer) {
        this.customer = customer;
    }

    /**
     * @return the dateSale
     */
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getDateSale() {
        return dateSale;
    }

    /**
     * @param dateSale the dateSale to set
     */
    public void setDateSale(Calendar dateSale) {
        this.dateSale = dateSale;
    }

    /**
     * @return the description
     */
    @Column(length = 20480)
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    
    
    
}
