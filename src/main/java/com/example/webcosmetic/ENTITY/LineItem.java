package demo.demoweb.ENTITY;

import jakarta.persistence.*;

@Entity
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private DetailProduct detailProduct;

    @ManyToOne
    private Cart cart;

    private int quantity;

    public LineItem() {
    }

    public LineItem(DetailProduct detailProduct) {
        this.detailProduct = detailProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quatity) {
        this.quantity = quatity;
    }

    public DetailProduct getDetailProduct() {
        return detailProduct;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public double getTotal(){
        return detailProduct.getCurrentPrice()*quantity;
    }
}
