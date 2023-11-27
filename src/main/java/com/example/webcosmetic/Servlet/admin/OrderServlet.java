package com.example.webcosmetic.Servlet.admin;

import com.example.webcosmetic.Entity.Order;
import com.example.webcosmetic.EntityDB.OrderDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "order", value = "/admin/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = OrderDB.selectAll();
        req.setAttribute("orders",orders);
        getServletContext().getRequestDispatcher("/admin/order.jsp").forward(req, resp);
    }
}
