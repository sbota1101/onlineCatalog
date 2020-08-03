package com.sb.onlineCatalog.controller.rest;

import com.sb.onlineCatalog.config.DatabaseUserDetailsService;
import com.sb.onlineCatalog.config.JwtProvider;
import com.sb.onlineCatalog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private  final AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private DatabaseUserDetailsService databaseUserDetailsService;

    public LoginController(AuthenticationManager authenticationManager, JwtProvider jwtProvider, DatabaseUserDetailsService databaseUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.databaseUserDetailsService = databaseUserDetailsService;
    }

//    @PostMapping
//    public ResponseEntity createToken(@RequestBody User user){
//return ();
    }

