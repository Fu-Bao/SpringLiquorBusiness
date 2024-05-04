package com.github.springliquorbusiness.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

//    @GetMapping("/")
//    public String exRedirect1() {
//        return "redirect:https://api.yangjo.kr/swagger-ui/index.html#/";
//    }

    @GetMapping("/")
    public String redirect() {
        return "redirect:https://localhost:8080/swagger-ui/index.html#/";
    }
}
