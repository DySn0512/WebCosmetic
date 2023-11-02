package demo.demoweb.ENTITY;

import jakarta.persistence.*;

@Entity
public class DetailProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private String unit;
    private Double price;
    private Boolean isSale;
    private Double salePrice;
    private Integer inventory;

    public DetailProduct() {
    }

    public DetailProduct(Product product, String unit, Double price, Boolean isSale, Double salePrice, Integer inventory) {
        this.product = product;
        this.unit = unit;
        this.price = price;
        this.isSale = isSale;
        this.salePrice = salePrice;
        this.inventory = inventory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getSale() {
        return isSale;
    }

    public void setSale(Boolean sale) {
        isSale = sale;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Product getProduct() {
        return product;
    }

    public Double getCurrentPrice(){
        return isSale?salePrice:price;
    }
}
