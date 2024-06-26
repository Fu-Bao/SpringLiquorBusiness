package com.github.springliquorbusiness.domain.payment.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {


    @GetMapping("/info")
    public String paymentInfo() {
        return "payment/payment";
    }

    @GetMapping("/detail")
    public String paymentDetail() {
        return "payment/payment_info";
    }

    @GetMapping("/delivery")
    public String paymentDelivery() {
        return "payment/payment_delivery";
    }
}
