package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.Entity.SubCategory;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.SubCategoryDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "category", value = "/category")
public class ProductCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect("login.jsp");
        } else {
            String action = req.getParameter("action");
            String url;
            if (action == null) {
                showProductCategories(req);
                getServletContext().getRequestDispatcher("/productcategory.jsp").forward(req, resp);
            } else {
                if (action.equals("add")) {
                    addProductCategory(req);
                } else {
                    Long id = Long.parseLong(req.getParameter("id"));
                    ProductCategory productCategory = ProductCategoryDB.select(id);
                    if (action.equals("update")) {
                        updateProductCategory(req, productCategory);
                    } else {
                        removeProductCategory(productCategory);
                    }
                }
                url = "category";
                resp.sendRedirect(url);
            }
        }

    }

    private void showProductCategories(HttpServletRequest req) {
        List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
        req.setAttribute("productCategories", productCategories);
    }

    private void addProductCategory(HttpServletRequest req) {
        String newName = req.getParameter("newName");
        ProductCategory productCategory = new ProductCategory(newName);
        ProductCategoryDB.insert(productCategory);
    }

    private void updateProductCategory(HttpServletRequest req, ProductCategory productCategory) {
        String newName = req.getParameter("newName");
        productCategory.setName(newName);
        ProductCategoryDB.update(productCategory);
    }

    private void removeProductCategory(ProductCategory productCategory) {
        ProductCategoryDB.delete(productCategory);
    }

}
