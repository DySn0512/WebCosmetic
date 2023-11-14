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

        String action = req.getParameter("action");
        String nameForm = req.getParameter("nameForm");
        String url = "/productcategory.jsp";
        if (action == null) {
            //
        } else if (action.equals("Thêm")) {
            String newName = req.getParameter("newName");
            if (nameForm.equals("category")){
                ProductCategory productCategory = new ProductCategory(newName);
                ProductCategoryDB.insert(productCategory);
            }
            else {
                Long idCategory =  Long.parseLong(req.getParameter("idCategory"));
                ProductCategory productCategory = ProductCategoryDB.select(idCategory);
                productCategory.addSubCategory(new SubCategory(newName));
                ProductCategoryDB.update(productCategory);
            }
        }
        else if (action.equals("Lưu")) {
            String newName = req.getParameter("newName");
            Long id = Long.parseLong(req.getParameter("id"));
            if (nameForm.equals("category")){
                ProductCategory productCategory = ProductCategoryDB.select(id);
                productCategory.setName(newName);
                ProductCategoryDB.update(productCategory);
            }
            else {
                SubCategory subCategory = SubCategoryDB.select(id);
                subCategory.setName(newName);
                SubCategoryDB.update(subCategory);
            }

        } else if (action.equals("Xoá")) {
            Long id = Long.parseLong(req.getParameter("id"));
            if (nameForm.equals("category")){
                ProductCategory productCategory = ProductCategoryDB.select(id);
                ProductCategoryDB.delete(productCategory);
            }
            else {
                Long idCategory =  Long.parseLong(req.getParameter("idCategory"));
                ProductCategory productCategory = ProductCategoryDB.select(idCategory);
                SubCategory subCategory = SubCategoryDB.select(id);
                productCategory.removeSubCategory(subCategory);
                ProductCategoryDB.update(productCategory);
            }
        }
        List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
        req.setAttribute("productCategories", productCategories);
        getServletContext().getRequestDispatcher(url).forward(req, resp);

    }
}
