package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

@Entity
public class DetailProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unit;

    private Long price;

    private Boolean isSale;

    private Long salePrice;


    @ManyToOne
    private Product product;

    public DetailProduct() {
    }

    public DetailProduct(String unit, Long price, Boolean isSale, Long salePrice, Product product) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getSale() {
        return isSale;
    }

    public void setSale(Boolean sale) {
        isSale = sale;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public Product getProduct() {
        return product;
    }

    public Long getCurrentPrice(){
        return isSale ? salePrice: price;
    }

}
