package com.example.webcosmetic.Servlet.admin;


import com.example.webcosmetic.Entity.Brand;
import com.example.webcosmetic.Entity.Product;
import com.example.webcosmetic.Entity.ProductCategory;
import com.example.webcosmetic.EntityDB.BrandDB;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.ProductDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

        if (action == null || action.equals("find")) {
            List<Brand> brands = BrandDB.selectAll();
            req.setAttribute("brands", brands);
            List<ProductCategory> categories = ProductCategoryDB.selectAll();
            req.setAttribute("categories", categories);
            findProduct(req, resp);
        } else if (action.equals("remove")) {
            deleteProducts(req);
            resp.sendRedirect("product");
        } else {
            if (action.equals("add")) {
                req.setAttribute("ariacurrent", "Thêm Sản Phẩm");
            } else {
                Long id = Long.parseLong(req.getParameter("id"));
                Product product = ProductDB.select(id);
                req.setAttribute("product", product);
                req.setAttribute("ariacurrent", "Sửa Sản Phẩm");
            }
            List<Brand> brands = BrandDB.selectAll();
            req.setAttribute("brands", brands);
            List<ProductCategory> categories = ProductCategoryDB.selectAll();
            req.setAttribute("categories", categories);
            getServletContext().getRequestDispatcher("/admin/product_info.jsp").forward(req, resp);
        }
    }

    private void findProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String findBy = req.getParameter("findBy");
        String search = req.getParameter("search");
        String isSale = req.getParameter("isSale");
        List<Product> products = null;
        if (findBy == null) {
            products = ProductDB.selectAll();
        } else if (findBy.equals("name")) {
            products = ProductDB.selectProductBySimilarName(search);
        } else if (findBy.equals("brand")) {
            products = ProductDB.selectProductByBrand(search, isSale);
        } else if (findBy.equals("category")) {
            products = ProductDB.selectProductByCategory(search, isSale);
        } else if (findBy.equals("subCategory")) {
            products = ProductDB.selectProductBySubCategory(search, isSale);
        }
        showProduct(req, resp, products);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp, List<Product> products) throws ServletException, IOException {
        req.setAttribute("products", products);
        req.getRequestDispatcher("/admin/product.jsp").forward(req, resp);
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
