package com.example.webcosmetic.Authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Login", value = "/view/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/view/login.html";


        String phoneNumber = (String) req.getParameter("phonenumber");
        String password = (String) req.getParameter("userPassword");

        System.out.println(phoneNumber);
        System.out.println(password);


        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
