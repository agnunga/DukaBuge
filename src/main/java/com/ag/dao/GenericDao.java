package com.ag.dao;

import com.xag.util.NoMatchFoundException;
import com.xag.util.WriteLogsToFile;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 3/23/2017.
 *
 * @param <T>
 * @param <PK>
 */
public class GenericDao<T, PK extends Serializable> implements GenericDaoI<T, PK> {

    private final Class<T> entityClass;
    public EntityManager entityManager;
    private final Logger jLogger;

    public GenericDao(Class<T> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
        this.jLogger = LoggerFactory.getLogger(entityClass);
    }

    @Override
    public T save(T t) {
        jLogger.info(t.toString());
        WriteLogsToFile.write("genericdao.log", t.toString());
        try {
            this.entityManager.persist(t);
            return t;
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return null;
        }
    }

    @Override
    public T findById(PK id)  throws NoMatchFoundException{
        jLogger.info(id.toString());
        try {
            return this.entityManager.find(entityClass, id);
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return null;
        }
    }

    @Override
    public T merge(T t) {
        jLogger.info(t.toString());
        try {
            return this.entityManager.merge(t);
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        jLogger.warn("Finding all");
        jLogger.warn("EM: " + entityManager);
        return this.entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t")
                .getResultList();
    }

    @Override
    public boolean remove(T t) {
        try {
            t = this.entityManager.merge(t);
            this.entityManager.remove(t);
            return true;
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return false;
        }
    }

    @Override
    public int removeById(PK id) {
        try {
            return this.entityManager.createQuery("DELETE FROM " + entityClass.getSimpleName() + " ec WHERE ec.id = :id")
                    .setParameter("id", id).executeUpdate();
        } catch (PersistenceException pe) {
            jLogger.error(pe.getMessage());
            return 0;
        }
    }
}
