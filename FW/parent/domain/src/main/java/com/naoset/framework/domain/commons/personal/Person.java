
package com.naoset.framework.domain.commons.personal;

import com.terralcode.framework.domain.DomainEntity;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Álvaro
 * @see 
 */
@Entity
public class Person extends DomainEntity {
    private static final long serialVersionUID = 1L;
    protected String name = "";
    protected String surname = "";
    protected String email = "";
    protected String telephoneNumber = "";
    protected String mobile = "";    
    protected Calendar birthdate;

    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NotEmpty
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @NotEmpty
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Calendar getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

//    public Boolean isActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }

   
    
    
    
    
    
}
