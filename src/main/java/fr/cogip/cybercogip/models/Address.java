package fr.cogip.cybercogip.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 50)
    private  String address1;

    @Column
    @NotBlank
    @Size(max = 50)
    private String address2;

    @Column(name = "zip_code", nullable = false, length = 6)
    @NotBlank
    @Size(min = 5, max = 6)
    private String zipCode;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 50)
    private String city;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 50)
    private String country;

    public Address() {
    }

    public Address(String streetNumber, String street, String zipCode, String country) {
        this.address1 = streetNumber;
        this.address2 = street;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
