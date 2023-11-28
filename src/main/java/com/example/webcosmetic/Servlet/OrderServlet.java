package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.Order;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.Entity.LineItem;
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
        User customer = (User) session.getAttribute("customer");
        Cart cart = (Cart) session.getAttribute("cart");

        if (action.equals("create")) {

            String[] idDetailProducts = req.getParameterValues("idDetailProduct");
            List<LineItem> lineItemsOrder = getSelectedLineItems(cart, idDetailProducts);

            if (!lineItemsOrder.isEmpty()) {
                session.setAttribute("lineItemsOrder", lineItemsOrder);
                req.getRequestDispatcher("/order.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getHeader("referer"));
            }

        } else if (action.equals("add")) {
            addOrder(req, resp, session, customer, cart);
        }

    }

    private void addOrder(HttpServletRequest req, HttpServletResponse resp, HttpSession session, User customer, Cart cart) throws ServletException, IOException {

        List<LineItem> lineItemsOrder = (List<LineItem>) session.getAttribute("lineItemsOrder");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Order order = new Order(phone, address, customer, lineItemsOrder);
        OrderDB.insert(order);
        cart.remove(lineItemsOrder);
        // Cập nhật lại Cart trong cơ sở dữ liệu
        CartDB.update(cart);

        // Xoá lineItems khỏi session
        session.removeAttribute("lineItems");
        req.getRequestDispatcher("/checkout.jsp").forward(req, resp);
    }

    private List<LineItem> getSelectedLineItems(Cart cart, String[] selectedIds) {
        List<LineItem> lineItems = new ArrayList<>();
        if (selectedIds != null) {
            List<String> ids = List.of(selectedIds);

            for (LineItem item : cart.getLineItems()) {
                if (ids.contains(item.getDetailProduct().getId().toString())) {
                    lineItems.add(item);
                }
            }
        }
        return lineItems;
    }
}
