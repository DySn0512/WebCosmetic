package com.example.webcosmetic.Servlet;


import com.example.webcosmetic.EntityDB.BrandDB;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.SubCategoryDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.webcosmetic.Entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productInfo", value = "/productInfo")
public class ProductInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            String name = req.getParameter("name");
            String origin = req.getParameter("origin");
            String description = req.getParameter("description");
            Long idBrand = Long.parseLong(req.getParameter("brand"));
            Long idProductCategory = Long.parseLong(req.getParameter("productCategory"));
            Long idSubCategory = Long.parseLong(req.getParameter("subCategory"));
            String[] strImages = req.getParameterValues("strImage");
            Brand brand = BrandDB.select(idBrand);
            ProductCategory productCategory = ProductCategoryDB.select(idProductCategory);
            SubCategory subCategory = SubCategoryDB.select(idSubCategory);
            Product product = new Product(name, origin, description, brand, productCategory, subCategory);

            List<ProductImage> images = new ArrayList<>();
            for (var item : strImages) {
                ProductImage newimg = new ProductImage(item);
                images.add(newimg);
            }
            product.setImages(images);
            String[] units = req.getParameterValues("unit");
            String[] isSales = req.getParameterValues("isSale");
            String[] priceValues = req.getParameterValues("price");
            Double[] prices = new Double[priceValues.length];
            String[] priceSaleValues = req.getParameterValues("salePrice");
            Double[] salePrices = new Double[priceSaleValues.length];
            for (int i = 0; i < priceValues.length; i++) {
                prices[i] = Double.parseDouble(priceValues[i]);
                salePrices[i] = Double.parseDouble(priceSaleValues[i]);
            }

        }
    }
}
