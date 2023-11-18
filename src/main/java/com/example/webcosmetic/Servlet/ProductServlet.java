package com.example.webcosmetic.Servlet;


import com.example.webcosmetic.Entity.*;
import com.example.webcosmetic.EntityDB.BrandDB;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.ProductDB;
import com.example.webcosmetic.EntityDB.SubCategoryDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Registered;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "product", value = "/admin/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/admin/product.jsp";
        if (action == null || action.equals("null")) {
            List<Product> products = ProductDB.selectAll();
            req.setAttribute("products", products);
        } else if (action.equals("Tìm")) {

        } else if (action.equals("Xoá")) {

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
            url = "/admin/product_info.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
