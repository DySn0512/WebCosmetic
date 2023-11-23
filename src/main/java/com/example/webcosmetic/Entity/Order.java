package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "\"Order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private Date timeOrder;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<DetailOrder> details;

    public Order() {

    }

    public Order(Date timeOrder, User user, List<LineItem> lineItems) {
        this.timeOrder = timeOrder;
        this.user = user;
        this.status = "Chờ xác nhận";
        this.details = new ArrayList<>();
        setDetails(lineItems);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Date getTimeOrder() {
        return timeOrder;
    }

    public User getUser() {
        return user;
    }

    public List<DetailOrder> getDetails() {
        return details;
    }

    private void setDetails(List<LineItem> lineItems) {
        for (var item :lineItems) {
            String unit = item.getDetailProduct().getUnit();
            int quantity = item.getQuantity();
            Long price = item.getDetailProduct().getCurrentPrice();
            Product product = item.getDetailProduct().getProduct();
            String nameProduct = product.getName();
            this.details.add(new DetailOrder(nameProduct,quantity,unit,price,product));
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
