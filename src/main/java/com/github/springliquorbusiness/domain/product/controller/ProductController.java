package com.github.springliquorbusiness.domain.product.controller;

import com.github.springliquorbusiness.domain.product.dto.ProductDto;
import com.github.springliquorbusiness.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> findAllProductByCategoryAndRegion(@RequestParam(required = false) String category, @RequestParam(required = false) String region) {
        List<ProductDto> responseEntities = productService.productGetByCategoryOrRegion(category, region);
        return ResponseEntity.ok().body(responseEntities);
    }

}
