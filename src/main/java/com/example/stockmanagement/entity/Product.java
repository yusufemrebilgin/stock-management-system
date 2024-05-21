package com.example.stockmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @NotEmpty(message = "Product name is required")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Positive(message = "Quantity must be positive")
    private int quantityInStock;

    @Positive(message = "Cost price must be positive")
    private double costPrice;

    private double salePrice;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
