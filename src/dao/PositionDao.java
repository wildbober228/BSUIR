package dao;

import models.Position;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class PositionDao {

    public Position findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Position.class, id);
    }

    public void save(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(position);
        tx1.commit();
        session.close();
    }

    public void update(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(position);
        tx1.commit();
        session.close();
    }

    public void delete(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(position);
        tx1.commit();
        session.close();
    }

}
