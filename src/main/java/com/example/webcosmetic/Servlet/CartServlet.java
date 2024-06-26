package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.DetailProduct;
import com.example.webcosmetic.Entity.LineItem;
import com.example.webcosmetic.EntityDB.CartDB;
import com.example.webcosmetic.EntityDB.DetailProductDB;
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
        if (session == null || session.getAttribute("customer") == null) {
            resp.sendRedirect("login_customer.jsp");
            return;
        }

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
        String referer = req.getHeader("referer");
        resp.sendRedirect(referer);
    }

    private void addToCart(HttpServletRequest req, Cart cart) {
        Long idDetailProduct = Long.parseLong(req.getParameter("idDetail"));
        String quantityStr = req.getParameter("quantity");
        if (quantityStr == null || quantityStr.isEmpty()) {
            quantityStr = "1";
        }
        int quantity = Integer.parseInt(quantityStr);
        DetailProduct detailProduct = DetailProductDB.select(idDetailProduct);
        LineItem lineItem = new LineItem(detailProduct, quantity);
        cart.addLineItem(lineItem);
    }

    private void removeLineItem(HttpServletRequest req, Cart cart) {
        String[] idDetailProducts = req.getParameterValues("idDetailProduct");
        List<DetailProduct> detailProducts = idDetailProducts == null ? Collections.emptyList() : Arrays.stream(idDetailProducts)
                .map(id -> {
                    DetailProduct detailProduct = new DetailProduct();
                    detailProduct.setId(Long.parseLong(id));
                    return detailProduct;
                }).collect(Collectors.toList());
        cart.removeByDetailProduct(detailProducts);
    }

    private void updateCart(HttpServletRequest req, Cart cart) {
        Long idDetailProduct = Long.parseLong(req.getParameter("idDetailProduct"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        cart.update(idDetailProduct, quantity);
    }

}
///

