package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String origin;

    private String description;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private ProductCategory productCategory;

    @ManyToOne
    private SubCategory subCategory;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DetailProduct> detailProducts;

    public Product() {
        this.images = new ArrayList<>();
        this.detailProducts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public List<DetailProduct> getDetailProducts() {
        return detailProducts;
    }

    public void addDetail(DetailProduct detailProduct) {
        if (detailProducts.stream().noneMatch(dp -> dp.getUnit().equals(detailProduct.getUnit()))){
            detailProducts.add(detailProduct);
        }
    }

    public void removeDetail(DetailProduct detailProduct) {
        detailProducts.removeIf(dp -> dp.getId().equals(detailProduct.getId()));
    }

    public DetailProduct getDefaultDetail() {
        return detailProducts.get(0);
    }

    public String getPrice() {
        if (detailProducts.size() == 1) {
            return detailProducts.get(0).getCurrentPrice().toString();
        }
        DoubleSummaryStatistics stats = detailProducts.stream()
                .mapToDouble(DetailProduct::getCurrentPrice)
                .summaryStatistics();
        double minCurrentPrice = stats.getMin();
        double maxCurrentPrice = stats.getMax();
        return minCurrentPrice + " - " + maxCurrentPrice;
    }
}
