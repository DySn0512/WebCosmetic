package com.example.webcosmetic.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        String requestURI = req.getRequestURI();

        if (session == null || session.getAttribute("admin") == null) {
            String redirectPath = "login.jsp";
            if (requestURI.contains("/admin/")) {
                redirectPath = "../login.jsp";
            }
            resp.sendRedirect(redirectPath);
        } else {
            chain.doFilter(request, response);
        }
    }

}
