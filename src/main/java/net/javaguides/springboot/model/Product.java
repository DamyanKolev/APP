package net.javaguides.springboot.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    private Instant createDate;
}
