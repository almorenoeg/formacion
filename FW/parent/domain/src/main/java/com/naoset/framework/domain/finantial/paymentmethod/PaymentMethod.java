package com.naoset.framework.domain.finantial.paymentmethod;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ezequiel
 */
@Entity
public class PaymentMethod extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String name="";
    protected Integer expirationDays;
    protected Boolean paymentMethodByDefault=false;
    protected PaymentType paymentType;
    protected String externalCode="";

    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(Integer expirationDays) {
        this.expirationDays = expirationDays;
    }

    public Boolean getPaymentMethodByDefault() {
        return paymentMethodByDefault;
    }

    public void setPaymentMethodByDefault(Boolean paymentMethodByDefault) {
        this.paymentMethodByDefault = paymentMethodByDefault;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

}
