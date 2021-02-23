package dao;

import models.Order;
import models.Customer;
import models.Good;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class OrderDao {

    public Order findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Order.class, id);
    }

    public void save(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(order);
        tx1.commit();
        session.close();
    }

    public void update(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(order);
        tx1.commit();
        session.close();
    }

    public void delete(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(order);
        tx1.commit();
        session.close();
    }

    public Customer findCustomerById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    public Good findGoodById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Good.class, id);
    }

}
