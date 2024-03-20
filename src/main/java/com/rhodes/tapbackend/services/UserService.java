package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.ApplicationUser;
import com.rhodes.tapbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
    public ResponseEntity<?> changeUsername(String oldUsername, String newUsername) {
        ApplicationUser user = userRepository.findByUsername(oldUsername)
                .orElse(null);

        if (user != null) {
            user.setUsername(newUsername);
            userRepository.save(user);
            return ResponseEntity.ok("Username changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    public ResponseEntity<?> changePassword(String username, String newPassword) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElse(null);

        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    public ResponseEntity<?> changeEmail(String username, String newEmail) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElse(null);

        if (user != null) {
            user.setEmail(newEmail);
            userRepository.save(user);
            return ResponseEntity.ok("Email changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    public ResponseEntity<?> deleteAccount(String username) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElse(null);

        if (user != null) {
            userRepository.delete(user);
            return ResponseEntity.ok("Account deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
/*
    public void changeUsername(String oldUsername, String newUsername) {
        ApplicationUser user = userRepository.findByUsername(oldUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setUsername(newUsername);
        userRepository.save(user);
    }

    public void changePassword(String username, String newPassword) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public void changeEmail(String username, String newEmail) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setEmail(newEmail);
        userRepository.save(user);
    }
    public boolean deleteAccount(String username) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElse(null); // null = does not exist
        if (user != null) {
            userRepository.delete(user);
            return true; // deleted
        } else {
            return false; // user not found
        }
    }*/
}
