package HotelTest.services;

import HotelTest.dao.IDao;
import HotelTest.entities.Chambre;
import HotelTest.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChambreService implements IDao<Chambre> {

    @Override
    public boolean create(Chambre o) {
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
    public boolean delete(Chambre o) {
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
    public boolean update(Chambre o) {
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
    public Chambre findById(long id) {
        Session session = null;
        Transaction tx = null;
        Chambre r = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            r = (Chambre) session.get(Chambre.class, id);
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

        return r;
    }

    @Override
    public List<Chambre> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Chambre> r = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            r = session.createQuery("from Chambre order by id")
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

        return r;
    }

    public List<Chambre> findByHotel(long hotelId) {
        Session session = null;
        Transaction tx = null;
        List<Chambre> r = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            r = session.createQuery("from Chambre c where c.hotel.id = :hid order by c.id")
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

        return r;
    }

    public List<Chambre> findByPrix(double prix) {
        Session session = null;
        Transaction tx = null;
        List<Chambre> r = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            r = session.createQuery("from Chambre c where c.prix = :prix order by c.id")
                    .setParameter("prix", prix)
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

        return r;
    }

    public List<Chambre> findByEtat(boolean etat) {
        Session session = null;
        Transaction tx = null;
        List<Chambre> r = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            r = session.createQuery("from Chambre c where c.etat = :etat order by c.id")
                    .setParameter("etat", etat)
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

        return r;
    }

    public List<Chambre> findByEtatAndPrix(boolean etat, double prixMax) {
        Session session = null;
        Transaction tx = null;
        List<Chambre> r = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            r = session.createQuery("from Chambre c where c.etat = :etat and c.prix <= :prix order by c.id")
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

        return r;
    }
}