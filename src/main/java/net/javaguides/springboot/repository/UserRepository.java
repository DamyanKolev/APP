package net.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // find username of the user in the database
    Optional<User> findByUsername(String username);

    // find password of the user in the database
    User findByPassword(String password);

    // find email of the user in the database
    User findByEmail(String email);
}