/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.ShipmentBeanI;
import com.ag.beanI.OrderBeanI;
import com.ag.dao.ShipmentDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Order;
import com.ag.model.Shipment;
import com.xag.util.NoMatchFoundException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agunga
 */
@Stateless
public class ShipmentBean implements ShipmentBeanI {

    @PersistenceContext(unitName = "BookStore")
    EntityManager em;

    Logger logger = LoggerFactory.getLogger(Shipment.class);

    @EJB
    OrderBeanI bbi;

    public ShipmentDao getDao() {
        return (ShipmentDao) new DaoFactory(DaoType.SHIPMENT).getDao(em);
    }

    @Override
    public Shipment add(Shipment o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Shipment update(Shipment o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Shipment> findAll() {
        return getDao().findAll();
    }

    @Override
    public Shipment findById(long id) throws NoMatchFoundException {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Shipment o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

    @Override
    public Shipment findByOrder(Order o) {
        return getDao().findByOrder(o);
    }

}
