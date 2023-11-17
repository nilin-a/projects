package com.lab8_web.servlets;

import com.lab8_web.daos.AlbumDAO;
import com.lab8_web.daos.SongDAO;
import com.lab8_web.models.Album;
import com.lab8_web.models.Singer;
import com.lab8_web.models.Song;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class SongServlet extends HttpServlet {
    private SongDAO songDAO;
    public void init() {
        songDAO = new SongDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        try {
            switch (path) {
                case ("/create-song"):
                    request.getRequestDispatcher("jspSong/song-creation.jsp").forward(request, response);
                    break;
                case ("/update-song"):
                    showUpdateSong(request, response);
                    break;
                case ("/delete-song"):
                    deleteSong(request, response);
                    break;
                case ("/songs"):
                    showSongs(request, response);
                    break;
                default:
                    response.sendRedirect("");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        try {
            switch (path) {
                case ("/create-song"):
                    createSong(request, response);
                    break;
                case ("/update-song"):
                    updateSong(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void createSong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        System.out.println(request.getParameter("duration"));
        System.out.println(Time.valueOf(request.getParameter("duration")));
        Time duration = Time.valueOf(request.getParameter("duration"));
        long albumId = Long.parseLong(request.getParameter("album"));
        Song song = new Song();
        song.setName(name);
        song.setDuration(duration);
        song.setAlbum(new Album(albumId));
        songDAO.createSong(song);
        response.sendRedirect("songs");
    }

    private void showSongs(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Song> songList = songDAO.readAllSongs();
        request.setAttribute("songs", songList);
        request.getRequestDispatcher("jspSong/song-list.jsp").forward(request, response);
    }

    private void showUpdateSong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        Song song = songDAO.readSong(id);
        request.setAttribute("song", song);
        request.getRequestDispatcher("jspSong/song-updating.jsp").forward(request, response);
    }

    private void updateSong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Time duration = Time.valueOf(request.getParameter("duration"));
        Song song = songDAO.readSong(id);
        song.setName(name);
        song.setDuration(duration);
        songDAO.updateSong(song);
        response.sendRedirect("songs");
    }

    private void deleteSong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        songDAO.deleteSong(id);
        response.sendRedirect("songs");
    }
}
