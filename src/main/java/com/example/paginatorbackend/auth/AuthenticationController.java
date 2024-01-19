package com.example.paginatorbackend.auth;

import com.example.paginatorbackend.Repository.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is Authentication Controller class it
 * handle the upcoming request for user authenticate
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class AuthenticationController {
    private final AuthenticationService service;
    private final EmailService emailService;

    /**
     * This method handle the user registration
     * it contains the user information
     *
     * @return token
     * @RequestBody request
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
//        String userEmailAddress = request.getEmail();
//        String subject = "Congratulations on Your Registration";
//        String body = "Thank you for registering with our service";
//        String[] cc = new String[]{"kuldeep@gmail.com"};
//        emailService.sendMail(userEmailAddress,cc,subject,body);
        return ResponseEntity.ok(service.register(request));
    }

    /**
     * This method authenticate the user for login with credentials
     *
     * @param authRequest
     * @return token
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authRequest) {
        return ResponseEntity.ok(service.authenticate(authRequest));
    }
}
