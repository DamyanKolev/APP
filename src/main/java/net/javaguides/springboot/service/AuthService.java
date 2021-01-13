package net.javaguides.springboot.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import static net.javaguides.springboot.security.SecurityConstants.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.javaguides.springboot.dto.request.CustomerRequest;
import net.javaguides.springboot.dto.request.LoginRequest;
import net.javaguides.springboot.dto.request.UserRequest;
import net.javaguides.springboot.exception.CustomCustomerErrorType;
import net.javaguides.springboot.exception.CustomUserErrorType;
import net.javaguides.springboot.exception.StoreException;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.model.NotificationEmail;
import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.Roles;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.VerificationToken;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.repository.VerificationTokenRepository;
import static net.javaguides.springboot.model.Roles.USER;
import static net.javaguides.springboot.model.Roles.CUSTOMER;

@Service
@Data
@AllArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MailService mailService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    // private final AuthenticationManager authenticationManager;
    private final VerificationTokenRepository verificationTokenRepository;

    public ResponseEntity<UserRequest> signupUser(UserRequest userRequest) {
        //check username
        if (userRepository.findByUsername(userRequest.getFirstName()) != null) {
            return new ResponseEntity<UserRequest>(new CustomUserErrorType(
            "Unable to create new user. A User with name "
           + userRequest.getUsername() + " already exist."),HttpStatus.CONFLICT);
        }

        User user = userMapper.mapUser(userRequest);
        user.setRoles(setRole(USER));

        // save user information into database
        userRepository.save(user);

        // sent verification email to the user
        sentVerificationEmail(user);

        return null;
    }

    public ResponseEntity<CustomerRequest> signupCustomer(CustomerRequest customerRequest) {
        //check username
        if (userRepository.findByUsername(customerRequest.getFirstName()) != null) {
            return new ResponseEntity<CustomerRequest>( new CustomCustomerErrorType(
            "Unable to create new user. A User with name "
           + customerRequest.getUsername() + " already exist."), HttpStatus.CONFLICT);
        }

        User customer = userMapper.mapCustomer(customerRequest);
        customer.setRoles(setRole(CUSTOMER));

        // save customer information into database
        userRepository.save(customer);

        // sent verification email to the user
        sentVerificationEmail(customer);

        return null;
    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        fetchUserAndEnable(verificationToken.orElseThrow(() -> new StoreException("Invalid Token")));
    }

    // public ResponseEntity<String> login(LoginRequest loginRequest) {
    //     Authentication authenticate = authenticationManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    //     SecurityContextHolder.getContext().setAuthentication(authenticate);
    //     String token = generateToken(authenticate);
    //     return new ResponseEntity<>(token, HttpStatus.OK);

    // }

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }

    private void sentVerificationEmail(User user) {
        String token = generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Please Activate your Account", user.getEmail(),
                "Thank you for signing up to Spring Reddit, "
                        + "please click on the below url to activate your account : "
                        + "http://localhost:8085/api/auth/accountVerification/" + token));
    }

    private Set<Role> setRole(Roles role) {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(role));
        return roles;
    }

    private Boolean checkUsernameAndPassword(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new StoreException("Invalid username or password!"));

        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return true;
        }

        return false;
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new StoreException("User not found with name - " + username));
        user.setEnabled(true);
        userRepository.save(user);
    }


    private String generateToken(Authentication auth) {

        return JWT.create().withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));
    }
}
