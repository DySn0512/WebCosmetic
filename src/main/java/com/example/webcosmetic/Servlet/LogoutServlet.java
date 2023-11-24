package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.EntityDB.CartDB;
import com.example.webcosmetic.EntityDB.UserDB;
import com.example.webcosmetic.Util.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "logout", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // Lấy phiên hiện tại, nếu không tồn tại thì trả về null
        Cookie[] cookies = req.getCookies();
        CookieUtil.removeCookie(cookies, "userIdWebCosmetic");
        if (session != null && session.getAttribute("customer") != null) {
            session.invalidate(); // Xoá phiên (session)
        }
        resp.sendRedirect("home");
    }
}
