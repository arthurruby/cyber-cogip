package fr.cogip.cybercogip.models;


import fr.cogip.cybercogip.models.enums.ProductStatus;
import fr.cogip.cybercogip.models.enums.Vat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 55)
    @Column(nullable = false, length = 55)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @Min(0)
    @Column(nullable = false)
    private BigDecimal price;

    @Min(0)
    @Column(nullable = false)
    private int stock;

    @Enumerated
    @Column(name = "vat_rate", nullable = false)
    private Vat vatRate;

    @Enumerated
    @Column(nullable = false)
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderHasProduct> orderHasProducts;

    public Product() {
    this.orderHasProducts = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int quantity) {
        this.stock = quantity;
    }

    public Vat getVatRate() {
        return this.vatRate;
    }

    public void setVatRate(Vat vatRate) {
        this.vatRate = vatRate;
    }

    public ProductStatus getStatus() {
        return this.status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrderHasProduct> getOrderHasProducts() {
        return this.orderHasProducts;
    }

    public void setOrderHasProducts(List<OrderHasProduct> orderHasProducts) {
        this.orderHasProducts = orderHasProducts;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.name).append(" (")
        .append(this.category.toString()).append(")");
        return sb.toString();
    }
}
