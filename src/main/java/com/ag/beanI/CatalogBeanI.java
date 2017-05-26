/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Catalog;
import com.xag.util.NoMatchFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface CatalogBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Catalog
     */
    Catalog add(Catalog o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Catalog
     */
    Catalog update(Catalog o);

    /**
     *
     * @author agunga
     * @return a List of Catalogs
     */
    List<Catalog> findAll();

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return a Catalog object 
     */
    Catalog findById(long o);

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Catalog o);

    int delete(long id);

}
