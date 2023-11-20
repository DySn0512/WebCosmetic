package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.EntityDB.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("admin")) {
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            User user = UserDB.select(phone, password);
            if (user != null && user.getRole().equals("admin")) {
                HttpSession session = req.getSession();
                session.setAttribute("admin", user);
                getServletContext().getRequestDispatcher("/admin").forward(req, resp);
            } else {
                req.setAttribute("message", "Tài khoản không hợp lệ");
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        } else {
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            User user = UserDB.select(phone, password);
            if (user != null && user.getRole().equals("customer")) {
                HttpSession session = req.getSession();
                session.setAttribute("customer", user);
                getServletContext().getRequestDispatcher("/customer").forward(req, resp);
            } else {
                req.setAttribute("message", "Tài khoản không hợp lệ");
                getServletContext().getRequestDispatcher("/login_customer.jsp").forward(req, resp);

            }

            // của người dùng nè
        }
    }

}
