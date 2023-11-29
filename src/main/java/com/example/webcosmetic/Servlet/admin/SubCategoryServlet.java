package com.example.webcosmetic.Servlet.admin;

import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.Entity.SubCategory;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.SubCategoryDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "subcategory", value = "/admin/subcategory")
public class SubCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "category";
        if (action.equals("update")) {
            updateSubCategory(req, resp);
        } else {
            Long idCategory = Long.parseLong(req.getParameter("idCategory"));
            ProductCategory productCategory = ProductCategoryDB.select(idCategory);
            if (action.equals("add")) {
                addSubCategory(req, productCategory);
            } else if (action.equals("remove")) {
                removeSubCategory(req, productCategory);
            }
            try {
                ProductCategoryDB.update(productCategory);
            } catch (Exception e) {
                url = "error.html";
            }
        }


        resp.sendRedirect(url);
    }

    private void updateSubCategory(HttpServletRequest req, HttpServletResponse resp) {
        String newName = req.getParameter("newName");
        Long id = Long.parseLong(req.getParameter("id"));
        SubCategory subCategory = SubCategoryDB.select(id);
        subCategory.setName(newName);
        SubCategoryDB.update(subCategory);
    }

    private void addSubCategory(HttpServletRequest req, ProductCategory productCategory) {
        String newName = req.getParameter("newName");
        SubCategory subCategory = new SubCategory(newName);
        productCategory.addSubCategory(subCategory);
    }

    private void removeSubCategory(HttpServletRequest req, ProductCategory productCategory) {
        Long id = Long.parseLong(req.getParameter("id"));
        SubCategory subCategory = SubCategoryDB.select(id);
        productCategory.removeSubCategory(subCategory);
    }


}
