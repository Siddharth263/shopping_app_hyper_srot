package com.hypersrot.shoppingapp.modals;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    private String name;
    private Double price;
    private Integer quantity;
}