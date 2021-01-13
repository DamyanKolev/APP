package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.request.CustomerRequest;
import net.javaguides.springboot.dto.request.UserRequest;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.AccountService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    UserRepository userRepository;
    private final AccountService accountService;

    @PutMapping("/user/update")
    public ResponseEntity<String> updateUser(@RequestBody UserRequest userRequest) {
        accountService.updateUser(userRequest);
        return new ResponseEntity<>("Your Account Updated Successful", HttpStatus.OK);
    }

    @PutMapping("/customer/update")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerRequest customerRequest) {
        accountService.updateCustomer(customerRequest);
        return new ResponseEntity<>("Your Account Updated Successful", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser() {
        accountService.delete();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
