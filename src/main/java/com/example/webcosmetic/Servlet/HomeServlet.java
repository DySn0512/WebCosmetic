package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Product;
import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.ProductDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "home", value = "/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/Home.jsp";
        int currentPage = 1; // Trang hiện tại
        int recordsPerPage = 4; // Số lượng sản phẩm trên mỗi trang

        if (request.getParameter("page") != null) {
            currentPage = Integer.parseInt(request.getParameter("page"));
        }

        int offset = (currentPage - 1) * recordsPerPage;

        List<Product> products = ProductDB.selectProductsByOffset(offset, recordsPerPage);
        int totalProducts = ProductDB.getTotalProducts(); // Tổng số sản phẩm

        int totalPages = (int) Math.ceil((double) totalProducts / recordsPerPage);

        request.setAttribute("products", products);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);



        List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
        request.setAttribute("productCategories", productCategories);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
