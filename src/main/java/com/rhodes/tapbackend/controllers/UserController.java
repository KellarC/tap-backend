package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.*;
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
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        userService.changePassword(changePasswordDTO.getUsername(), changePasswordDTO.getNewPassword());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/change-email")
    public ResponseEntity<?> changeEmail(@RequestBody ChangeEmailDTO changeEmailDTO) {
        userService.changeEmail(changeEmailDTO.getUsername(), changeEmailDTO.getNewEmail());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<?> deleteAccount(@RequestBody DeleteAccountDTO deleteAccountDTO) {
        boolean deleted = userService.deleteAccount(deleteAccountDTO.getUsername());
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/follow-user")
    public ResponseEntity<?> followUser(@RequestBody FollowUserDTO followUserDTO) {
        boolean follow = userService.followUser(followUserDTO.getFollower_id(), followUserDTO.getFollowee_id());
        if (follow) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}