package dao;

import models.Discount;
import models.Position;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DiscountDao {

    public Discount findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Discount.class, id);
    }
    

    public void save(Discount discount) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(discount);
        tx1.commit();
        session.close();
    }

    public void update(Discount discount) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(discount);
        tx1.commit();
        session.close();
    }

    public void delete(Discount discount) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(discount);
        tx1.commit();
        session.close();
    }

    public List<Discount> findAll() {
        List<Discount> discounts = (List<Discount>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Discount").list();
        return discounts;
    }

}
