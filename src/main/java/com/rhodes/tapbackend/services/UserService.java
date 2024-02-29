package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.rhodes.tapbackend.models.ApplicationUser;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the UserDetailsService");

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
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

        user.setPassword(encoder.encode(newPassword));
        userRepository.save(user);
    }
    //need to find UsernameNotFoundException but for Email!!
    /*public void changeEmail(String email, String newEmail){
        ApplicationUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found"));

        user.setEmail(encoder.encode(newEmail));
        userRepository.save(user);
    }*/
}
