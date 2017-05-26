/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Book;
import com.ag.model.Order;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface OrderBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Order
     */
    Order add(Order o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Order
     */
    Order update(Order o);

    /**
     *
     * @author agunga
     * @return a List of BookTrackers
     */
    List<Order> findAll();

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return a Order object
     */
    Order findById(long id);

    /**
     *
     * @author agunga
     * @param o
     * @return true if the deletion was successful
     */
    boolean delete(Order o);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);

    Order findOrderByUser(long id);

}
