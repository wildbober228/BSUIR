package dao;

import models.Departament;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class DepartmentDao {

    public Departament findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Departament.class, id);
    }

    public void save(Departament departament) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(departament);
        tx1.commit();
        session.close();
    }

    public void update(Departament departament) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(departament);
        tx1.commit();
        session.close();
    }

    public void delete(Departament departament) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(departament);
        tx1.commit();
        session.close();
    }

}
