package demo.demoweb.ENTITY;

import jakarta.persistence.*;

@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;
    @Column(unique = true)
    private String strImage;

    public ProductImage() {
    }

    public ProductImage(Product product, String strImage) {
        this.product = product;
        this.strImage = strImage;
    }

    public String getStrImage() {
        return strImage;
    }

    public void setStrImage(String strImage) {
        this.strImage = strImage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
