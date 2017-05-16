package com.naoset.framework.domain.company.billinginfo;

import com.terralcode.framework.domain.DomainEntity;
import com.naoset.framework.domain.company.Company;
import com.naoset.framework.domain.finantial.bankaccount.BankAccount;
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
public class BillingInfo extends DomainEntity {
    private static final long serialVersionUID = 1L;
    protected List<BankAccount> bankAccounts = new ArrayList<>();
    protected Boolean taxFree;
    protected Company company;
    
    @OneToMany(cascade = CascadeType.ALL)
    public List<BankAccount> getBankAccounts() {
//        if (bankAccounts == null) {
//            bankAccounts = new ArrayList<>();
//        }
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Boolean getTaxFree() {
        return taxFree;
    }

    public void setTaxFree(Boolean taxFree) {
        this.taxFree = taxFree;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    
}
