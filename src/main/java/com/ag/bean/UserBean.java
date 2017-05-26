/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.BookBeanI;
import com.ag.beanI.CatalogBeanI;
import com.ag.beanI.OrderBeanI;
import com.ag.beanI.PaymentBeanI;
import com.ag.beanI.ShipmentBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.dao.UserDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Book;
import com.ag.model.Catalog;
import com.ag.model.Order;
import com.ag.model.Payment;
import com.ag.model.Shipment;
import com.ag.model.User;
import com.ag.type.BookStatus;
import com.ag.type.OrderStatus;
import com.ag.type.PaymentStatus;
import com.ag.type.ShipmentStatus;
import com.xag.xtra.trial.EventResource;
import com.xag.xtra.trial.OnLoginFailEvent;
import com.xag.util.BcryptPassword;
import static com.xag.util.BcryptPassword.checkPassword;
import com.xag.util.NoMatchFoundException;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agunga
 */
@Stateless
public class UserBean implements UserBeanI {

    @EJB
    CatalogBeanI catalogBeanI;
    @EJB
    BookBeanI bookBeanI;
    @EJB
    PaymentBeanI paymentBeanI;
    @EJB
    ShipmentBeanI shipmentBeanI;
    @EJB
    OrderBeanI orderBeanI;

    Logger logger = LoggerFactory.getLogger(User.class);

    @PersistenceContext(unitName = "BookStore")
    public EntityManager em;

    public UserDao getDao() {
        return (UserDao) new DaoFactory(DaoType.USER).getDao(em);
    }

    @Override
    public User add(User o) {
        o.setPassword(BcryptPassword.hashPassword(o.getPassword()));

        try {
            return getDao().save(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User update(User o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return getDao().findAll();
    }

    @Override
    public User findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(User o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

    @Inject
    @Named("onLoginFail")
    Event<EventResource> event;

    @Override
    public User authenticate(String username, String password) {

        User u = getDao().findByUsername(username);
        if (u != null) {
            if (checkPassword(password, u.getPassword())) {
                logger.warn("Login success!");
                return u;
            }
        }
        logger.warn("Login failed at nre exception");
        event.fire(new OnLoginFailEvent());
        return null;
    }

    @Override
    public boolean changePassword(String username, String password, String newPassword
    ) {
        User u = authenticate(username, password);
        if (u == null) {
            return false;
        }
        String hashedNewPassword = BcryptPassword.hashPassword(newPassword);
        return (getDao().updatePassword(username, hashedNewPassword) > 0);
    }

    @Override
    public List findAvailableBooks() {
        return bookBeanI.findByStatus(BookStatus.AVAILABLE);
    }

    @Override
    public List findSoldBooks() {
        return bookBeanI.findByStatus(BookStatus.SOLD);
    }

    @Override
    public boolean placeOrder(Order order, List<Book> books) {
//        List<Book> books = order.getBooks();
        int updated = 0;
        Iterator<Book> i = books.iterator();
        while (i.hasNext()) {
            Book book = i.next();
            book.setStatus(BookStatus.SOLD);
            if (bookBeanI.update(book) != null) {
                updated++;
            }
        }
        return orderBeanI.add(order) != null && updated == books.size();
    }

    @Override
    public double getTotal(List<Book> orderedBooks) {
        double total = 0.0;
        Iterator<Book> i = orderedBooks.iterator();
        while (i.hasNext()) {
            Book book = i.next();
            total += book.getPrice();
        }
        return total;

    }

    @Override
    public Shipment addShipment(Shipment shipment) {
        return shipmentBeanI.add(shipment);

    }

    @Override
    public Shipment findShipmentByOrder(Order order) {
        try {
            return shipmentBeanI.findByOrder(order);
        } catch (NoMatchFoundException ex) {
            return null;
        }
    }

    @Override
    public Payment confirmPayment(long orderId) {
        return paymentBeanI.findByOrder(orderBeanI.findById(orderId));
    }

    @Override
    public Book findBookById(long id) {
        return bookBeanI.findById(id);
    }

    @Override
    public List<Order> findOrderAll() {
        return orderBeanI.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        return orderBeanI.update(order);
    }

    @Override
    public Order findOrderById(long id) {
        return orderBeanI.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookBeanI.add(book);
    }

    @Override
    public Catalog findCatalogById(long id) {
        return catalogBeanI.findById(id);
    }

    @Override
    public List<Catalog> findCatalogAll() {
        return catalogBeanI.findAll();
    }

    @Override
    public Catalog addCatalog(Catalog catalog) {
        return catalogBeanI.add(catalog);
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentBeanI.add(payment);
    }

    @Override
    public Payment updatePayment(long id) {
        return paymentBeanI.update(paymentBeanI.findById(id));
    }

    @Override
    public List<Book> findBookAll() {
        return bookBeanI.findAll();
    }

    @Override
    public int deleteBook(long id) {
        return bookBeanI.delete(id);
    }

    @Override
    public Order manipulateOrder(long id, OrderStatus status) {
        Order order = findOrderById(id);
        order.setStatus(status);
        return orderBeanI.update(order);
    }

    @Override
    public Order pendOrder(long id) {
        Order order = findOrderById(id);
        if (order.getStatus() == OrderStatus.NEW) {
            return manipulateOrder(id, OrderStatus.PENDING);
        }
        return null;
    }

    @Override
    public Order cancelOrder(long id) {
        Order order = findOrderById(id);
        if (order.getStatus() == OrderStatus.PENDING) {
            return manipulateOrder(id, OrderStatus.CANCELLED);
        }
        return null;
    }

    @Override
    public Order approveOrder(long id) {
        return manipulateOrder(id, OrderStatus.COMPLETED);
    }

    @Override
    public Payment findOPaymentById(long id) {
        return paymentBeanI.findById(id);
    }

    @Override
    public Payment manipulatePayment(long id, PaymentStatus status) {
        Payment payment = findOPaymentById(id);
        payment.setStatus(status);
        return paymentBeanI.update(payment);
    }

    @Override
    public Payment pendPayment(long id) {
        return manipulatePayment(id, PaymentStatus.PENDING);
    }

    @Override
    public Payment cancelPayment(long id) {
        return manipulatePayment(id, PaymentStatus.CANCELLED);
    }

    @Override
    public Payment approvePayment(long id) {
        return manipulatePayment(id, PaymentStatus.APPROVED);
    }

    @Override
    public Shipment findShipmentById(long id) {
        try {
            return shipmentBeanI.findById(id);
        } catch (NoMatchFoundException ex) {
            return null;
        }
    }

    @Override
    public Shipment manipulateShipment(long id, ShipmentStatus status) {
        Shipment shipment = findShipmentById(id);
        shipment.setStatus(status);
        return shipmentBeanI.update(shipment);
    }

    @Override
    public Shipment processShipment(long id) {
        Shipment shipment = findShipmentById(id);
        Order order = shipment.getOrder();
        Payment payment = findPaymentByOrder(order);
        if (payment.getStatus() == PaymentStatus.APPROVED && shipment.getStatus() == ShipmentStatus.NEW) {
            return manipulateShipment(id, ShipmentStatus.PROCESSED);
        }
        return null;
    }

    @Override
    public Shipment transitShipment(long id) {
        Shipment shipment = findShipmentById(id);
        if (shipment.getStatus() == ShipmentStatus.PROCESSED) {
            return manipulateShipment(id, ShipmentStatus.ON_TRANSIT);
        }
        return null;
    }

    @Override
    public Shipment deliverShipment(long id) {
        Shipment shipment = findShipmentById(id);
        if (shipment.getStatus() == ShipmentStatus.ON_TRANSIT) {
            return manipulateShipment(id, ShipmentStatus.DELIVERED);
        }
        return null;
    }

    @Override
    public Payment findPaymentByOrder(Order order) {
        return paymentBeanI.findByOrder(order);
    }

    @Override
    public Order placeOrder(Order order) {
        return orderBeanI.add(order);
    }

}
