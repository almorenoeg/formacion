/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.domain.finantial.bankaccount;

import com.terralcode.framework.domain.DomainEntity;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Ezequiel
 */
@Entity
public class BankAccount extends DomainEntity {
    private static final long serialVersionUID = 1L;
    protected String bank="";
    protected String iban="";
    protected PlainAddress branch;
       
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public PlainAddress getBranch() {
        return branch;
    }
    public void setBranch(PlainAddress branch) {
        this.branch = branch;
    }
}
