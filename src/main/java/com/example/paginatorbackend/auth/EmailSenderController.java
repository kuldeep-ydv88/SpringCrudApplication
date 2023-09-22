package com.example.paginatorbackend.auth;

import com.example.paginatorbackend.Repository.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vi/email")
public class EmailSenderController {
    private final EmailService emailService;

    @PostMapping("/send")
    public String sendMail(@RequestParam String to, String[] cc, String subject, String body){
        return emailService.sendMail(to, cc, subject, body);
    }

}
