package com.example.webcosmetic.Servlet.admin;

import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "category", value = "/admin/category")
public class ProductCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            showProductCategories(req, resp);
        } else {
            if (action.equals("add")) {
                addProductCategory(req);
            } else {
                Long id = Long.parseLong(req.getParameter("id"));
                ProductCategory productCategory = ProductCategoryDB.select(id);
                if (action.equals("update")) {
                    updateProductCategory(req, productCategory);
                } else if(action.equals("remove")) {
                    removeProductCategory(productCategory);
                }
            }
            resp.sendRedirect("category");
        }
    }

    private void showProductCategories(HttpServletRequest req, ServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
        req.setAttribute("productCategories", productCategories);
        req.getRequestDispatcher("/admin/productcategory.jsp").forward(req, resp);

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
