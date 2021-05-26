package fr.cogip.cybercogip.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private  String address1;

    @NotBlank
    @Size(max = 50)
    private String address2;

    @NotBlank
    @Size(min = 5, max = 6)
    @Column(name = "zip_code", nullable = false, length = 6)
    private String zipCode;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String country;

//    @OneToMany(mappedBy = "shipping_address")
//    private List<Customer> customers;

    public Address() {
    }

    public Address(String address1, String address2, String zipCode, String country) {
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address: ");
        sb.append(address1).append(", ")
        .append(address2).append(", ")
        .append(zipCode).append(", ")
        .append(city).append(", ")
        .append(country);
        return sb.toString();
    }
}
