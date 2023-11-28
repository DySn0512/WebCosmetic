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

@WebServlet(name = "user", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        User user = null;
        if (action.equals("repassword")) {
            String newPass = req.getParameter("password");
            user = (User) session.getAttribute("userRePassword");
            String otp = req.getParameter("otp");
            String otpRePassword = (String) session.getAttribute("otpRePassword");
            if (user != null && otp.equals(otpRePassword)) {
                user.setPassword(newPass);
                UserDB.update(user);
                resp.getWriter().write("login_customer.jsp");
            } else {
                resp.getWriter().write("OTP Không Hợp Lệ");
            }
        }
    }
}
