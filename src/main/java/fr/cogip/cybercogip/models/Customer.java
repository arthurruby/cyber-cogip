package fr.cogip.cybercogip.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false)
    @NotBlank
    @Size(max = 55)
    private String firstName;

    @Column(name="last_name", nullable = false)
    @NotBlank
    @Size(max = 55)
    private String lastName;

    @Column(name="phone_number", nullable = false)
    @NotBlank
    @Size(max = 25)
    private  String phoneNumber;

    @Column
    @NotBlank
    @Size(max = 55)
    private  String email;

    @ManyToOne
    @JoinColumn(name="invoice_adress", nullable = false)
    @NotBlank
    @Size(max = 55)
    private Address invoiceAddress;

    @ManyToOne
    @JoinColumn(name="shipping_adress)", nullable = false)
    @NotBlank
    @Size(max = 55)
    private  Address shippingAddress;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    //constructors
    public Customer() {
    }

    public Customer( String firstName, String lastName, String phoneNumber, String email, Address invoiceAddress, Address shippingAddress, User user) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.invoiceAddress = invoiceAddress;
        this.shippingAddress = shippingAddress;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }




}
