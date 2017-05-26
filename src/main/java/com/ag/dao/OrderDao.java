/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Order;
import com.ag.model.User;
import com.ag.type.BookStatus;
import com.ag.type.OrderStatus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author agunga
 */
public class OrderDao extends GenericDao<Order, Long> {

    private final EntityManager em;

    public OrderDao(EntityManager em) {
        super(Order.class, em);
        this.em = em;
    }

    public Order findByUser(User user) {
        try {
            return (Order) em.createQuery("SELECT o FROM Order o WHERE o.user =:user")
                    .setParameter("user", user).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List findByStatus(OrderStatus status) {
        return em.createQuery("SELECT b FROM Order b WHERE b.status =:status ")
                .setParameter("status", status).getResultList();
    }
}
