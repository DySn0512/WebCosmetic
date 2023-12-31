package com.example.webcosmetic.Entity;
import jakarta.persistence.*;

@Entity
public class LineItem {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    @ManyToOne
    private DetailProduct detailProduct;

    public LineItem() {
    }

    public LineItem(DetailProduct detailProduct, int quantity) {
        this.detailProduct = detailProduct;
        this.quantity = quantity;
    }

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

    public Long getTotal(){
        return detailProduct.getCurrentPrice()*quantity;
    }

}
