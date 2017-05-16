/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.domain.company;

import com.terralcode.framework.domain.DomainEntity;
import com.terralcode.framework.domain.commons.contactinfo.ContactInfo;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import com.naoset.framework.domain.company.billinginfo.BillingInfo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Ezequiel 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Company extends DomainEntity {
    private static final long serialVersionUID = 1L;
    protected String code="";
    protected String name="";
    protected String companyTaxCode="";
    protected String telephone = "";
    protected List<PlainAddress> addressList = new ArrayList<>();
    protected List<ContactInfo> contactInfoList = new ArrayList<>();
    protected BillingInfo billingInfo;
    protected Boolean approved;
    

    /**
     * @return the code
     */
//    @NotEmpty
    public String getCode()
    {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * @return the name
     */
//    @NotEmpty
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the companyTaxCode
     */
    public String getCompanyTaxCode()
    {
        return companyTaxCode;
    }

    /**
     * @param companyTaxCode the companyTaxCode to set
     */
    public void setCompanyTaxCode(String companyTaxCode)
    {
        this.companyTaxCode = companyTaxCode;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @Basic(fetch = FetchType.EAGER)
    public List<PlainAddress> getAddressList() {
//        if (addressList == null) {
//            addressList = new ArrayList<>();
//        }
        return addressList;
    }

    public void setAddressList(List<PlainAddress> addressList) {
        this.addressList = addressList;
    }

    @Transient
    public ContactInfo getMainContactInfo(){
        if (!contactInfoList.isEmpty()){
            return contactInfoList.get(0);
        } else
            return new ContactInfo();
    }
            

    /**
     * @return the contactInfoList
     */
    @OneToMany(cascade = CascadeType.ALL)
    @Basic(fetch = FetchType.EAGER)
    public List<ContactInfo> getContactInfoList()
    {
//        if (contactInfoList == null) {
//            contactInfoList = new ArrayList<>();
//        }
        return contactInfoList;
    }

    /**
     * @param contactInfoList the contactInfoList to set
     */
    public void setContactInfoList(List<ContactInfo> contactInfoList)
    {
        this.contactInfoList = contactInfoList;
    }

    /**
     * @return the billingInfo
     */
    @OneToOne(cascade = CascadeType.ALL)
    public BillingInfo getBillingInfo()
    {
        return billingInfo;
    }

    /**
     * @param billingInfo the billingInfo to set
     */
    public void setBillingInfo(BillingInfo billingInfo)
    {
        this.billingInfo = billingInfo;
    }

    /**
     * @return the approved
     */
    public Boolean getApproved()
    {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(Boolean approved)
    {
        this.approved = approved;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
