package com.example.webcosmetic.ENTITY;

import jakarta.persistence.*;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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

    @OneToMany(orphanRemoval = true)
    private List<ProductImage> images;

    @OneToMany(orphanRemoval = true)
    private List<DetailProduct> detailProducts;

    public Product() {

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

    public void addImage(ProductImage image){
        images.add(image);
    }

    public void addKeyWord(KeyWord keyWord) {
        for (var value : keyWords) {
            if (value.getId().equals(keyWord.getId())) {
                return;
            }
        }
        keyWords.add(keyWord);
    }

    public void removeKeyWord(KeyWord keyWord) {
        for (int i = 0; i < keyWords.size(); i++) {
            if (keyWords.get(i).getId().equals(keyWord.getId())) {
                keyWords.remove(i);
                return;
            }

        }
    }

    public void addDetail(DetailProduct detailProduct) {
        for (var value : detailProducts) {
            if (value.getId().equals(detailProduct.getId())) {
                return;
            }
        }
        detailProducts.add(detailProduct);
    }

    public void removeDetail(DetailProduct detailProduct) {
        for (int i = 0; i < detailProducts.size(); i++) {
            if (detailProducts.get(i).getId().equals(detailProduct.getId())) {
                detailProducts.remove(i);
                return;
            }
        }
    }

    public DetailProduct getDefaultDetail(){
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
