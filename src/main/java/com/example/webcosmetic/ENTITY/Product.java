package demo.demoweb.ENTITY;

import jakarta.persistence.*;
import jdk.jfr.Category;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<DetailProduct> details;

    @OneToMany
    private List<ProductImage> images;

    @ManyToMany
    private List<KeyWord> keyWords;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private ProductCategory productCategory;

    @ManyToOne
    private SubCategory subCategory;

    private String name;

    private String origin;

    private String description;


    public Product() {
    }

    public Product(String name, String origin, String description) {
        this.name = name;
        this.origin = origin;
        this.description = description;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DetailProduct> getDetails() {
        return details;
    }

    public List<KeyWord> getKeyWords() {
        return keyWords;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public DetailProduct getDefault(){
        return details.get(0);
    }
    public String getPrice() {
        if (details.size() == 1) {
            return details.get(0).getCurrentPrice().toString();
        }
        DoubleSummaryStatistics stats = details.stream()
                .mapToDouble(DetailProduct::getCurrentPrice)
                .summaryStatistics();
        double minCurrentPrice = stats.getMin();
        double maxCurrentPrice = stats.getMax();
        return minCurrentPrice + " - " + maxCurrentPrice;
    }

}
