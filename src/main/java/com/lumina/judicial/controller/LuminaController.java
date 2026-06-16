package com.lumina.judicial.controller;

import com.lumina.judicial.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LuminaController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String handleContact(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
        System.out.println("Contact received from: " + name + " (" + email + "): " + message);
        try {
            emailService.sendContactEmail(name, email, message);
        } catch (Exception e) {
            System.err.println("CRITICAL ERROR: Failed to send email to LJPINTAC@gmail.com");
            System.err.println("Error details: " + e.getMessage());
        }
        return "contact-success";
    }
}
