/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Catalog;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class CatalogDao extends GenericDao<Catalog, Long> {

    public CatalogDao(EntityManager entityManager) {
        super(Catalog.class, entityManager);
    }

}
