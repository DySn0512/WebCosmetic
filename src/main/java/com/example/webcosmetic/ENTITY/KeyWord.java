package com.example.webcosmetic.ENTITY;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class KeyWord {

    @ManyToMany
    private List<Product> products;

    private String word;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public KeyWord() {
        // Hàm khởi tạo mặc định
    }

    public KeyWord(String word) {
        this.word = word;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
