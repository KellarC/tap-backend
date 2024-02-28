package com.rhodes.tapbackend.services;

#import com.rhodes.tapbackend.models.User;
import com.rhodes.tapbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        User user = userRepository.findByUsername(oldUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setUsername(newUsername);
        userRepository.save(user);
    }

    public void changePassword(String username, String newPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setPassword(encoder.encode(newPassword));
        userRepository.save(user);
    }
}
