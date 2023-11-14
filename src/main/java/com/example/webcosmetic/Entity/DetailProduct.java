package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

@Entity
public class DetailProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unit;

    private Double price;

    private Boolean isSale;

    private Double salePrice;

    @ManyToOne
    private Product product;

    public DetailProduct() {
    }

    public DetailProduct(String unit, Double price, Boolean isSale, Double salePrice, Integer inventory, Product product) {
        this.unit = unit;
        this.price = price;
        this.isSale = isSale;
        this.salePrice = salePrice;
        this.product = product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getSale() {
        return isSale;
    }

    public void setSale(Boolean sale) {
        isSale = sale;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Product getProduct() {
        return product;
    }

    public Double getCurrentPrice(){
        return isSale?salePrice:price;
    }

}
