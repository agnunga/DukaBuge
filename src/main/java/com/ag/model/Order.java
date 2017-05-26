/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import com.ag.type.OrderStatus;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "orders")
@NamedQueries({})
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private double amount;
    @ManyToOne
    private User user;
    @OneToMany
    List<Book> books;
//    private LocalDateTime orderDatetime;
    private OrderStatus status;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public LocalDateTime getOrderDatetime() {
//        return orderDatetime;
//    }
//
//    public void setOrderDatetime(LocalDateTime orderDatetime) {
//        this.orderDatetime = orderDatetime;
//    }
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
