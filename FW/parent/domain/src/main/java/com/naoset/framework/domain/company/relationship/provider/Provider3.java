/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.domain.company.relationship.provider;

import com.naoset.framework.domain.company.Company;
import com.naoset.framework.domain.finantial.paymentmethod.PaymentMethod;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Ezequiel
 */
@Entity
public class Provider3 extends Company {

    private static final long serialVersionUID = 1L;
    protected PaymentMethod paymentMethod;
    protected Boolean frecuent;
    protected ProviderType providerType;
    protected LocalDateTime startingDate;
    protected LocalDateTime endingDate;
    protected String endingCause="";

    @OneToOne
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getFrecuent() {
        return frecuent;
    }

    public void setFrecuent(Boolean frecuent) {
        this.frecuent = frecuent;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public void setProviderType(ProviderType providerType) {
        this.providerType = providerType;
    }

    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }

    public String getEndingCause() {
        return endingCause;
    }

    public void setEndingCause(String endingCause) {
        this.endingCause = endingCause;
    }

}
