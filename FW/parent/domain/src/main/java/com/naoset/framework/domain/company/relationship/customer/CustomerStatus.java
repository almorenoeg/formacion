package com.naoset.framework.domain.company.relationship.customer;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ezequiel
 */
@Entity
public class CustomerStatus extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String name="";
    protected String code="";

    public CustomerStatus() {
        super();
    }

    public CustomerStatus(String code, String name) {
        this();
        this.name = name;
        this.code = code;
    }

    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

}
