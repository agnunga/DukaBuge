/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Order;
import com.ag.model.Shipment;
import com.ag.type.ShipmentStatus;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class ShipmentDao extends GenericDao<Shipment, Long> {

    EntityManager em;

    public ShipmentDao(EntityManager entityManager) {
        super(Shipment.class, entityManager);
        this.em = entityManager;

    }

    public List findByStatus(ShipmentStatus status) {
        return em.createQuery("SELECT b FROM Book b WHERE b.status =:status ")
                .setParameter("status", status).getResultList();
    }

    public Shipment findByOrder(Order order) {
        try {
            return (Shipment) em.createQuery("SELECT s FROM Shipment s WHERE s.order =:order ")
                    .setParameter("order", order).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
