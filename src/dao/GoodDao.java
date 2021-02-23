package dao;

import models.Good;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class GoodDao {

    public Good findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Good.class, id);
    }

    public void save(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(good);
        tx1.commit();
        session.close();
    }

    public void update(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(good);
        tx1.commit();
        session.close();
    }

    public void delete(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(good);
        tx1.commit();
        session.close();
    }

}