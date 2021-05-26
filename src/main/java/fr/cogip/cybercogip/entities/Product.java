package fr.cogip.cybercogip.entities;


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
    private CategoryProduct category;

    @Embedded
    private Tva tva;



    public Product() {
    }

    public Product( String reference, String name, String description, double quantity, double priceHT, CategoryProduct category, Tva tva) {
        
        this.reference = reference;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.priceHT = priceHT;
        this.category = category;
        this.tva = tva;
    }
}
