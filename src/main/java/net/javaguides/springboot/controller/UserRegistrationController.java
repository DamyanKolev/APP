package net.javaguides.springboot.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.exception.CustomErrorType;
import net.javaguides.springboot.model.User;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationController {
    public static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@Valid @RequestBody final User user) {

        // check username of the user whether it exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            logger.error("Unable to create. A User with name {} already exist", user.getUsername());

            return new ResponseEntity<User>(
                    new CustomErrorType(
                            "Unable to create new user. A User with name " + user.getUsername() + " already exist."),
                    HttpStatus.CONFLICT);
        }

        // check email of the user whether it exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            logger.error("Unable to create. A User with email {} already exist", user.getEmail());

            return new ResponseEntity<User>(
                    new CustomErrorType(
                            "Unable to user a new email. A User with email " + user.getEmail() + " already exist."),
                    HttpStatus.CONFLICT);
        }

        // save user into database
        userRepository.save(user);
        // return response of client
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "/login/{username}&{password}")
    public ResponseEntity<CustomErrorType> signIn(@PathVariable("username") String username, @PathVariable("password") String password) {

        // check username and password of the user whether it exists
        if (userRepository.findByUsername(username) == null ||
        userRepository.findByPassword(password) == null) {

            return new ResponseEntity<>(new CustomErrorType(
                    "A User with username " + username + " not exist exist."),
                    HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(new CustomErrorType("Login in"), HttpStatus.OK);
    }

    

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") final Long id) {

        User user = userRepository.findById(id).get();

        if (user == null) {
            return new ResponseEntity<User>(new CustomErrorType("User with id " + id + " not found"),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("id") final Long id, @RequestBody User user) {

        // fetch user based on id and set it to currentUser object of type UserDTO
        User currentUser = userRepository.findById(id).get();

        // update currentUser object data with user object data
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());

        // save currentUser obejct
        userRepository.saveAndFlush(currentUser);

        // return ResponseEntity object
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") final Long id) {
        User user = userRepository.findById(id).get();

        if (user == null) {
            return new ResponseEntity<User>(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
