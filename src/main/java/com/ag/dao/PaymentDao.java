/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Order;
import com.ag.model.Payment;
import com.ag.type.PaymentStatus;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class PaymentDao extends GenericDao<Payment, Long> {

    EntityManager em;

    public PaymentDao(EntityManager entityManager) {
        super(Payment.class, entityManager);
        this.em = entityManager;

    }

    public List findByStatus(PaymentStatus status) {
        return em.createQuery("SELECT o FROM Payment o WHERE o.status =:status ")
                .setParameter("status", status).getResultList();
    }

    public Payment findByOrder(Order order) {
        return (Payment) em.createQuery("SELECT o FROM Payment o WHERE o.order =:order ")
                .setParameter("order", order).getSingleResult();
    }
}
