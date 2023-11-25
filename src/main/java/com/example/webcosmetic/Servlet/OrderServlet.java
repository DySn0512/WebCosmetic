package com.example.webcosmetic.Servlet;

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
        if (action.equals("create")) {
            List<LineItem> lineItems = new ArrayList<>();
            String[] idLineItems = req.getParameterValues("idLineItem");
            if (idLineItems != null) {
                for (var id : idLineItems) {
                    long idLineItem = Long.parseLong(id);
                    LineItem lineItem = LineItemDB.select(idLineItem);
                    lineItems.add(lineItem);
                }
                req.setAttribute("lineItems", lineItems);
                getServletContext().getRequestDispatcher("/order.jsp").forward(req, resp);
            }
            else{
                String referer = req.getHeader("referer");
                resp.sendRedirect(referer);
            }

        }
    }
}
