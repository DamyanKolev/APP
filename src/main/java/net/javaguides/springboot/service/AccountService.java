package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.request.CustomerRequest;
import net.javaguides.springboot.dto.request.UserRequest;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class AccountService {

    private UserMapper userMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthService authService;

    public void updateUser(UserRequest userRequest) {
        // update currentUser data with UserRequest data
        User currentCustomer = userMapper.mapUser(userRequest);
        currentCustomer.setId(authService.getCurrentUser().getId());

        // save the changes
        userRepository.saveAndFlush(currentCustomer);
    }

    public void updateCustomer(CustomerRequest customerRequest) {
        // update currentCustomer data with CustomerRequest data
        User currentCustomer = userMapper.mapCustomer(customerRequest);
        currentCustomer.setId(authService.getCurrentUser().getId());

        // save the changes
        userRepository.saveAndFlush(currentCustomer);
    }

    public void delete() {
        // delete user by id
        userRepository.deleteById(authService.getCurrentUser().getId());
    }
}
