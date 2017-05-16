package com.terralcode.framework.domain.profile;

import com.terralcode.framework.domain.DomainEntity;
import com.naoset.framework.domain.company.Company;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Almoreno
 */
@Entity
public class User extends DomainEntity {

    private String phone="";
    
    
    private Integer roleUser;
//    @Size(min = 3, max = 50)
    private String firstName="";

//    @Size(min = 3, max = 50)
    private String lastName="";

//    @Size(min = 6, max = 10)
    private String password="";

//    @Email
    private String email="";

    @OneToOne
    private Company company;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return the role
     */
    @NotNull
    public Integer getRoleUser() {
        return roleUser;
    }

    /**
     * @param role the role to set
     */
    public void setRoleUser(Integer role) {
        this.roleUser = role;
    }
}
