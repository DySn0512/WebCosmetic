package com.example.webcosmetic.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "category", value = "/category")
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/category.jsp";
        Map<String, List<String>> dataMap = new HashMap<>();
        dataMap.put("Nước hoa", Arrays.asList("Nước hoa nam", "Nước hoa nữ"));
        dataMap.put("Son môi", Arrays.asList("Son môi nam", "Son môi nữ"));
        req.setAttribute("dataMap", dataMap);
        if (action == null) {

        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);

    }
}
