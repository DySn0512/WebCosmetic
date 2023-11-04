package com.example.webcosmetic.ENTITY;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class KeyWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    @ManyToMany
    private List<Product> products;

    public KeyWord() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public KeyWord(String word) {
        this.word = word;
    }

    public List<Product> getProducts() {
        return products;
    }

}
