package com.terralcode.gestion.domain.customer;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ezequiel
 */
@Entity
public class Species extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected String code="";
    protected String name="";

    public Species() {
        super();
    }

    public Species(String code, String name) {
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

    @Override
    public String toString() {
        return this.name;
    }

    
}
