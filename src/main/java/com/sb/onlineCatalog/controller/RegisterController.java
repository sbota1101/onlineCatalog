package com.sb.onlineCatalog.controller;

import com.sb.onlineCatalog.model.User;
import com.sb.onlineCatalog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    //TODO:create user service

    @GetMapping("/register")
    public String registerUser() {
        return "security/register";
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/register")
    public String registerUser(String username, String password, String emailAddress) {
        User user = new User();
        user.setEmailAddress(emailAddress);
        user.setPassword(encoder().encode(password));
        user.setUsername(username);
        userRepository.save(user);
        return "redirect:/login";
    }
}
