package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

import java.util.Locale;

public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;

    private Integer quantity;

    private String unit;

    private Double price;

    @ManyToOne
    private Product product;

    public DetailOrder() {
    }

    public DetailOrder(String nameProduct, Integer quantity, String unit, Double price, Product product) {
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }


}
