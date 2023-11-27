package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

import java.util.Locale;

@Entity
public class DetailOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;

    private int quantity;

    private String unit;

    private Long price;

    public DetailOrder() {
    }

    public DetailOrder(String nameProduct, int quantity, String unit, Long price) {
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public Long getPrice() {
        return price;
    }

}
