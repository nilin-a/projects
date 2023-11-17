package com.lab8_web.daos;

import com.lab8_web.HibernateUtil;
import com.lab8_web.models.Song;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.List;

public class SongDAO {
    public void createSong(Song song) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(song);
            System.out.println("Song is created");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Song readSong(long id) {
        Transaction transaction = null;
        Song song = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            song = session.get(Song.class, id);
            System.out.println("Song " + id + " is read");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return song;
    }

    public List<Song> readAllSongs() {
        Transaction transaction = null;
        List<Song> songsList = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            songsList = session.createQuery("from Song ORDER BY id").list();
            for (Song song : songsList) {
                Hibernate.initialize(song.getAlbum());
            }
            System.out.println("Songs are read");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return songsList;
    }

    public void updateSong(Song song) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.update(song);
            System.out.println("Song " + song.getId() + " is updated");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteSong(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            Song song = session.get(Song.class, id);
            System.out.println(song.getId());
            if (song != null) {
                session.delete(song);
                System.out.println("Song " + id + " is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
