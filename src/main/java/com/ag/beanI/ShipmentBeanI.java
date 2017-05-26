/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Order;
import com.ag.model.Shipment;
import com.xag.util.NoMatchFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface ShipmentBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Shipment
     */
    Shipment add(Shipment o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Shipment
     */
    Shipment update(Shipment o);

    /**
     *
     * @param id is the primary key
     * @param o is the object to be updated
     * @return the updated Shipment
     */
//    Shipment update(long id, Shipment o);
    /**
     *
     * @author agunga
     * @return a List of Shipments
     */
    List<Shipment> findAll();

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return a Shipment object
     * @throws com.xag.util.NoMatchFoundException
     */
    Shipment findById(long id) throws NoMatchFoundException;

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Shipment o);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);

    Shipment findByOrder(Order o) throws NoMatchFoundException;

}
