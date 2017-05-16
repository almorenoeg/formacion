package com.naoset.framework.domain.company.mycompany;

import com.naoset.framework.domain.company.Company;
import com.naoset.framework.domain.company.employee.Employee;
import com.naoset.framework.domain.company.relationship.customer.Customer;
import com.naoset.framework.domain.company.relationship.provider.Provider3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Ezequiel
 */
@Entity
public class MyCompany extends Company{
    private static final long serialVersionUID = 1L;  
    protected List<Employee> employees = new ArrayList<>();
    protected List<Customer> customers = new ArrayList<>();
    protected List<Provider3> providers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    public List<Employee> getEmployees() {
//        if (employees == null) {
//            employees = new ArrayList<>();
//        }
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    @OneToMany(cascade = CascadeType.ALL)
    public List<Customer> getCustomers() {
//        if (customers == null) {
//            customers = new ArrayList<>();
//        }
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Provider3> getProviders() {
//        if (providers == null) {
//            providers = new ArrayList<>();
//        }
        return providers;
    }
    public void setProviders(List<Provider3> providers) {
        this.providers = providers;
    }

    
}
