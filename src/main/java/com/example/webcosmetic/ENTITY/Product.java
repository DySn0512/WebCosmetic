package com.example.webcosmetic.ENTITY;

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

    @ManyToMany
    private List<KeyWord> keyWords;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailProduct> detailProducts;

    public Product() {

    }

    public Product(String name, String origin, String description, Brand brand, ProductCategory productCategory, SubCategory subCategory) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.brand = brand;
        this.productCategory = productCategory;
        this.subCategory = subCategory;
        this.images = new ArrayList<>();
        this.keyWords = new ArrayList<>();
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

    public List<KeyWord> getKeyWords() {
        return keyWords;
    }

    public List<DetailProduct> getDetailProducts() {
        return detailProducts;
    }

    public void addImage(ProductImage image) {
        images.add(image);
    }

    public void removeImage(ProductImage image) {
        images.removeIf(img -> img.getId().equals(image.getId()));
    }

    public Boolean addKeyWord(KeyWord keyWord) {
        if (!keyWords.contains(keyWord)) {
            keyWords.add(keyWord);
            return true;
        }
        return false;
    }

    public void removeKeyWord(KeyWord keyWord) {
        keyWords.removeIf(kw -> kw.getId().equals(keyWord.getId()));
    }

    public Boolean addDetail(DetailProduct detailProduct) {
        if (detailProducts.stream().noneMatch(dp -> dp.getUnit().equals(detailProduct.getUnit()))){
            detailProducts.add(detailProduct);
            return true;
        }
        return false;
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
