package com.example.webcosmetic.ENTITY;
import jakarta.persistence.*;
@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String strImage;

    public ProductImage() {

    }

    public ProductImage( String image) {
        this.strImage = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return strImage;
    }

    public void setImage(String image) {
        this.strImage = image;
    }

}
