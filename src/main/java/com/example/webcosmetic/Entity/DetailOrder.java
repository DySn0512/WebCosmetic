package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

import java.util.Locale;

public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer quantity;

    private String unit;

    private Double price;

    @ManyToOne
    private Product product;

    public DetailOrder() {
    }

    public DetailOrder(String name, Integer quantity, String unit, Double price, Product product) {
        this.name = name;
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
        return name;
    }

    public void setNameProduct(String nameProduct) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
