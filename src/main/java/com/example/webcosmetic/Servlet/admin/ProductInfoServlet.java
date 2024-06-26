package com.example.webcosmetic.Servlet.admin;


import com.example.webcosmetic.Entity.*;
import com.example.webcosmetic.EntityDB.*;
import com.example.webcosmetic.Util.CloudinaryUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
        Product product;
        String url = "product";
        if (action.equals("add")) {
            product = new Product();
            setProductAttributes(product, req);
            setProductImages(product, req);
            addDetailProduct(product, req);
            try {
                ProductDB.insert(product);
            } catch (Exception e) {
                url = "duplicate_error.jsp";
            }
        } else {
            Long idProduct = Long.parseLong(req.getParameter("idProduct"));
            product = ProductDB.select(idProduct);
            setProductAttributes(product, req);
            setProductImages(product, req);
            editDetailProduct(product, req);
            try {
                ProductDB.update(product);
            } catch (Exception e) {
                url = "duplicate_error.jsp";

            }
        }
        resp.sendRedirect(url);
    }


    private void editDetailProduct(Product product, HttpServletRequest req) {

        removeDetails(req);

        String[] idDetails = req.getParameterValues("idDetail");
        String[] units = req.getParameterValues("unit");
        String[] isSaleValues = req.getParameterValues("isSale");
        String[] priceValues = req.getParameterValues("price");
        String[] priceSaleValues = req.getParameterValues("salePrice");

        List<DetailProduct> details = new ArrayList<>();
        for (int i = 0; i < idDetails.length; i++) {
            Long price = Long.parseLong(priceValues[i]);
            Boolean isSale = Boolean.parseBoolean(isSaleValues[i]);
            Long salePrice = isSale ? Long.parseLong(priceSaleValues[i]) : 0L;
            DetailProduct detailProduct;
            if (!idDetails[i].isEmpty()) {

                Long idDetail = Long.parseLong(idDetails[i]);
                detailProduct = DetailProductDB.select(idDetail);

                detailProduct.setUnit(units[i]);
                detailProduct.setPrice(price);
                detailProduct.setSale(isSale);
                detailProduct.setSalePrice(salePrice);
            } else {
                detailProduct = new DetailProduct(units[i], price, isSale, salePrice, product);
            }
            details.add(detailProduct);
        }
        product.setDetails(details);
    }

    private void removeDetails(HttpServletRequest req) {
        String[] detailRemove = req.getParameterValues("detailRemove");

        if (detailRemove != null) {
            for (String detailId : detailRemove) {
                Long idDetail = Long.parseLong(detailId);
                DetailProduct detailProduct = DetailProductDB.select(idDetail);

                if (detailProduct != null) {
                    DetailProductDB.delete(detailProduct);
                }
            }
        }
    }

    private void addDetailProduct(Product product, HttpServletRequest req) {

        String[] units = req.getParameterValues("unit");
        String[] isSaleValues = req.getParameterValues("isSale");
        String[] priceValues = req.getParameterValues("price");
        String[] priceSaleValues = req.getParameterValues("salePrice");

        for (int i = 0; i < priceValues.length; i++) {
            Long price = Long.parseLong(priceValues[i]);
            Boolean isSale = Boolean.parseBoolean(isSaleValues[i]);
            Long salePrice = isSale ? Long.parseLong(priceSaleValues[i]) : 0L;
            DetailProduct detailProduct = new DetailProduct(units[i], price, isSale, salePrice, product);
            product.addDetail(detailProduct);
        }
    }

    private void setProductImages(Product product, HttpServletRequest req) {

        String[] strImages = req.getParameterValues("strImage");

        List<ProductImage> images = Arrays.stream(strImages)
                .map(item -> item.startsWith("http") ? new ProductImage(item) : new ProductImage(CloudinaryUtil.uploadImageToCloudinary(item)))
                .collect(Collectors.toList());

        product.setImages(images);

    }

    private void setProductAttributes(Product product, HttpServletRequest req) {

        String name = req.getParameter("name");
        String origin = req.getParameter("origin");
        String description = req.getParameter("description");

        Long idBrand = Long.parseLong(req.getParameter("brand"));
        Brand brand = BrandDB.select(idBrand);

        Long idProductCategory = Long.parseLong(req.getParameter("productCategory"));
        ProductCategory productCategory = ProductCategoryDB.select(idProductCategory);

        Long idSubCategory = Long.parseLong(req.getParameter("subCategory"));
        SubCategory subCategory = SubCategoryDB.select(idSubCategory);

        product.setName(name);
        product.setOrigin(origin);
        product.setDescription(description);
        product.setBrand(brand);
        product.setProductCategory(productCategory);
        product.setSubCategory(subCategory);
    }

}
