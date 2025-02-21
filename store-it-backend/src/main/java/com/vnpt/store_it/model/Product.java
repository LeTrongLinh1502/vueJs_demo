package com.vnpt.store_it.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "products")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "main_image")
    private String mainImage;

    @Column(name = "secondary_image")
    private String secondaryImage;

    @Column(name = "price")
    private Double price;

    @Column(name = "original_price")
    private Double originalPrice;

    @Column(name = "created_at", updatable = false , insertable = false)
    private Date createdAt;

    @Column(name = "updated_at", updatable = false , insertable = false)
    private Date updatedAt;
}
