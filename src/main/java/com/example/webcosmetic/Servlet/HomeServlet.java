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
        checkUser(req);
        paginate(req);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private void paginate(HttpServletRequest req) {
        int currentPage = getCurrentPage(req);
        int recordsPerPage = 4;
        int offset = calculateOffset(currentPage, recordsPerPage);
        int totalProducts;
        List<Product> products;
        String categoryName = req.getParameter("category");
        String subCategoryName = req.getParameter("subcategory");
        String search = req.getParameter("search");
        req.setAttribute("search", search);
        if (categoryName != null) {
            products = ProductDB.selectProductsByOffsetCategory(offset, recordsPerPage, categoryName);
            totalProducts = ProductDB.getTotalProductsCategory(categoryName);
            req.setAttribute("find", "home?category=" + categoryName + "&page=");
        } else if (subCategoryName != null) {
            products = ProductDB.selectProductsByOffsetSubCategory(offset, recordsPerPage, subCategoryName);
            totalProducts = ProductDB.getTotalProductsSubCategory(subCategoryName);
            req.setAttribute("find", "home?subcategory=" + subCategoryName + "&page=");
        } else if (search != null) {
            products = ProductDB.selectProductsByOffsetSimilarName(offset, recordsPerPage, search);
            totalProducts = ProductDB.getTotalSimilarName(search);
            req.setAttribute("find", "home?search=" + search + "&page=");
        } else {
            products = ProductDB.selectProductsByOffset(offset, recordsPerPage);
            totalProducts = ProductDB.getTotalProducts();
            req.setAttribute("find", "home?page=");
        }
        int totalPages = calculateTotalPages(totalProducts, recordsPerPage);
        int startPage = 1;
        int endPage = totalPages;

        if (totalPages > 5) {
            int midPoint = 3; // Giữa 5 trang để hiển thị ở giữa
            startPage = currentPage - midPoint > 0 ? currentPage - midPoint : 1;
            endPage = Math.min(startPage + 4, totalPages);
        }

        setRequestAttributes(req, products, currentPage, totalPages,startPage,endPage);
    }

    private void setRequestAttributes(HttpServletRequest req, List<Product> products, int currentPage, int totalPages, int startPage, int endPage) {
        HttpSession session = req.getSession();
        if (session.getAttribute("productCategories") == null) {
            List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
            session.setAttribute("productCategories", productCategories);
        }
        req.setAttribute("startPage", startPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("products", products);
        req.setAttribute("totalPages", totalPages);
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
