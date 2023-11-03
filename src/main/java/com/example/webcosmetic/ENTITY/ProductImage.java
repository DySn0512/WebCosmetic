package com.example.webcosmetic.ENTITY;
import jakarta.persistence.*;
@Entity
public class ProductImage {
    private String strImage;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ProductImage() {
        // Hàm khởi tạo mặc định
    }

    public ProductImage( String image) {
        this.strImage = image;
    }

    public String getImage() {
        return strImage;
    }

    public void setImage(String image) {
        this.strImage = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
