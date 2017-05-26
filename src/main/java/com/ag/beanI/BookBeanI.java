/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Book;
import com.ag.type.BookStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface BookBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Book
     */
    Book add(Book o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Book
     */
    Book update(Book o);

    /**
     *
     * @param id is the primary key
     * @param o is the object to be updated
     * @return the updated Book
     */
//    Book update(long id, Book o);
    /**
     *
     * @author agunga
     * @return a List of Books
     */
    List<Book> findAll();

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return a Book object
     */
    Book findById(long id);

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Book o);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);

    List findByStatus(BookStatus status);

}
