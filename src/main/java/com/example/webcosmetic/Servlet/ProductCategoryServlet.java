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

        }else{
            String action = req.getParameter("action");
            String url;
            if (action == null) {
                List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
                req.setAttribute("productCategories", productCategories);
                url = "/productcategory.jsp";
                getServletContext().getRequestDispatcher(url).forward(req, resp);
                return;
            }
            else if (action.equals("Thêm")) {
                String newName = req.getParameter("newName");
                ProductCategory productCategory = new ProductCategory(newName);
                ProductCategoryDB.insert(productCategory);
            } else if (action.equals("Lưu")) {
                String newName = req.getParameter("newName");
                Long id = Long.parseLong(req.getParameter("id"));
                ProductCategory productCategory = ProductCategoryDB.select(id);
                productCategory.setName(newName);
                ProductCategoryDB.update(productCategory);
            } else if (action.equals("Xoá")) {
                Long id = Long.parseLong(req.getParameter("id"));
                ProductCategory productCategory = ProductCategoryDB.select(id);
                ProductCategoryDB.delete(productCategory);
            }
            url = "category";
            resp.sendRedirect(url);
        }

    }

}
