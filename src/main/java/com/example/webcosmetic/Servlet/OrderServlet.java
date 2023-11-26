package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.Order;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.Entity.LineItem;
import com.example.webcosmetic.EntityDB.LineItemDB;
import com.example.webcosmetic.EntityDB.OrderDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "order", value = "/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        User customer = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        if (action.equals("create")) {
            List<String> idLineItems = List.of(req.getParameterValues("idLineItem"));
            List<LineItem> lineItems = new ArrayList<>();
            for (LineItem item : cart.getLineItems()) {
                if (idLineItems.contains(item.getId().toString())) {
                    lineItems.add(item);
                }
            }
        } else {
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }

    }
}
