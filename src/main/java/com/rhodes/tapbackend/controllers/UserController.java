package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.ChangeUsernameDTO;
import com.rhodes.tapbackend.models.ChangePasswordDTO;
import com.rhodes.tapbackend.models.ChangeEmailDTO;
import com.rhodes.tapbackend.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String helloUserController() { return "User access level"; }

    @PostMapping("/change-username")
    public ResponseEntity<?> changeUsername(@RequestBody ChangeUsernameDTO credentials) {
        userService.changeUsername(credentials.getOldUsername(), credentials.getNewUsername());
        return ResponseEntity.ok("Username changed successfully");
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO credentials) {
        userService.changePassword(credentials.getUsername(), credentials.getNewPassword());
        return ResponseEntity.ok("Password changed successfully");
    }

    @PostMapping("/change-email")
    public ResponseEntity<?> changeEmail(@RequestBody ChangeEmailDTO changeEmailDTO) {
        userService.changeEmail(changeEmailDTO.getUsername(), changeEmailDTO.getNewEmail());
        return ResponseEntity.ok("Email changed successfully");
    }
}