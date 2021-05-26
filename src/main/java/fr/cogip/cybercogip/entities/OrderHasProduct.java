package fr.cogip.cybercogip.entities;

import javax.persistence.*;

@Entity
public class OrderHasProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private double quantity;
    @Column
    private double priceHt;

    @ManyToOne
    @JoinColumn(name = "")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "")
    private Product product;

    public OrderHasProduct() {
    }

    public OrderHasProduct( double quantity, double priceHt, Order order, Product product) {

        this.quantity = quantity;
        this.priceHt = priceHt;
        this.order = order;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPriceHt() {
        return priceHt;
    }

    public void setPriceHt(double priceHt) {
        this.priceHt = priceHt;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
