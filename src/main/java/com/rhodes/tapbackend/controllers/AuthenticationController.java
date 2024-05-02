package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.ApplicationUser;
import com.rhodes.tapbackend.models.LoginResponseDTO;
import com.rhodes.tapbackend.models.RegistrationDTO;
import com.rhodes.tapbackend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
        String lowercase_username = body.getUsername().toLowerCase();
        return authenticationService.registerUser(lowercase_username,
                body.getPassword(),
                body.getFirstName(),
                body.getLastName(),
                body.getEmail());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/debug-register")
    public ResponseEntity<?> debugRegisterUser(@RequestBody RegistrationDTO body) {
        return authenticationService.debugRegister(body.getUsername(), body.getPassword());
    }

    @PostMapping("/debug-login")
    public ResponseEntity<?> debugLoginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.debugLogin(body.getUsername(), body.getPassword());
    }
}
