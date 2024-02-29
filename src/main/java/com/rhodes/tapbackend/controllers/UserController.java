package com.rhodes.tapbackend.controllers;

import org.springframework.web.bind.annotation.*;
import com.rhodes.tapbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String helloUserController() { return "User access level"; }

    @PostMapping("/{oldUsername}/change-username")
    public ResponseEntity<?> changeUsername(@PathVariable String oldUsername, @RequestParam String newUsername) {
        userService.changeUsername(oldUsername, newUsername);
        return ResponseEntity.ok("Username changed successfully");
    }

    @PostMapping("/{username}/change-password")
    public ResponseEntity<?> changePassword(@PathVariable String username, @RequestParam String newPassword) {
        userService.changePassword(username, newPassword);
        return ResponseEntity.ok("Password changed successfully");
    }

}