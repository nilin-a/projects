package com.lab8_web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lab8_web.daos.AlbumDAO;
import com.lab8_web.models.Album;
import com.lab8_web.models.Singer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumServlet extends HttpServlet {
    private AlbumDAO albumDAO;

    public void init() {
        albumDAO = new AlbumDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        try {
            switch (path) {
                case ("/create-album"):
                    request.getRequestDispatcher("jspAlbum/album-creation.jsp").forward(request, response);
                    break;
                case ("/update-album"):
                    showUpdateAlbum(request, response);
                    break;
                case ("/delete-album"):
                    deleteAlbum(request, response);
                    break;
                case ("/albums"):
                    showAlbums(request, response);
                    break;
                case("/find-album"):
                    findAlbum(request, response);
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
                case ("/create-album"):
                    createAlbum(request, response);
                    break;
                case ("/update-album"):
                    updateAlbum(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void createAlbum(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String genre = request.getParameter("genre");
        long singerId = Long.parseLong(request.getParameter("singer"));
        Album album = new Album();
        album.setName(name);
        album.setGenre(genre);
        album.setSinger(new Singer(singerId));
        albumDAO.createAlbum(album);
        response.sendRedirect("albums");
    }

    private void showAlbums(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Album> albumList = albumDAO.readAllAlbums();
        request.setAttribute("albums", albumList);
        request.getRequestDispatcher("jspAlbum/album-list.jsp").forward(request, response);
    }

    private void showUpdateAlbum(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        Album album = albumDAO.readAlbum(id);
        request.setAttribute("album", album);
        request.getRequestDispatcher("jspAlbum/album-updating.jsp").forward(request, response);
    }

    private void updateAlbum(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String genre = request.getParameter("genre");
        Album album = albumDAO.readAlbum(id);
        album.setName(name);
        album.setGenre(genre);
        albumDAO.updateAlbum(album);
        response.sendRedirect("albums");
    }

    private void deleteAlbum(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        albumDAO.deleteAlbum(id);
        response.sendRedirect("albums");
    }

    private void findAlbum(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String albumName = request.getParameter("albumname");
        List<Album> albumList = albumDAO.findAlbumByName(albumName);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        List <ObjectNode> nodes = new ArrayList<>(albumList.size());


        for (Album album : albumList) {
            System.out.println("NAME: " + album.getName());
            ObjectNode node = objectMapper.createObjectNode();
            node.put("name", album.getName());
            node.put("id", album.getId());
            nodes.add(node);
        }

        String json = objectMapper.writeValueAsString(nodes);
        PrintWriter out = response.getWriter();
        System.out.println(json);
        out.print(json);
        out.flush();
    }
}
