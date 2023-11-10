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
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/product.jsp";
        if (action == null) {
        }
        else if (action.equals("Tìm")) {

        } else if (action.equals("Xoá")) {

        } else {
            List<Brand> brands = BrandDB.selectAll();
            req.setAttribute("brands",brands);
            req.setAttribute("ahih","bỏ");
            List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
            req.setAttribute("productCategories",productCategories);
            if (action.equals("add")) {
                req.setAttribute("ariacurrent","Thêm Sản Phẩm");
            }
            else{
                req.setAttribute("ariacurrent","Sửa Sản Phẩm");
            }
            url = "/product_info.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
