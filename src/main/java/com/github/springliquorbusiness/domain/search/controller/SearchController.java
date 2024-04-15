package com.github.springliquorbusiness.domain.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

    @GetMapping("")
    public String totalSearchPage() {
        return "search/fullSearch";
    }

    
}
