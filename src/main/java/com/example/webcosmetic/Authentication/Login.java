/*
package com.example.webcosmetic.Authentication;

import com.example.webcosmetic.Entity.Account;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.EntityDB.AccountDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "logIn", value = "/logIn")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("customer")) {
            String userName = req.getParameter("phone");
            String password = req.getParameter("password");
            Account account = AccountDB.select(userName, password);
            if (account != null) {
                User user = account.getUser();
                if (user.getAdmin()) {
                    HttpSession session = req.getSession();
                    session.setAttribute("customer", user);
                    getServletContext().getRequestDispatcher("/customer").forward(req, resp);
                }
            } else {
                req.setAttribute("message", "Có thể là tài khoản hoặc khẩu sai, bạn vui lòng đăng nhập lại");
                getServletContext().getRequestDispatcher("/login_customer.jsp").forward(req, resp);
            }

        }
    }
}
*/
