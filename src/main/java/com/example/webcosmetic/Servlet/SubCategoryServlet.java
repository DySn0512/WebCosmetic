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

@WebServlet(name = "subcategory", value = "/subcategory")
public class SubCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect("login.jsp");

        }else{
            String action = req.getParameter("action");
            if (action.equals("update")) {
                String newName = req.getParameter("newName");
                Long id = Long.parseLong(req.getParameter("id"));
                SubCategory subCategory = SubCategoryDB.select(id);
                subCategory.setName(newName);
                SubCategoryDB.update(subCategory);
            } else {
                Long idCategory = Long.parseLong(req.getParameter("idCategory"));
                ProductCategory productCategory = ProductCategoryDB.select(idCategory);
                if (action.equals("add")) {
                    String newName = req.getParameter("newName");
                    SubCategory subCategory = new SubCategory(newName);
                    productCategory.addSubCategory(subCategory);
                } else if(action.equals("remove")) {
                    Long id = Long.parseLong(req.getParameter("id"));
                    SubCategory subCategory = SubCategoryDB.select(id);
                    productCategory.removeSubCategory(subCategory);
                }
                ProductCategoryDB.update(productCategory);
            }
            String url = "category";
            resp.sendRedirect(url);
        }

    }
}
