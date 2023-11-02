package demo.demoweb.ENTITY;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class KeyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "Product_KeyWord",
            joinColumns = @JoinColumn(name = "keyword_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    @Column(unique = true)
    private String word;

    public KeyWord() {
    }

    public KeyWord(String word) {
        this.word = word;
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

    public List<Product> getProducts() {
        return products;
    }
}
