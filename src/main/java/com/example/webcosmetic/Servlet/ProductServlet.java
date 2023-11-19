package com.example.webcosmetic.Servlet;


import com.example.webcosmetic.Entity.*;
import com.example.webcosmetic.EntityDB.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jdk.jfr.Registered;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        String action = req.getParameter("action");
        String url;
        if (action == null || action.equals("null")) {
            List<Product> products = ProductDB.selectAll();
            req.setAttribute("products", products);
            url = "/product.jsp";
            getServletContext().getRequestDispatcher(url).forward(req, resp);
        } else if (action.equals("Tìm")) {

        } else if (action.equals("remove")) {
            String[] ids = req.getParameterValues("id");
            for (var item : ids) {
                Long id = Long.parseLong(item);
                Product product = ProductDB.select(id);
                ProductDB.delete(product);
            }
            url = "product";
            resp.sendRedirect(url);
        } else {
            List<Brand> brands = BrandDB.selectAll();
            req.setAttribute("brands", brands);
            List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
            req.setAttribute("productCategories", productCategories);
            if (action.equals("add")) {
                req.setAttribute("ariacurrent", "Thêm Sản Phẩm");
            } else {
                Long id = Long.parseLong(req.getParameter("id"));
                Product product = ProductDB.select(id);
                req.setAttribute("product", product);
                req.setAttribute("ariacurrent", "Sửa Sản Phẩm");
            }
            url = "/product_info.jsp";
            getServletContext().getRequestDispatcher(url).forward(req, resp);
        }

    }
}
