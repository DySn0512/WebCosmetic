package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.Order;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.Entity.LineItem;
import com.example.webcosmetic.EntityDB.LineItemDB;
import com.example.webcosmetic.EntityDB.OrderDB;
import com.example.webcosmetic.EntityDB.CartDB;
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
        User customer = (User) session.getAttribute("customer");
        Cart cart = (Cart) session.getAttribute("cart");

        if (action.equals("create")) {
            String[] idLineItems = req.getParameterValues("idLineItem");
            List<LineItem> lineItems = new ArrayList<>();
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
            List<LineItem> lineItemsOrder = (List<LineItem>) session.getAttribute("lineItems");
            Order order = new Order(phone,address,customer,lineItemsOrder);
            OrderDB.insert(order);
            cart.removeLineItems(lineItemsOrder);
            // Cập nhật lại Cart trong cơ sở dữ liệu
            CartDB.update(cart);
            // Xoá lineItems khỏi session
            session.removeAttribute("lineItems");
            getServletContext().getRequestDispatcher("/checkout.jsp").forward(req, resp);
        } else {
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }

    }
}
