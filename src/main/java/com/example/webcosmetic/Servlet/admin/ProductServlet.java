package com.example.webcosmetic.Servlet.admin;


import com.example.webcosmetic.Entity.Brand;
import com.example.webcosmetic.Entity.Product;
import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.EntityDB.BrandDB;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.ProductDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "product", value = "/admin/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.equals("null")) {
            showProduct(req);
            getServletContext().getRequestDispatcher("/admin/product.jsp").forward(req, resp);
        } else if (action.equals("find")) {

        } else if (action.equals("remove")) {
            deleteProducts(req);
            resp.sendRedirect("product");
        } else {

            List<Brand> brands = BrandDB.selectAll();
            req.setAttribute("brands", brands);
            List<ProductCategory> productCategories = ProductCategoryDB.selectAll();
            req.setAttribute("productCategories", productCategories);

            if (action.equals("add")) {
                req.setAttribute("ariacurrent", "Thêm Sản Phẩm");
            } else {
                Long id = Long.parseLong(req.getParameter("id"));
                Product product = ProductDB.select(id);
                req.setAttribute("product", product);
                req.setAttribute("ariacurrent", "Sửa Sản Phẩm");
            }
            getServletContext().getRequestDispatcher("/admin/product_info.jsp").forward(req, resp);
        }
    }

    private void showProduct(HttpServletRequest req) {
        List<Product> products = ProductDB.selectAll();
        req.setAttribute("products", products);
    }

    private void deleteProducts(HttpServletRequest req) {
        String[] ids = req.getParameterValues("id");
        if (ids != null) {
            for (var item : ids) {
                Long id = Long.parseLong(item);
                Product product = ProductDB.select(id);
                ProductDB.delete(product);
            }
        }
    }

}
