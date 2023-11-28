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
        if (action.equals("repassword")) {
            rePassword(req, resp, session);
        } else if (action.equals("update")) {
            updateUser(req, resp, session);
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        User customer = (User) session.getAttribute("customer");
        if (customer == null) {
            resp.sendRedirect("login_customer.jsp");
            return;
        }
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        customer.setName(name);
        customer.setPhone(phone);
        customer.setAddress(address);
        UserDB.update(customer);
        resp.sendRedirect("customer.jsp");
    }

    private void rePassword(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        String newPass = req.getParameter("password");
        User user = (User) session.getAttribute("userRePassword");
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
