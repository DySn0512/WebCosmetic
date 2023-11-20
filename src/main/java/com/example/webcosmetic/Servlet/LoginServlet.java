package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.EntityDB.AccountDB;
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
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            Account account = AccountDB.select(userName, password);
            if (account != null && account.getRole().equals("admin")) {
                HttpSession session = req.getSession();
                session.setAttribute("admin", account.getUser());
                getServletContext().getRequestDispatcher("/admin").forward(req, resp);
            } else {
                req.setAttribute("message", "tài khoản không hợp lệ");
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        } else {
            // của người dùng nè
        }
    }

}
