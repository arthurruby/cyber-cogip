package fr.cogip.cybercogip.models;

import fr.cogip.cybercogip.models.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 55)
    @Column(nullable = false, length = 55)
    private String reference;

    @Enumerated
    @Column(nullable = false)
    private OrderStatus status;

    @PastOrPresent
    @Column(name= "date_of_creation", nullable = false)
    private LocalDateTime dateOfCreation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="id_customer")
    private  Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderHasProduct> orderHasProducts;

    public Order() {
        this.orderHasProducts = new ArrayList<>();
    }

    public Order( String reference, OrderStatus status, LocalDateTime dateOfCreation, User user, Customer customer) {

        this.reference = reference;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.user = user;
        this.customer = customer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateOfCreation() {
        return this.dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderHasProduct> getOrderHasProducts() {
        return this.orderHasProducts;
    }

    public void setOrderHasProducts(List<OrderHasProduct> orderHasProducts) {
        this.orderHasProducts = orderHasProducts;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order #");
        sb.append(this.reference).append(" placed by ")
        .append(this.customer.toString())
        .append(" and supervised by ")
        .append(this.user.toString());
        return sb.toString();
    }
}
