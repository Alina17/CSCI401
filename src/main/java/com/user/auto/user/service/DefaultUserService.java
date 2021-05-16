package com.user.auto.user.service;


import com.user.auto.user.model.Login;
import com.user.auto.user.model.User;
import com.user.auto.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Component
public class DefaultUserService implements UserService {

    @Autowired private PasswordEncoder encoder;

    @Autowired private UserRepository repository;

    @Override public List<User> getUser() {
        return null;
    }

    @Override public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        return repository.save(user);
    }

    @Override public Boolean validate(Login login) {
        var user = repository.findByName(login.getName());
        if (user.isEmpty()) return false;
        return encoder.matches(login.getPassword(), user.get().getPassword());

    }

    @Override public Boolean nameExists(String name) {
        return repository.findByName(name).isPresent();
    }

    @Override public String createUserAndGetId(User user) {
        return createUser(user).getId().toString();
    }

    @Override public User getUserByLogIn(Login login) {
        return repository.findByName(login.getName()).get();
    }


}
