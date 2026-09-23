/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelTest.services;

import java.util.List;
import HotelTest.dao.IDao;
import HotelTest.entities.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import HotelTest.util.HibernateUtil;

public class HotelService implements IDao<Hotel> {

    public boolean create(Hotel o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.save(o);

            tx.commit();
            etat = true;

        } catch (HibernateException ex) {
            ex.printStackTrace();

            if (tx != null) {
                tx.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return etat;
    }

    @Override
    public boolean delete(Hotel o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.delete(o);

            tx.commit();
            etat = true;

        } catch (HibernateException ex) {
            ex.printStackTrace();

            if (tx != null) {
                tx.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return etat;
    }

    @Override
    public boolean update(Hotel o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.update(o);

            tx.commit();
            etat = true;

        } catch (HibernateException ex) {
            ex.printStackTrace();

            if (tx != null) {
                tx.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return etat;
    }

    @Override
    public Hotel findById(long id) {
        Session session = null;
        Transaction tx = null;
        Hotel c = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            c = (Hotel) session.get(Hotel.class, id);

            tx.commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();

            if (tx != null) {
                tx.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return c;
    }

    @Override
    public List<Hotel> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Hotel> list = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            list = session.createQuery("from Hotel").list();

            tx.commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();

            if (tx != null) {
                tx.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return list;
    }

    public List<Hotel> findByHotel(long hotelId) {
        Session session = null;
        Transaction tx = null;
        List<Hotel> list = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            list = session.createQuery(
                    "from Hotel c where c.hotel.id = :hid")
                    .setParameter("hid", hotelId)
                    .list();

            tx.commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();

            if (tx != null) {
                tx.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return list;
    }

    public List<Hotel> findByEtatAndPrix(boolean etat, double prixMax) {
        Session session = null;
        Transaction tx = null;
        List<Hotel> list = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            list = session.createQuery(
                    "from Hotel c where c.etat = :etat and c.prix <= :prix")
                    .setParameter("etat", etat)
                    .setParameter("prix", prixMax)
                    .list();

            tx.commit();

        } catch (HibernateException ex) {
            ex.printStackTrace();

            if (tx != null) {
                tx.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return list;
    }

    @Override
    public boolean creat(Hotel o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}