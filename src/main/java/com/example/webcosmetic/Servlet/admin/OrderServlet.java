package com.example.webcosmetic.Servlet.admin;

import com.example.webcosmetic.Entity.Order;
import com.example.webcosmetic.EntityDB.OrderDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "managerorder", value = "/admin/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String[] listStatus = {"Chờ xác nhận", "Đang giao", "Đã giao"};
        req.setAttribute("status", listStatus);
        String url = "/admin/order.jsp";
        if (action == null) {
            List<Order> orders = OrderDB.selectAll();
            req.setAttribute("orders", orders);
        } else {
            Long id = Long.parseLong(req.getParameter("id"));
            Order order = OrderDB.select(id);
            if (action.equals("update")) {
                String status = req.getParameter("status");
                order.setStatus(status);
                OrderDB.update(order);
            } else if (action.equals("show")) {
                req.setAttribute("order", order);
                url="/admin/order_info.jsp";
            }
        }
        req.getRequestDispatcher(url).forward(req, resp);

    }


}
