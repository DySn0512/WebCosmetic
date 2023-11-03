package com.example.webcosmetic.ENTITY;
import jakarta.persistence.*;
@Entity
public class LineItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private DetailProduct detailProduct;

    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DetailProduct getDetailProduct() {
        return detailProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal(){
        return detailProduct.getCurrent()*quantity;
    }
}
