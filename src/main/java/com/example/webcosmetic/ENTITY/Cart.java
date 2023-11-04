package com.example.webcosmetic.ENTITY;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    @OneToMany(orphanRemoval = true)
    private List<LineItem> lineItems;

    public Cart(){

    }

    public Cart(Customer customer) {
        this.customer = customer;
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
            if(item.getDetailProduct().getId() == lineItem.getDetailProduct().getId()){
                int newQuantity = item.getQuantity() + 1;
                item.setQuantity(newQuantity);
                return;
            }
        }
        lineItem.setQuantity(1);
        lineItems.add(lineItem);
    }

    public void removeLineItem(long lineItemId){
        for (int i = 0; i < lineItems.size(); i++) {
            if(lineItemId == lineItems.get(i).getId()){
                lineItems.remove(i);
                return;
            }
        }
    }

}
