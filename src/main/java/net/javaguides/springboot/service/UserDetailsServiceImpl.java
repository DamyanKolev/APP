package net.javaguides.springboot.service;

import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional
                .orElseThrow(() -> new UsernameNotFoundException("No user " + "Found with username : " + username));

        return new org.springframework.security.core.userdetails.User(user);
    }

    // @Transactional(rollbackFor = Exception.class)
    // public String saveDto(UserDto userDto) {
    // userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    // return save(new User(userDto)).getId();
    // }
}
