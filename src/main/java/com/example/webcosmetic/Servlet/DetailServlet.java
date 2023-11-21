package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Product;
import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.Entity.SubCategory;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.ProductDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "detail", value = "/detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("name");

        // Gọi phương thức để lấy thông tin sản phẩm dựa trên tên
        Product product = ProductDB.selectProductByName(productName);

        // Gửi thông tin sản phẩm lên trang detail.jsp
        request.setAttribute("product", product);
        List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
        request.setAttribute("productCategories", productCategories);



        // Gọi phương thức để lấy thông tin sản phẩm dựa trên tên
        Product productBread = ProductDB.selectProductByNameToGetBread(productName);

        // Truy cập ProductCategory và SubCategories của sản phẩm
        ProductCategory productCategoryBread = productBread.getProductCategory();
        SubCategory productSubBread = productBread.getSubCategory();

        // Gửi thông tin breadcrumb lên trang detail.jsp
        request.setAttribute("productBread", productBread);
        request.setAttribute("productCategoryBread", productCategoryBread);
        request.setAttribute("productSubBread", productSubBread);

        request.getRequestDispatcher("detail.jsp").forward(request, response);

    }

}
