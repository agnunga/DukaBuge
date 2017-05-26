/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.BookBeanI;
import com.ag.beanI.OrderBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.dao.OrderDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Order;
import com.ag.model.User;
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
public class OrderBean implements OrderBeanI {
    
    @PersistenceContext(unitName = "BookStore")
    EntityManager em;
    
    Logger logger = LoggerFactory.getLogger(Order.class);
    
    @EJB
    BookBeanI rbi;
    
    public OrderDao getDao() {
        return (OrderDao) new DaoFactory(DaoType.ORDER).getDao(em);
    }
    
    @Override
    public Order add(Order o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    
    @Override
    public Order update(Order o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Order> findAll() {
        return getDao().findAll();
    }
    
    @Override
    public Order findById(long id) {
        
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean delete(Order o) {
        return getDao().remove(o);
    }
    
    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }
    @EJB
    UserBeanI userBeanI;

    @Override
    public Order findOrderByUser(long id) {
        User user = userBeanI.findById(id);
        return getDao().findByUser(user);
    }
    
}
