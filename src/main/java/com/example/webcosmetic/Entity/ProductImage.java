package com.example.webcosmetic.Entity;
import jakarta.persistence.*;
@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String link;

    public ProductImage() {

    }

    public ProductImage( String link) {
        this.link = link;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String image) {
        this.link = image;
    }

}
