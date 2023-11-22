package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.EntityDB.CartDB;
import com.example.webcosmetic.EntityDB.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        User user = UserDB.select(phone, password);
<<<<<<< HEAD
        HttpSession session = req.getSession();
=======
>>>>>>> e2605833722672ac44fdd13960f3e1a8cc615551
        if (action.equals("admin")) {
            if (user != null && user.getRole().equals("admin")) {
                session.setAttribute("admin", user);
                getServletContext().getRequestDispatcher("/admin").forward(req, resp);
            } else {
                req.setAttribute("message", "Tài khoản không hợp lệ");
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else {
            if (user != null && user.getRole().equals("customer")) {
                String savedPassword = req.getParameter("savedPassword");
                if (savedPassword != null) {
                    Cookie c = new Cookie("userIdWebCosmetic", user.getId().toString());
                    c.setMaxAge(60);
                    c.setPath("/");
                    resp.addCookie(c);
                } else {
                    session.setAttribute("customer", user);
                    Cart cart = CartDB.select(user);
                    session.setAttribute("cart", cart);
                }
                resp.sendRedirect("home");

            } else {
                req.setAttribute("message", "Tài khoản không hợp lệ");
                getServletContext().getRequestDispatcher("/login_customer.jsp").forward(req, resp);
            }
        }
    }

}
