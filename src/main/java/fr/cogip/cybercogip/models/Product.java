package fr.cogip.cybercogip.models;


import javax.persistence.*;


@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String reference;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double quantity;
    @Column
    private double priceHT;

    @Column(name="category")
    @ManyToOne
    private ProductCategory category;

    @Embedded
    private Tva tva;



    public Product() {
    }

    public Product( String reference, String name, String description, double quantity, double priceHT, ProductCategory category, Tva tva) {
        
        this.reference = reference;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.priceHT = priceHT;
        this.category = category;
        this.tva = tva;
    }
}
