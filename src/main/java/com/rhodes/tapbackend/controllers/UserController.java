package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.ChangeUsernameDTO;
import com.rhodes.tapbackend.models.ChangePasswordDTO;
import com.rhodes.tapbackend.models.ChangeEmailDTO;
import com.rhodes.tapbackend.models.DeleteAccountDTO;
import com.rhodes.tapbackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String helloUserController() { return "User access level"; }

    @PostMapping("/change-username")
    public ResponseEntity<?> changeUsername(@RequestBody ChangeUsernameDTO changeUsernameDTO) {
        userService.changeUsername(changeUsernameDTO.getOldUsername(), changeUsernameDTO.getNewUsername());
        return ResponseEntity.ok("Username changed successfully");
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        userService.changePassword(changePasswordDTO.getUsername(), changePasswordDTO.getNewPassword());
        return ResponseEntity.ok("Password changed successfully");
    }

    @PostMapping("/change-email")
    public ResponseEntity<?> changeEmail(@RequestBody ChangeEmailDTO changeEmailDTO) {
        userService.changeEmail(changeEmailDTO.getUsername(), changeEmailDTO.getNewEmail());
        return ResponseEntity.ok("Email changed successfully");
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<?> deleteAccount(@RequestBody DeleteAccountDTO deleteAccountDTO) {
        boolean deleted = userService.deleteAccount(deleteAccountDTO.getUsername());
        if (deleted) {
            return ResponseEntity.ok("Account deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}