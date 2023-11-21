package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.Product;
import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.EntityDB.CartDB;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.ProductDB;
import com.example.webcosmetic.EntityDB.UserDB;
import com.example.webcosmetic.Util.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "home", value = "/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/Home.jsp";
        int currentPage = 1; // Trang hiện tại
        int recordsPerPage = 4; // Số lượng sản phẩm trên mỗi trang

        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        }

        int offset = (currentPage - 1) * recordsPerPage;

        List<Product> products = ProductDB.selectProductsByOffset(offset, recordsPerPage);
        int totalProducts = ProductDB.getTotalProducts(); // Tổng số sản phẩm

        int totalPages = (int) Math.ceil((double) totalProducts / recordsPerPage);

        req.setAttribute("products", products);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPages", totalPages);

        List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
        req.setAttribute("productCategories", productCategories);

        Cookie[] cookies = req.getCookies();
        String userId = CookieUtil.getCookieValue(cookies, "userIdWebCosmetic");

        if (!userId.isEmpty()){
            HttpSession session = req.getSession();
            User customer = UserDB.select(Long.parseLong(userId));
            session.setAttribute("customer", customer);
            Cart cart = CartDB.select(customer);
            session.setAttribute("cart",cart);
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
