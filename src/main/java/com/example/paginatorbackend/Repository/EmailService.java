package com.example.paginatorbackend.Repository;

public interface EmailService {
    String sendMail(String to, String[] cc, String subject, String body);
}
