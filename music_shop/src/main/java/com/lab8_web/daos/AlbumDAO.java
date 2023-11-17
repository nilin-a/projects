package com.lab8_web.daos;

import com.lab8_web.HibernateUtil;
import com.lab8_web.models.Album;
import com.lab8_web.models.Singer;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AlbumDAO {
    public void createAlbum(Album album) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(album);
            System.out.println("Album is created");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Album readAlbum(long id) {
        Transaction transaction = null;
        Album album = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            album = session.get(Album.class, id);
            System.out.println("Album " + id + " is read");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return album;
    }

    public List<Album> readAllAlbums() {
        Transaction transaction = null;
        List<Album> albumssList = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            albumssList = session.createQuery("from Album ORDER BY id").list();
            for (Album album : albumssList) {
                Hibernate.initialize(album.getSinger());
            }
            System.out.println("Albums are read");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return albumssList;
    }

    public void updateAlbum(Album album) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.update(album);
            System.out.println("Album " + album.getId() + " is updated");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAlbum(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            Album album = session.get(Album.class, id);
            if (album != null) {
                session.delete(album);
                System.out.println("Album " + id + " is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Album> findAlbumByName(String albumName) {
        //Transaction transaction = null;
        //albumName.toLowerCase();
        try (Session session = HibernateUtil.getSession().openSession()) {
           // transaction = session.beginTransaction();
            System.out.println(session);
            List<Album> albumList = session.createQuery("FROM Album WHERE lower(name) LIKE lower(:albumName)", Album.class).setParameter("albumName", "%" + albumName + "%").list();
           // transaction.commit();
            System.out.println(albumList);
            return albumList;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}