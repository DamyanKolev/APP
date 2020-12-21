package net.javaguides.springboot.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "ProductDescription")
    private String description;

    private String category;

    private String color;

    @Column(name = "QuantityPerUnit")
    private Double quantityPerUnit;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "UnitWeight")
    private Double unitWeight;

    @Column(name = "UnitInStock")
    private Integer unitInStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sellerID", referencedColumnName = "id")
    
    private User user;

    private Instant createDate;

    public Product() {

    }

    



}
