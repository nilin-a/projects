package com.lab8_web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lab8_web.daos.SingerDAO;
import com.lab8_web.models.Album;
import com.lab8_web.models.Singer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingerServlet extends HttpServlet {
    private SingerDAO singerDAO;

    public void init() {
        singerDAO = new SingerDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        try {
            switch (path) {
                case ("/create-singer"):
                    request.getRequestDispatcher("jspSinger/singer-creation.jsp").forward(request, response);
                    break;
                case ("/update-singer"):
                    showUpdateSinger(request, response);
                    break;
                case ("/delete-singer"):
                    deleteSinger(request, response);
                    break;
                case ("/singers"):
                    showSingers(request, response);
                    break;
                case("/find-singer"):
                    findSinger(request, response);
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
                case ("/create-singer"):
                    createSinger(request, response);
                    break;
                case ("/update-singer"):
                    updateSinger(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void createSinger(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        Singer singer = new Singer();
        singer.setName(name);
        singerDAO.createSinger(singer);
        response.sendRedirect("singers");
    }

    private void showSingers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Singer> singerList = singerDAO.readAllSingers();
        System.out.println(singerList.get(1));
        request.setAttribute("singers", singerList);
        request.getRequestDispatcher("jspSinger/singer-list.jsp").forward(request, response);
    }

    private void showUpdateSinger(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        Singer singer = singerDAO.readSinger(id);
        request.setAttribute("singer", singer);
        request.getRequestDispatcher("jspSinger/singer-updating.jsp").forward(request, response);
    }

    private void updateSinger(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Singer singer = singerDAO.readSinger(id);
        singer.setName(name);
        singerDAO.updateSinger(singer);
        response.sendRedirect("singers");
    }

    private void deleteSinger(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        singerDAO.deleteSinger(id);
        response.sendRedirect("singers");
    }

    private void findSinger(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        String singerName = request.getParameter("singername");
        List<Singer> singerList = singerDAO.findSingerByName(singerName);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        List <ObjectNode> nodes = new ArrayList<>(singerList.size());


        for (Singer singer : singerList) {
            ObjectNode node = objectMapper.createObjectNode();
            node.put("name", singer.getName());
            node.put("id", singer.getId());
            nodes.add(node);
        }

        String json = objectMapper.writeValueAsString(nodes);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
