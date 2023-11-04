package com.example.webcosmetic.ENTITY;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Brand> brands;

    @OneToMany
    private List<SubCategory> subCategories;

    public ProductCategory() {

    }

    public ProductCategory(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

}

