package com.github.springliquorbusiness.domain.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String name;

    private String description;

    private int price;

    private int stock;

    private String image1;

    private String image2;

    private String image3;

    private String category;

    private String region;

}
