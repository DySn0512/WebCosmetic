package demo.demoweb.ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<LineItem> lineItems = new ArrayList<>();

    public Cart() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public int count(){
        return lineItems.size();
    }

    public void addItem(LineItem item){
        for (var lineitem :lineItems) {
            if(lineitem.getDetailProduct().getId()==item.getDetailProduct().getId()){
                int currentquantity=lineitem.getQuantity();
                currentquantity++;
                lineitem.setQuantity(currentquantity);
                return;
            }
        }
        item.setCart(this);
        item.setQuantity(1);
        lineItems.add(item);
    }

    public void removeItem(LineItem item){
        for (int i = 0; i < lineItems.size(); i++) {
            LineItem lineitem = lineItems.get(i);
            if(lineitem.getDetailProduct().getId()==item.getDetailProduct().getId()){
                lineItems.remove(i);
                return;
            }
        }
    }

}