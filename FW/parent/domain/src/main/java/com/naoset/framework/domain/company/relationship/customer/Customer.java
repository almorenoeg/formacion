package com.naoset.framework.domain.company.relationship.customer;

import com.naoset.framework.domain.company.Company;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author Álvaro
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends Company {

    private static final long serialVersionUID = 1L;
    protected CustomerStatus customerStatus;
    protected CustomerType customerType;

    @OneToOne(cascade = CascadeType.ALL)
    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    @OneToOne
    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

}
