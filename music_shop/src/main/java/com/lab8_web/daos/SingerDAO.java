package com.lab8_web.daos;

import com.lab8_web.HibernateUtil;
import com.lab8_web.models.Album;
import com.lab8_web.models.Singer;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SingerDAO {
    public void createSinger(Singer singer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(singer);
            System.out.println("Singer is created");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Singer readSinger(long id) {
        Transaction transaction = null;
        Singer singer = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            singer = session.get(Singer.class, id);
            System.out.println("Singer " + id + " is read");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return singer;
    }

    public List<Singer> readAllSingers() {
        Transaction transaction = null;
        List<Singer> singerList = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            singerList = session.createQuery("from Singer ORDER BY id").list();
            System.out.println("Singers are read");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return singerList;
    }

    public void updateSinger(Singer singer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.update(singer);
            System.out.println("Singer " + singer.getId() + " is updated");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteSinger(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            Singer singer = session.get(Singer.class, id);
            if (singer != null) {
                session.delete(singer);
                System.out.println("Singer " + id + " is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Singer> findSingerByName(String singerName) {
        //Transaction transaction = null;
        //albumName.toLowerCase();
        try (Session session = HibernateUtil.getSession().openSession()) {
            // transaction = session.beginTransaction();
            System.out.println(session);
            List<Singer> singerList = session.createQuery("FROM Singer WHERE lower(name) LIKE lower(:singerName)", Singer.class).setParameter("singerName", "%" + singerName + "%").list();
            // transaction.commit();

            return singerList;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}
