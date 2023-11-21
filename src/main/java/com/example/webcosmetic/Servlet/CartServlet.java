package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.EntityDB.CartDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "cart", value = "/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("customer") == null) {
            resp.sendRedirect("login_customer.jsp");

        } else {
            String action = req.getParameter("action");
            String url = "/cart.jsp";
            if (action == null) {
                List<Cart> lineItems = CartDB.selectAll();
                req.setAttribute("lineItems", lineItems);
                getServletContext().getRequestDispatcher(url).forward(req, resp);
            } else if (action.equals("remove")) {
                Long id = Long.parseLong(req.getParameter("id"));
                Cart cart = CartDB.select(id);
                CartDB.delete(cart);
            }
            url = "cart";
            resp.sendRedirect(url);
        }
    }
}
