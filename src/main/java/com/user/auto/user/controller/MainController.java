package com.user.auto.user.controller;


import com.auth0.jwt.algorithms.Algorithm;
import com.user.auto.user.config.TokenProperties;
import com.user.auto.user.model.Login;
import com.user.auto.user.service.UserService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.user.auto.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.Valid;
import com.auth0.jwt.JWT;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
public class MainController {

    @Autowired private UserService service;
    @Autowired private PasswordEncoder encoder;
    @Autowired private TokenProperties properties;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody @Valid User user) {
        if(service.nameExists(user.getName())) {
            return new ResponseEntity<>("This username not unique", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.createUserAndGetId(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login login) {
        if(service.validate(login)) {
            return new ResponseEntity<>(Map.of(properties.getHeader(), getPrefixedJwt(login)), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    private String getPrefixedJwt(Login login) {
        return properties.getPrefix()+JWT.create()
                .withSubject(login.getName())
                .withClaim("roles", service.getUserByLogIn(login).getRoles())
                .withExpiresAt(new Date(System.currentTimeMillis()+properties.getTtl()))
                .sign(Algorithm.HMAC512(properties.getSecret().getBytes()));
    }
}






