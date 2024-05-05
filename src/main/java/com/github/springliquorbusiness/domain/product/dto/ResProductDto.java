package com.github.springliquorbusiness.domain.product.dto;

import com.github.springliquorbusiness.domain.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResProductDto {
    private String name;
    private String description;
    private int price;
    private String image1;
    private String image2;
    private String image3;
    private String category;
    private String region;

    public static ResProductDto entityToDto(ProductEntity product) {
        return ResProductDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .image1(product.getImage1())
                .image2(product.getImage2())
                .image3(product.getImage3())
                .category(product.getCategory())
                .region(product.getRegion())
                .build();
    }
}
