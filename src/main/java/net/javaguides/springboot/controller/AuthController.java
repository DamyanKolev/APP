package net.javaguides.springboot.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.response.AuthenticationResponse;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.dto.request.CustomerRequest;
import net.javaguides.springboot.dto.request.LoginRequest;
import net.javaguides.springboot.dto.request.RefreshTokenRequest;
import net.javaguides.springboot.dto.request.UserRequest;
import net.javaguides.springboot.service.AuthService;
import net.javaguides.springboot.service.RefreshTokenService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/user/sign-up")
    public ResponseEntity<String> signup(@Valid @RequestBody UserRequest UserRequest) {
        authService.signupUser(UserRequest);

        return new ResponseEntity<>("User Registration Successful", HttpStatus.CREATED);
    }

    @PostMapping("/customer/sign-up")
    public ResponseEntity<String> signup(@RequestBody CustomerRequest CustomerRequest) {
        authService.signupCustomer(CustomerRequest);

        return new ResponseEntity<>("User Registration Successful", HttpStatus.CREATED);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Yourt Account Activated Successfully", HttpStatus.OK);
    }

    // @PostMapping("/sign-in")
    // public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
    // return authService.login(loginRequest);
    // }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
    }

}
