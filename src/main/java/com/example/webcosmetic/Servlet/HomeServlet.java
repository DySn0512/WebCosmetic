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
import java.util.List;

@WebServlet(name = "home", value = "/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/Home.jsp";

        int currentPage = getCurrentPage(req);
        int recordsPerPage = 4;

        int offset = calculateOffset(currentPage, recordsPerPage);
        List<Product> products = ProductDB.selectProductsByOffset(offset, recordsPerPage);
        int totalProducts = ProductDB.getTotalProducts();

        int totalPages = calculateTotalPages(totalProducts, recordsPerPage);
        setRequestAttributes(req, products, currentPage, totalPages);
        setProductCategories(req);

        checkUser(req);
        req.setAttribute("find","home?page=");
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private void setRequestAttributes(HttpServletRequest req, List<Product> products, int currentPage, int totalPages) {
        req.setAttribute("products", products);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPages", totalPages);
    }

    private void setProductCategories(HttpServletRequest req) {
        List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
        req.setAttribute("productCategories", productCategories);
    }

    private int calculateTotalPages(int totalProducts, int recordsPerPage) {
        return (int) Math.ceil((double) totalProducts / recordsPerPage);
    }

    private int getCurrentPage(HttpServletRequest req) {
        int currentPage = 1;
        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        }
        return currentPage;
    }

    private int calculateOffset(int currentPage, int recordsPerPage) {
        return (currentPage - 1) * recordsPerPage;
    }

    private void checkUser(HttpServletRequest req) {
        HttpSession session = req.getSession();

        if (session.getAttribute("customer") == null) {
            Cookie[] cookies = req.getCookies();
            String userId = CookieUtil.getCookieValue(cookies, "userIdWebCosmetic");
            if (!userId.isEmpty()) {
                User customer = UserDB.select(Long.parseLong(userId));
                session.setAttribute("customer", customer);
                Cart cart = CartDB.select(customer);
                session.setAttribute("cart", cart);
            }
        }
    }
}
