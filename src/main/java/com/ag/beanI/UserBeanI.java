/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Book;
import com.ag.model.Catalog;
import com.ag.model.Order;
import com.ag.model.Payment;
import com.ag.model.Shipment;
import com.ag.model.User;
import com.ag.type.OrderStatus;
import com.ag.type.PaymentStatus;
import com.ag.type.ShipmentStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface UserBeanI {

    /**
     *
     * @param o
     * @return
     */
    User add(User o);

    /**
     *
     * @param o
     * @return
     */
    User update(User o);

    /**
     *
     * @return
     */
    List<User> findAll();

    /**
     *
     * @param id
     * @return
     */
    User findById(long id);

    /**
     *
     * @param o
     * @return
     */
    boolean delete(User o);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User authenticate(String username, String password);

    /**
     *
     * @param username
     * @param password
     * @param newPassword
     * @return
     */
    boolean changePassword(String username, String password, String newPassword);

    /**
     *
     * @param id
     * @return number of deleted items
     */
    int delete(long id);

    Catalog findCatalogById(long id);

    List<Catalog> findCatalogAll();

    Catalog addCatalog(Catalog catalog);

    Book addBook(Book book);

    List<Book> findBookAll();

    int deleteBook(long id);

    List findAvailableBooks();

    List findSoldBooks();

    Book findBookById(long id);

    List<Order> findOrderAll();

    double getTotal(List<Book> orderedBooks);

    boolean placeOrder(Order order, List<Book> books);

    Order updateOrder(Order order);

    Order findOrderById(long id);

    Order approveOrder(long id);

    Order placeOrder(Order order);

    Order cancelOrder(long id);

    Order pendOrder(long id);

    Order manipulateOrder(long id, OrderStatus status);

    Payment approvePayment(long id);

    Payment cancelPayment(long id);

    Payment pendPayment(long id);

    Payment manipulatePayment(long id, PaymentStatus status);

    Payment findOPaymentById(long id);

    Payment updatePayment(long id);

    Payment confirmPayment(long orderId);

    Payment addPayment(Payment payment);

    Payment findPaymentByOrder(Order order);

    Shipment findShipmentByOrder(Order order);

    Shipment deliverShipment(long id);

    Shipment addShipment(Shipment shipment);

    Shipment transitShipment(long id);

    Shipment processShipment(long id);

    Shipment manipulateShipment(long id, ShipmentStatus status);

    Shipment findShipmentById(long id);

}
