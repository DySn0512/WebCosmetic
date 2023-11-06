package com.example.webcosmetic.ENTITY;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<LineItem> lineItems;

    public Cart() {

    }

    public Cart(Customer customer) {
        this.customer = customer;
        lineItems = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public int Count() {
        return lineItems.size();
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.stream()
                .filter(item -> item.getDetailProduct().getId().equals(lineItem.getDetailProduct().getId()))
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantity(item.getQuantity() + 1),
                        () -> lineItems.add(lineItem)
                );
    }

    public void removeLineItem(LineItem lineItem) {
        lineItems.removeIf(item -> item.getId().equals(lineItem.getId()));
    }

}
