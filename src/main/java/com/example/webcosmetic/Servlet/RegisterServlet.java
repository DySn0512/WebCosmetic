package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.EntityDB.AccountDB;
import com.example.webcosmetic.EntityDB.UserDB;
import com.example.webcosmetic.EntityDB.CartDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        User user = new User(name,phone,email,address);
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Account account = new Account(userName,password,user);
        Cart cart = new Cart(user);
        UserDB.insert(user);
        CartDB.insert(cart);
        AccountDB.insert(account);


    }
}
