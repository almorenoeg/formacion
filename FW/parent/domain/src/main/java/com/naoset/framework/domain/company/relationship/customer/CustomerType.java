package com.naoset.framework.domain.company.relationship.customer;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ezequiel
 */
@Entity
public class CustomerType extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String code = "";
    protected String name = "";

    public CustomerType() {
        super();
    }

    public CustomerType(String code, String name) {
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

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
