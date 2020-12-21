package net.javaguides.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.AuthenticationResponse;
import net.javaguides.springboot.dto.CustomerRequest;
import net.javaguides.springboot.dto.UserRequest;
import net.javaguides.springboot.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @PostMapping("/user/signup")
    public ResponseEntity<String> signup(@RequestBody UserRequest registerUserRequest) {
        authService.signupUser(registerUserRequest);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }

    @PostMapping("/customer/signup")
    public ResponseEntity<String> signup(@RequestBody CustomerRequest registerCustomerRequest) {
        authService.signupCustomer(registerCustomerRequest);
        
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }

    // @GetMapping("accountVerification/{token}")
    // public ResponseEntity<String> verifyAccount(@PathVariable String token) {
    //     authService.verifyAccount(token);
    //     return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
    // }

    // @PostMapping("/login")
    // public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
    //     return authService.login(loginRequest);
    // }
}
