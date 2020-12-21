package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.CustomerRequest;
import net.javaguides.springboot.dto.UserRequest;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;

    public void signupUser(UserRequest userRequest) {
        // save user information into database
        userRepository.save(userMapper.mapUser(userRequest));
    }

    public void signupCustomer(CustomerRequest customerRequest) {
        //save customer information into database
        userRepository.save(userMapper.mapCustomer(customerRequest));
    }

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }
}
