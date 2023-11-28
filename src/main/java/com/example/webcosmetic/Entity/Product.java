package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String origin;

    @Column(length = 100000)
    private String description;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private ProductCategory productCategory;

    @ManyToOne
    private SubCategory subCategory;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<DetailProduct> details;

    public Product() {
        this.images = new ArrayList<>();
        this.details = new ArrayList<>();
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

    public List<DetailProduct> getDetails() {
        return details;
    }

    public void setDetails(List<DetailProduct> details) {
        this.details = new ArrayList<>();
        for (var item : details) {
            addDetail(item);
        }
    }

    public void addDetail(DetailProduct detailProduct) {
        if (details.stream().noneMatch(dp -> dp.getUnit().equals(detailProduct.getUnit()))){
            details.add(detailProduct);
        }
    }

    public String getPrice() {
        if (details.size() == 1) {
            return details.get(0).getCurrentPrice().toString();
        }
        LongSummaryStatistics stats = details.stream()
                .mapToLong(DetailProduct::getCurrentPrice)
                .summaryStatistics();
        Long minCurrentPrice = stats.getMin();
        Long maxCurrentPrice = stats.getMax();
        return minCurrentPrice + " - " + maxCurrentPrice;
    }

}
