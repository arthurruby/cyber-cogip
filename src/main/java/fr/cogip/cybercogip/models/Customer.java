package fr.cogip.cybercogip.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 55)
    @Column(name="name", nullable = false)
    private String name;

    @NotBlank
    @Size(min = 10, max = 13)
    @Column(name="phone_number", nullable = false, length = 13)
    private  String phoneNumber;

    @Email
    @Size(max = 55)
    @Column(length = 55, unique = true, nullable = false)
    private  String email;

    @ManyToOne
    @JoinColumn(name="address_id")
    private  Address address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer() {
        this.orders = new ArrayList<>();
    }

    public Customer(String name, String phoneNumber, String email, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address shippingAddress) {
        this.address = shippingAddress;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.name).append(" (")
        .append(this.email).append(')');
        return sb.toString();
    }
}
