package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.EntityDB.UserDB;
import com.example.webcosmetic.EntityDB.CartDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eclipse.persistence.internal.oxm.TreeObjectBuilder;

import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String otp = req.getParameter("otp");
        HttpSession session = req.getSession();
        String otpRegister = (String)session.getAttribute("otpRegister");
        if (otpRegister!=null && otp.equals(otpRegister)) {
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            String password = req.getParameter("password");
            User user = new User(name, phone, email, address, password);
            Cart cart = new Cart(user);
            try {
                UserDB.insert(user);
                CartDB.insert(cart);
                resp.getWriter().write("login_customer.jsp");
            } catch (Exception e) {
                resp.getWriter().write("Mail hoặc số điện thoại của bạn đã được sử dụng.");
            }
        }else{
            resp.getWriter().write("OTP Không Hợp Lệ");
        }

    }
}
