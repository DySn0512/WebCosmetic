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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "cart", value = "/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        Cart cart = (Cart) session.getAttribute("cart");

        if ("add".equals(action)) {
            addToCart(req, cart);
        } else if ("remove".equals(action)) {
            removeLineItem(req, cart);
        } else if ("update".equals(action)) {
            updateCart(req, cart);
        }

        CartDB.update(cart);
        cart = CartDB.select(cart.getId());
        session.setAttribute("cart", cart);
        String referer = req.getHeader("referer");
        resp.sendRedirect(referer);
    }

    private void addToCart(HttpServletRequest req, Cart cart) {
        Long idDetail = Long.parseLong(req.getParameter("idDetail"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        DetailProduct detailProduct = DetailProductDB.select(idDetail);
        LineItem lineItem = new LineItem(detailProduct, quantity);
        cart.addLineItem(lineItem);
    }

    private void removeLineItem(HttpServletRequest req, Cart cart) {
        String[] idLineItems = req.getParameterValues("idLineItem");
        List<LineItem> lineItems = idLineItems != null ? Arrays.stream(idLineItems)
                .map(id -> {
                    LineItem lineItem = new LineItem();
                    lineItem.setId(Long.parseLong(id));
                    return lineItem;
                }).collect(Collectors.toList()) : Collections.emptyList();
        cart.removeLineItems(lineItems);

    }

    private void updateCart(HttpServletRequest req, Cart cart) {
        Long idLineItem = Long.parseLong(req.getParameter("idLineItem"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        LineItem lineItem = LineItemDB.select(idLineItem);
        lineItem.setQuantity(quantity);
        cart.updateLineItem(lineItem);
    }
}
