package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.DetailProduct;
import com.example.webcosmetic.Entity.LineItem;
import com.example.webcosmetic.EntityDB.CartDB;
import com.example.webcosmetic.EntityDB.DetailProductDB;
import com.example.webcosmetic.EntityDB.LineItemDB;
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
            Cart cart = (Cart) session.getAttribute("cart");
            if (action.equals("add")) {
                Long idDetail = Long.parseLong(req.getParameter("idDetail"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                DetailProduct detailProduct = DetailProductDB.select(idDetail);
                LineItem lineItem = new LineItem(detailProduct, quantity);
                cart.addLineItem(lineItem);
                String referer = req.getHeader("referer");
                session.setAttribute("successMessage", "true");
                resp.sendRedirect(referer);
            } else if (action.equals("remove")) {
                String[] idLineItems = req.getParameterValues("idLineItem");
                for (var id : idLineItems) {
                    long idLineItem = Long.parseLong(id);
                    LineItem lineItem = LineItemDB.select(idLineItem);
                    cart.removeLineItem(lineItem);
                }
            }
            CartDB.update(cart);
            cart = CartDB.select(cart.getId());
            session.setAttribute("cart",cart);
        }
    }
}
