package com.example.webcosmetic.Servlet;


import com.example.webcosmetic.Drive.GoogleDrive;
import com.example.webcosmetic.EntityDB.*;
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
        Product product;
        if (action.equals("add")) {
            product = new Product();
            setProductAttributes(product, req);
            setProductImages(product, req);
            addDetailProduct(product, req);
            ProductDB.insert(product);
        } else {
            Long idProduct = Long.parseLong(req.getParameter("idProduct"));
            product = ProductDB.select(idProduct);
            setProductAttributes(product, req);
            setProductImages(product, req);
            editDetailProduct(product, req);
            ProductDB.update(product);
        }
        String url = "product";
        resp.sendRedirect(url);
    }

    private void editDetailProduct(Product product, HttpServletRequest req) {

        // những detail đã bị xoá sẽ được lấy để xoá
        String[] detailRemove = req.getParameterValues("detailRemove");
        if (detailRemove!=null){
            for (var item : detailRemove) {
                Long idDetail = Long.parseLong(item);
                DetailProduct detailProduct = DetailProductDB.select(idDetail);
                DetailProductDB.delete(detailProduct);
            }
        }
        //lấy các detail sau khi được chỉnh sửa
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
                // nếu detail này kh bị xoá mà chỉ bị sửa thì, truy vấn nó lên sửa nó lại
                Long idDetail = Long.parseLong(idDetails[i]);
                detailProduct = DetailProductDB.select(idDetail);

                detailProduct.setUnit(units[i]);
                detailProduct.setPrice(price);
                detailProduct.setSale(isSale);
                detailProduct.setSalePrice(salePrice);
            }
            else {
                // detail vừa được thêm vào
                detailProduct = new DetailProduct(units[i], price, isSale, salePrice, product);
            }
            details.add(detailProduct);
        }
        product.setDetails(details);
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

        List<ProductImage> images = new ArrayList<>();
        for (String item : strImages) {
            if (item.startsWith("https://drive.google.com/uc?id=")) {
                images.add(new ProductImage(item));
            } else {
                String id = GoogleDrive.uploadImage(item).getId();
                images.add(new ProductImage("https://drive.google.com/uc?id=" + id));
            }
        }
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

        productCategory.addBrand(brand);

        product.setName(name);
        product.setOrigin(origin);
        product.setDescription(description);
        product.setBrand(brand);
        product.setProductCategory(productCategory);
        product.setSubCategory(subCategory);
    }

}
