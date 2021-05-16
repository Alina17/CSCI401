package com.user.auto.user.config;



import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;


@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired ExceptionController exception;

    @Autowired
    private TokenProperties properties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        try {

            var token = request.getHeader(properties.getHeader()).replace(properties.getPrefix(), "");

            var name = JWT.require(Algorithm.HMAC512(properties.getSecret().getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

            log.info("username {}", name);

            return true;


        } catch (TokenExpiredException e) {
            log.warn("token expired", e.getMessage());
            return false;
        }


    }
}

