/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.factory;

import com.ag.dao.GenericDao;
import com.ag.dao.PaymentDao;
import com.ag.dao.OrderDao;
import com.ag.dao.BookDao;
import com.ag.dao.CatalogDao;
import com.ag.dao.ShipmentDao;
import com.ag.dao.UserDao;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class DaoFactory {

    DaoType type;

    public DaoFactory(DaoType type) {
        this.type = type;
    }

    DaoFactory() {
    }

    public GenericDao getDao(EntityManager em) {
        switch (type) {
            case PAYMENT: {
                return new PaymentDao(em);
            }
            case ORDER: {
                return new OrderDao(em);
            }
            case CATALOG: {
                return new CatalogDao(em);
            }
            case BOOK: {
                return new BookDao(em);
            }
            case USER: {
                return new UserDao(em);
            }
            case SHIPMENT: {
                return new ShipmentDao(em);
            }
            default:
                return null;
        }
    }

    public GenericDao getDao(DaoType type, EntityManager em) {
        return new DaoFactory(type).getDao(em);
    }
}
