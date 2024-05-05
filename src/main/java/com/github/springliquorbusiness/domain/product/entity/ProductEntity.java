package com.github.springliquorbusiness.domain.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String image1;
    private String image2;
    private String image3;
    private String category;
    private String region;


}
