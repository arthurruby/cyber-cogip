package fr.cogip.cybercogip.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String reference;

    @Column
    private String status;

    @Column(name= "date_of_creation")
    private LocalDate dateOfCreation;

    @ManyToOne
    @JoinColumn(name="")
    private User user;

    @ManyToOne
    @JoinColumn(name="id_customer")
    private  Customer customer;

    public Order() {
    }

    public Order( String reference, String status, LocalDate dateOfCreation, User user, Customer customer) {

        this.reference = reference;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.user = user;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
