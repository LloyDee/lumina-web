package com.lumina.judicial.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username:LJPINTAC@gmail.com}")
    private String toEmail;

    @Value("${spring.mail.password:}")
    private String mailPassword;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactEmail(String name, String fromEmail, String messageBody) {
        if (mailPassword == null || mailPassword.isEmpty()) {
            System.err.println("WARNING: spring.mail.password is NOT SET. Email will fail authentication.");
        }
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("LJPINTAC@gmail.com");
        message.setTo("LJPINTAC@gmail.com");
        message.setSubject("New Contact Message from " + name);
        message.setText("Name: " + name + "\nEmail: " + fromEmail + "\n\nMessage:\n" + messageBody);
        
        mailSender.send(message);
    }
}
