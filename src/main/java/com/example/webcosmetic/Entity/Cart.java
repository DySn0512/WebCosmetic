package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> lineItems;

    public Cart() {

    }

    public Cart(User user) {
        this.user = user;
        lineItems = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int Count() {
        return lineItems.size();
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.stream()
                .filter(item -> item.getDetailProduct().getId().equals(lineItem.getDetailProduct().getId()))
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantity(item.getQuantity() + lineItem.getQuantity()),
                        () -> lineItems.add(lineItem)
                );
    }

    public void remove(List<LineItem> itemRemoves) {
        lineItems.removeIf(item -> itemRemoves.stream()
                .anyMatch(itemRemove -> itemRemove.getDetailProduct().getId().equals(item.getDetailProduct().getId())));
    }
    public void removeByDetailProduct(List<DetailProduct> detailProducts ) {
        lineItems.removeIf(item -> detailProducts.stream()
                .anyMatch(itemRemove -> itemRemove.getId().equals(item.getDetailProduct().getId())));
    }

    public void update(Long idDetailProduct, int quantity){
        lineItems.stream()
                .filter(item -> item.getDetailProduct().getId().equals(idDetailProduct))
                .findFirst()
                .ifPresent(item -> item.setQuantity(quantity));
    }

}
