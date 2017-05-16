package com.terralcode.gestion.domain.customer;

import com.terralcode.gestion.domain.sales.Sales;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmsuarez
 */
@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class CustomerCRM extends com.naoset.framework.domain.company.relationship.customer.Customer {

    private static final long serialVersionUID = 1L;
    protected Boolean prestige;
    protected Boolean exclusive;
    protected Boolean canGrow;
    protected String consultingLevel = "";
    protected String salesLevel = "";
    protected List<Species> species = new ArrayList<>();
    protected List<Sales> sales = new ArrayList<>();
    private Calendar lastModification;

    
    @OneToMany(cascade = CascadeType.ALL)
    @Basic(fetch = FetchType.EAGER)
    public List<Species> getSpecies() {
        return species;
    }

    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval=true)
    @Basic(fetch = FetchType.EAGER)
    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public Boolean getPrestige() {
        return prestige;
    }

    public void setPrestige(Boolean prestige) {
        this.prestige = prestige;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public Boolean getCanGrow() {
        return canGrow;
    }

    public void setCanGrow(Boolean canGrow) {
        this.canGrow = canGrow;
    }

    public String getConsultingLevel() {
        return consultingLevel;
    }

    public void setConsultingLevel(String consultingLevel) {
        this.consultingLevel = consultingLevel;
    }

    public String getSalesLevel() {
        return salesLevel;
    }

    public void setSalesLevel(String salesLevel) {
        this.salesLevel = salesLevel;
    }
    
    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }

    public Calendar getLastModification()
    {
        return lastModification;
    }

    public void setLastModification(Calendar lastModification)
    {
        this.lastModification = lastModification;
    }

    
}
