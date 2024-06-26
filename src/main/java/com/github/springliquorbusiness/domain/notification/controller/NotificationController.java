package com.github.springliquorbusiness.domain.notification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notification")
public class NotificationController {

    @GetMapping("")
    public String notificationUserPage() {
        return "notification/notification";
    }

    @GetMapping("/seller")
    public String notificationSellerPage() {
        return "notification/notification_seller";
    }
}
