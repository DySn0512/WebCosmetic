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

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
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

    public void addBrand(Brand brand) {
        for (var value : brands) {
            if (value.getId().equals(brand.getId())) {
                return;
            }
        }
        brands.add(brand);
    }

    public void removeBrand(Brand brand) {
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getId().equals(brand.getId())) {
                brands.remove(i);
                return;
            }
        }
    }

    public void addSubCategory(SubCategory subCategory){
        for (var value : subCategories) {
            if(value.getName().equalsIgnoreCase(subCategory.getName())) {
                return;
            }
        }
        subCategories.add(subCategory);
    }
    public void removeSubCategory(SubCategory subCategory){
        for (int i = 0; i < subCategories.size(); i++) {
            if (subCategories.get(i).getId().equals(subCategory.getId())) {
                subCategories.remove(i);
                return;
            }
        }
    }

}

