package com.example.webcosmetic.ENTITY;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<LineItem> lineItems;

    public Cart(){

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

    public int Count(){
        return lineItems.size();
    }

    public void addLineItem(LineItem lineItem){
        for (var item :lineItems) {
            if(item.getDetailProduct().getId().equals(lineItem.getDetailProduct().getId())){
                int newQuantity = item.getQuantity() + 1;
                item.setQuantity(newQuantity);
                return;
            }
        }
        lineItems.add(lineItem);
    }

    public void removeLineItem(LineItem lineItem){
        for (int i = 0; i < lineItems.size(); i++) {
            if(lineItems.get(i).getId().equals(lineItem.getId())){
                lineItems.remove(i);
                return;
            }
        }
    }

}
