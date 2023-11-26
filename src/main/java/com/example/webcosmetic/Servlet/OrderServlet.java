package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.LineItem;
import com.example.webcosmetic.EntityDB.LineItemDB;
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
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (action.equals("create")) {
            String[] idLineItems = req.getParameterValues("idLineItem");
            List<Long> idList = new ArrayList<>();

            if (idLineItems != null) {
                for (String id : idLineItems) {
                    Long idLong = Long.valueOf(id);
                    idList.add(idLong);
                }
            }
            List<LineItem> cartLineItems = cart.getLineItems();//này là  list line item của cart
            List<LineItem> lineItems = new ArrayList<>(); //này là list chứa line item ng dùng chọn

            for (LineItem item : cartLineItems) {
                if (idList.contains(item.getId())) {
                    lineItems.add(item);
                }
            }
            req.setAttribute("lineItems", lineItems);
            getServletContext().getRequestDispatcher("/order.jsp").forward(req, resp);
        } else {
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }

    }
}
