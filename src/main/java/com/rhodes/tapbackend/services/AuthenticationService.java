package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.ApplicationUser;
import com.rhodes.tapbackend.models.DummyResponseDTO;
import com.rhodes.tapbackend.models.LoginResponseDTO;
import com.rhodes.tapbackend.models.Role;
import com.rhodes.tapbackend.repositories.RoleRepository;
import com.rhodes.tapbackend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String username, String password, String firstName, String lastName, String email) {

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(0, username, encodedPassword, firstName, lastName, email, authorities));
    }

    public LoginResponseDTO loginUser(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = tokenService.generateJwt(authentication);
            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);
        } catch(AuthenticationException e) {
            return failedLoginInvalidPassword();
        }
    }
    @ResponseStatus(code=HttpStatus.UNAUTHORIZED, reason="Invalid username or password")
    private LoginResponseDTO failedLoginInvalidPassword() {
        return new LoginResponseDTO(null, "");
    }

    public ResponseEntity<?> debugRegister(String username, String password) {
        DummyResponseDTO dummyResponse = new DummyResponseDTO();
        dummyResponse.setMessage("Registration successful in debug mode.");
        return ResponseEntity.ok(dummyResponse);
    }

    public ResponseEntity<?> debugLogin(String username, String password) {
        DummyResponseDTO dummyResponse = new DummyResponseDTO();
        dummyResponse.setMessage("Login successful in debug mode.");
        return ResponseEntity.ok(dummyResponse);
    }
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
}
