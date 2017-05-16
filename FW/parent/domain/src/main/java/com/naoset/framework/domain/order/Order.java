/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.domain.order;

import com.terralcode.framework.domain.DomainEntity;
import com.naoset.framework.domain.company.employee.Employee;
import com.naoset.framework.domain.company.relationship.customer.Customer;
import com.terralcode.framework.domain.order.delivery.DeliveryType;
import com.naoset.framework.domain.company.relationship.provider.Provider3;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ezequiel
 */
@Entity
@Table(name = "\"Order\"")
public class Order extends DomainEntity {

    private static final long serialVersionUID = 1L;
    protected LocalDateTime orderDate;
    protected LocalDateTime deliveryExpectedDate;
    protected LocalDateTime deliveryDate;
    protected String code="";
    protected Provider3 provider;
    protected Customer customer;
    protected Employee shopper;
    protected DeliveryType deliveryType;
    protected String commentsForTransportingGoods="";
    protected String comments="";
    protected List<OrderDetail> details = new ArrayList<>();

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDeliveryExpectedDate() {
        return deliveryExpectedDate;
    }

    public void setDeliveryExpectedDate(LocalDateTime deliveryExpectedDate) {
        this.deliveryExpectedDate = deliveryExpectedDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @OneToOne
    public Provider3 getProvider() {
        return provider;
    }

    public void setProvider(Provider3 provider) {
        this.provider = provider;
    }

    @OneToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne
    public Employee getShopper() {
        return shopper;
    }

    public void setShopper(Employee shopper) {
        this.shopper = shopper;
    }

    @OneToOne
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getCommentsForTransportingGoods() {
        return commentsForTransportingGoods;
    }

    public void setCommentsForTransportingGoods(String commentsForTransportingGoods) {
        this.commentsForTransportingGoods = commentsForTransportingGoods;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    public List<OrderDetail> getDetails() {
//        if (details == null) {
//            details = new ArrayList<>();
//        }
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

}
