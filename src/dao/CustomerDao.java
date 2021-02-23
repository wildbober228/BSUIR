package dao;

import models.Customer;
import models.Discount;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public Customer findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Customer customer = new Customer();
        try {
            customer = session.get(Customer.class, id);
            session.close();
            return customer;
        } catch (HibernateException e){
            System.out.println(e.toString());
        }
        return customer;
    }

    public void save(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
        Transaction tx1 = session.beginTransaction();
        session.save(customer);
        tx1.commit();
        session.close();
        } catch (HibernateException e){
            System.out.println(e.toString());
        }
    }

    public void update(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
        Transaction tx1 = session.beginTransaction();
        session.update(customer);
        tx1.commit();
        session.close();
        } catch (HibernateException e){
            System.out.println(e.toString());
        }
    }

    public void delete(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
        Transaction tx1 = session.beginTransaction();
        session.delete(customer);
        tx1.commit();
        session.close();
        } catch (HibernateException e){
            System.out.println(e.toString());
        }
    }

    public Discount findDiscountById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Discount discount = new Discount();
        try {
        discount = session.get(Discount.class, id);
        session.close();

        } catch (HibernateException e){
            System.out.println(e.toString());
        }
        return discount;
    }

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<Customer>();
        try{
        customers = (List<Customer>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Customer").list();
        } catch (HibernateException e){
            System.out.println(e.toString());
        }
        return customers;
    }

}
