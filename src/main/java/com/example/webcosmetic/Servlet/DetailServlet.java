package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Product;
import com.example.webcosmetic.EntityDB.ProductDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận thông tin sản phẩm từ URL
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("name");

        // Gọi phương thức để lấy thông tin sản phẩm dựa trên tên
        Product product = ProductDB.selectProductByName(productName);

        // Gửi thông tin sản phẩm lên trang detail.jsp
        request.setAttribute("product", product);
        request.getRequestDispatcher("detail.jsp").forward(request, response);

    }

}
