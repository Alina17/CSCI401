package com.user.auto.user.controller;

import com.user.auto.user.model.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ForumController {

    // write an interceptor - check
    // get token from header - check
    // remove bearer prefix - check
    // decode the jwt - check
    // check if a username exists -
    // check if token not expired - check
    // if true - allow, if not - deny
    
    @GetMapping("/forum")
    public String loginWithJWT() throws Exception {


        log.info("throwing");

        if(1 == 1) throw new Exception("hello");




        log.info("forum end point");
        return "sensetive data";
    }






}
