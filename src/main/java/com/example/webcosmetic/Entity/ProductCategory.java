package com.example.webcosmetic.Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Brand> brands;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<SubCategory> subCategories;

    public ProductCategory() {

    }

    public ProductCategory(String name) {
        this.name = name;
        subCategories = new ArrayList<>();
        brands = new ArrayList<>();
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

    public void addBrand(Brand brand) {
        if (!brands.contains(brand)){
            brands.add(brand);
        }
    }

    public void addSubCategory(SubCategory subCategory){
        if (subCategories.stream().noneMatch(sc -> sc.getName().equalsIgnoreCase(subCategory.getName()))) {
            subCategories.add(subCategory);
        }
    }
    public void removeSubCategory(SubCategory subCategory){
        subCategories.removeIf(sc -> sc.getId().equals(subCategory.getId()));
    }

}

