package com.example.webcosmetic.ENTITY;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {

    private String name;
    private String origin;
    private String description;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private ProductCategory productCategory;

    @ManyToOne
    private SubCategory subCategory;

    @OneToMany
    private List<ProductImage> images;

    @ManyToMany
    private List<KeyWord> keywords;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    public Product() {
        // Hàm khởi tạo mặc định
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

    public List<KeyWord> getKeywords() {
        return keywords;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
