/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.CatalogBeanI;
import com.ag.dao.CatalogDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Catalog;
import com.xag.util.NoMatchFoundException;
import java.util.List;
import java.util.logging.Level;
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
public class CatalogBean implements CatalogBeanI {

    @PersistenceContext(unitName = "BookStore")
    EntityManager em;

    Logger logger = LoggerFactory.getLogger(Catalog.class);

    @EJB
    CatalogBeanI cbi;

    public CatalogDao getDao() {
        return (CatalogDao) new DaoFactory(DaoType.CATALOG).getDao(em);
    }

    @Override
    public Catalog add(Catalog o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Catalog update(Catalog o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Catalog> findAll() {
        return getDao().findAll();
    }

    @Override
    public Catalog findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            return null;
        }
    }

    @Override
    public boolean delete(Catalog o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

}
