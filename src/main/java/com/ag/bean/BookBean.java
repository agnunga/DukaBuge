/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.BookBeanI;
import com.ag.beanI.OrderBeanI;
import com.ag.dao.BookDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Book;
import com.ag.type.BookStatus;
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
//@DeclareRoles({"ADMIN", "CUSTOMER"})
public class BookBean implements BookBeanI {

    @PersistenceContext(unitName = "BookStore")
    EntityManager em;

    Logger logger = LoggerFactory.getLogger(Book.class);

    @EJB
    OrderBeanI bbi;

    public BookDao getDao() {
        return (BookDao) new DaoFactory(DaoType.BOOK).getDao(em);
    }

//    @RolesAllowed("ADMIN")
    @Override
    public Book add(Book o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Book update(Book o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Book> findAll() {
        return getDao().findAll();
    }

    @Override
    public Book findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Book o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

    @Override
    public List findByStatus(BookStatus status) {
        return getDao().findByStatus(status);
    }

}
