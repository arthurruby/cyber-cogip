package fr.cogip.cybercogip.models;

import fr.cogip.cybercogip.security.AttributeEncryptor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 55)
    @Column(name="name", nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private String name;

    @NotBlank
//    @Size(min = 10, max = 13)
    @Digits(integer = 13, fraction = 0)
    @Column(name="phone_number", nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private  String phoneNumber;

    @Email
    @Size(max = 55)
    @Column(unique = true, nullable = false)
    @Convert(converter = AttributeEncryptor.class)
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
        this.email = email.toLowerCase(Locale.ROOT);
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
        final StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" (")
        .append(this.email).append(')');
        return sb.toString();
    }
}
