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
        List<LineItem> lineItems = new ArrayList<>();
        if (action.equals("create")) {
            String[] idLineItems = req.getParameterValues("idLineItem");
            if (idLineItems != null) {
                List<String> ids = List.of(idLineItems);

                for (LineItem item : cart.getLineItems()) {
                    if (ids.contains(item.getId().toString())) {
                        lineItems.add(item);
                    }
                }

            }
            session.setAttribute("lineItems", lineItems);
            getServletContext().getRequestDispatcher("/order.jsp").forward(req, resp);

        } else if (action.equals("add")) {
            Order order = new Order(phone,address,customer,lineItems);
            OrderDB.insert(order);
            resp.sendRedirect("/checkout.jsp");
        } else {
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }

    }
}
