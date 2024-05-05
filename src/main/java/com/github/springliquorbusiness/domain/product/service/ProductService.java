package com.github.springliquorbusiness.domain.product.service;

import com.github.springliquorbusiness.domain.product.dto.ResProductDto;
import com.github.springliquorbusiness.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ResProductDto> productGetByCategoryOrRegion(String category, String region) {
        return (List<ResProductDto>) new ResProductDto();
    }
}
