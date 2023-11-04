package com.example.webcosmetic.ENTITY;
import jakarta.persistence.*;
@Entity
public class LineItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @OneToOne
    private DetailProduct detailProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DetailProduct getDetailProduct() {
        return detailProduct;
    }

    public Double getTotal(){
        return detailProduct.getCurrentPrice()*quantity;
    }
}
