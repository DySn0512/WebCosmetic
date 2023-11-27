package com.example.webcosmetic.Entity;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "\"Order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private Date timeOrder;

    private String phone;

    private String address;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<DetailOrder> details;

    public Order() {

    }

    public Order(String phone, String address ,User user, List<LineItem> lineItems) {
        this.timeOrder = new Date();
        this.phone = phone;
        this.address = address;
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

    public String getTimeOrder() {
        SimpleDateFormat desiredFormat = new SimpleDateFormat("EEEE, dd'/'MM'/'yyyy 'lúc' HH:mm:ss", new Locale("vi", "VN"));
        desiredFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return desiredFormat.format(timeOrder);
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
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
            String nameProduct = item.getDetailProduct().getProduct().getName();
            this.details.add(new DetailOrder(nameProduct,quantity,unit,price));
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
