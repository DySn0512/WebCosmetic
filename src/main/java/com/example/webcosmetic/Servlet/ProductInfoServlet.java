package com.example.webcosmetic.Servlet;


import com.example.webcosmetic.Drive.GoogleDrive;
import com.example.webcosmetic.EntityDB.BrandDB;
import com.example.webcosmetic.EntityDB.ProductCategoryDB;
import com.example.webcosmetic.EntityDB.ProductDB;
import com.example.webcosmetic.EntityDB.SubCategoryDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.webcosmetic.Entity.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "productInfo", value = "/admin/productInfo")
public class ProductInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        String[] units = req.getParameterValues("unit");
        String[] isSaleValues = req.getParameterValues("isSale");
        String[] priceValues = req.getParameterValues("price");
        String[] priceSaleValues = req.getParameterValues("salePrice");
        Product product;
        if (action.equals("add")) {
            product = new Product();
            setProductAttributes(product, req, resp);
            for (int i = 0; i < priceValues.length; i++) {
                Double price = Double.parseDouble(priceValues[i]);
                Boolean isSale = Boolean.parseBoolean(isSaleValues[i]);
                double salePrice = isSale ? Double.parseDouble(priceSaleValues[i]) : 0D;
                DetailProduct detailProduct = new DetailProduct(units[i], price, isSale, salePrice, product);
                product.addDetail(detailProduct);
            }
            ProductDB.insert(product);
        } else {
            String[] idDetails = req.getParameterValues("idDetail");
            Long idProduct = Long.parseLong(req.getParameter("idProduct"));
            product = ProductDB.select(idProduct);
            String[] imageRemove = req.getParameterValues("imageRemove");
            for (var item :imageRemove) {
                try {
                    GoogleDrive.removeImage(item);
                } catch (GeneralSecurityException e) {
                    throw new RuntimeException(e);
                }
            }
            setProductAttributes(product, req, resp);
            ProductDB.update(product);
        }
    }

    private void setProductAttributes(Product product, HttpServletRequest req, HttpServletResponse resp) {

        String name = req.getParameter("name");
        String origin = req.getParameter("origin");
        String description = req.getParameter("description");
        Long idBrand = Long.parseLong(req.getParameter("brand"));
        Long idProductCategory = Long.parseLong(req.getParameter("productCategory"));
        Long idSubCategory = Long.parseLong(req.getParameter("subCategory"));
        Brand brand = BrandDB.select(idBrand);
        ProductCategory productCategory = ProductCategoryDB.select(idProductCategory);
        SubCategory subCategory = SubCategoryDB.select(idSubCategory);

        String[] strImages = req.getParameterValues("strImage");

        List<ProductImage> images = new ArrayList<>();
        for (String item : strImages) {
            if (item.startsWith("https://drive.google.com/uc?id=")){
                images.add(new ProductImage(item));
            }
            else {
                try {
                    String id = GoogleDrive.uploadImage(item).getId();
                    images.add(new ProductImage("https://drive.google.com/uc?id=" + id));
                } catch (IOException | GeneralSecurityException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        product.setName(name);
        product.setOrigin(origin);
        product.setDescription(description);
        product.setBrand(brand);
        product.setProductCategory(productCategory);
        product.setSubCategory(subCategory);
        product.setImages(images);
    }

}
