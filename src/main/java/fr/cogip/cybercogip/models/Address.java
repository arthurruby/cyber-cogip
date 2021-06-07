package fr.cogip.cybercogip.models;

import fr.cogip.cybercogip.security.AttributeEncryptor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 55)
    @Column(nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private String address1;

    @NotBlank
    @Size(max = 55)
    @Convert(converter = AttributeEncryptor.class)
    private String address2;

    @NotBlank
    @Size(min = 5)
    @Digits(integer = 6, fraction = 0)
    @Column(name = "zip_code", nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private String zipCode;

    @NotBlank
    @Size(max = 55)
    @Column(nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private String city;

    @NotBlank
    @Size(max = 55)
    @Column(nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private String country;

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
        final StringBuffer sb = new StringBuffer();
        sb.append(address1).append(", ").append(address2).append(", ").append(zipCode).append(", ").append(city)
                .append(", ").append(country);
        return sb.toString();
    }
}
