package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.ApplicationUser;
import com.rhodes.tapbackend.models.ChangeUsernameDTO;
import com.rhodes.tapbackend.models.ChangePasswordDTO;
import com.rhodes.tapbackend.models.ChangeEmailDTO;
import com.rhodes.tapbackend.repositories.UserRepository;
import com.rhodes.tapbackend.services.AuthenticationService;
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

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationUser applicationUser;

    @GetMapping("/")
    public String helloUserController() { return "User access level"; }

    /*
    @PostMapping("/{oldUsername}/change-username")
    public ResponseEntity<?> changeUsername(@PathVariable String oldUsername, @RequestParam String newUsername) {
        userService.changeUsername(oldUsername, newUsername);
        return ResponseEntity.ok("Username changed successfully");
    }


    @PostMapping("/{username}/change-password")
    public ResponseEntity<?> changePassword(@PathVariable String username, @RequestParam String newPassword) {
        userService.changePassword(username, newPassword);
        return ResponseEntity.ok("Password changed successfully");
    }*/

    @PostMapping("/change-username")
    public ResponseEntity<?> changeUsername(@RequestBody ChangeUsernameDTO credentials) {
        authenticationService.changeUsername(credentials.getOldUsername(), credentials.getNewUsername());
        return ResponseEntity.ok("Username changed successfully");
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO credentials) {
        authenticationService.changePassword(credentials.getUsername(), credentials.getNewPassword());
        return ResponseEntity.ok("Password changed successfully");
    }

    public ResponseEntity<?> changeEmail(@RequestBody ChangeEmailDTO changeEmailDTO) {
        authenticationService.changeEmail(changeEmailDTO.getUsername(), changeEmailDTO.getNewEmail());
        return ResponseEntity.ok("Email changed successfully");
    }

}