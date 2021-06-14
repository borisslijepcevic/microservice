package com.boris.hotel_application.service;

import com.boris.hotel_application.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserDetailsService {

    private UserService userService;

    public AdminService(UserService userService) {
        this.userService = userService;
    }

    @Value("${spring.security.user.name}")
    private String adminEmail;

    @Value("${spring.security.user.password}")
    private String adminPassword;

    @Value("${spring.security.user.roles}")
    private String adminRole;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals(adminEmail)) {

            UserDetails admin =
                    org.springframework.security.core.userdetails.User
                            .builder()
                            .username(adminEmail)
                            .password(adminPassword)
                            .roles(adminRole).build();

            return admin;

        }else
            return userService.loadUserByUsername(username);
    }
}
