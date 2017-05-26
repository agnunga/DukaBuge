/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Book; 
import com.ag.type.BookStatus;
import java.util.List;
import javax.persistence.EntityManager; 

/**
 *
 * @author agunga
 */
public class BookDao extends GenericDao<Book, Long> {

    EntityManager em;

    public BookDao(EntityManager entityManager) {
        super(Book.class, entityManager);
        this.em = entityManager;
    }

    public List findByStatus(BookStatus status) {
        return em.createQuery("SELECT b FROM Book b WHERE b.status =:status ")
                .setParameter("status", status).getResultList();
    }
}
