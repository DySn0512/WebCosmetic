package com.example.webcosmetic.Servlet;


import com.example.webcosmetic.Entity.Brand;
import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.Entity.SubCategory;
import com.example.webcosmetic.EntityDB.BrandDB;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.SubCategoryDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "brand", value = "/brand")
public class BrandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/brand.jsp";

        if (action == null) {
            // đây là trường hợp servlet được gọi từ trang admin nên action nó là null nè
        } 
        else if (action.equals("Thêm")) {
            String newName = req.getParameter("newName");
            Brand brand = new Brand(newName);
            BrandDB.insert(brand);
        }
        else if (action.equals("Xoá")) {
            Long id = Long.parseLong(req.getParameter("id"));
            Brand brand = BrandDB.select(id);
            BrandDB.delete(brand);
        }
        List<Brand> brands = BrandDB.selectAll();
        req.setAttribute("brands",brands) ;
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
