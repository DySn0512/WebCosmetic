package com.example.webcosmetic.Entity;

import jakarta.persistence.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;


    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<DetailOrder> details;

    public Order(List<DetailOrder> details, DateTime timeOrder) {
        this.details = details;
    }

    public Order(Customer customer){
        this.customer = customer;
        details = new ArrayList<>();
    }

    public Order() {

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public List<DetailOrder> getdetails(){
        return details;
    }

    public int Count(){
        return details.size();
    }

    public List<DetailOrder> detailOrders = new ArrayList<>();

    public List<DetailOrder> getDetailOrders() {
        return detailOrders;
    }

    public void setDetailOrders(List<DetailOrder> detailOrders) {
        this.detailOrders = detailOrders;
    }



}
