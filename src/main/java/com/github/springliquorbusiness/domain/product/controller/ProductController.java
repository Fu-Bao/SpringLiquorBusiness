package com.github.springliquorbusiness.domain.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {


    @GetMapping("/ask")
    public String askPage() {

        return "product/askList";
    }
}
