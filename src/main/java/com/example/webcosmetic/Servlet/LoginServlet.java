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
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = UserDB.select(email, password);
        HttpSession session = req.getSession();

        if ("admin".equals(action)) {
            AdminLogin(user, email, password, session, resp, req);
        } else {
            CustomerLogin(user, email, password, session, resp, req);
        }
    }

    private void AdminLogin(User user, String email, String password, HttpSession session, HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException {
        if (user != null && "admin".equals(user.getRole())) {
            session.setAttribute("admin", user);
            resp.sendRedirect("admin/admin");
        } else {
            setLoginErrorAttributes(req, email, password);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    private void CustomerLogin(User user, String email, String password, HttpSession session, HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException {
        if (user != null && "customer".equals(user.getRole())) {
            String savedPassword = req.getParameter("savedPassword");
            if (savedPassword != null) {
                addUserIdCookie(user, resp);
            }
            session.setAttribute("customer", user);
            Cart cart = CartDB.select(user);
            session.setAttribute("cart", cart);
            resp.sendRedirect("home");
        } else {
            setLoginErrorAttributes(req, email, password);
            getServletContext().getRequestDispatcher("/login_customer.jsp").forward(req, resp);
        }
    }

    private void setLoginErrorAttributes(HttpServletRequest req, String email, String password) {
        req.setAttribute("message", "Tài Khoản Không Hợp Lệ");
        req.setAttribute("email", email);
        req.setAttribute("password", password);
    }

    private void addUserIdCookie(User user, HttpServletResponse resp) {
        Cookie userIdCookie = new Cookie("userIdWebCosmetic", user.getId().toString());
        userIdCookie.setMaxAge(60000);
        userIdCookie.setPath("/");
        resp.addCookie(userIdCookie);
    }

}
