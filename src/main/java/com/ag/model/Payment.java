/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import com.ag.type.PaymentMode;
import com.ag.type.PaymentStatus;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "payments")
@NamedQueries({})
public class Payment implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private double amount;
    @ManyToOne
    private Order order;
    private PaymentMode paymentMode;
    private LocalDateTime paymentDatetime;
    private PaymentStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDatetime() {
        return paymentDatetime;
    }

    public void setPaymentDatetime(LocalDateTime paymentDatetime) {
        this.paymentDatetime = paymentDatetime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

}
