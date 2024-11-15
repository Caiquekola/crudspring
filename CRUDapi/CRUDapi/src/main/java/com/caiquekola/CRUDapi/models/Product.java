package com.caiquekola.CRUDapi.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = Product.TABLE_NAME)
public class Product {

    public static final String TABLE_NAME = "product";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false,
    length = 50,unique = true)
    private String name;

    @Column(name = "description", nullable = false,
    length = 255)
    private String description;

    @Column(name = "brand",length = 255)
    private String brand;

    @Column(name = "price")
    private double price;

    @Column(name = "acq_date")
    LocalDate acquisionDate;

}
