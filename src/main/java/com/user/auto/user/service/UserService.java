package com.user.auto.user.service;

import com.user.auto.user.model.Login;
import com.user.auto.user.model.User;

import java.util.List;

public interface UserService {
    List<User> getUser();
    User createUser(User user);
    Boolean validate(Login login);
    Boolean nameExists(String name);
    String createUserAndGetId(User user);
    User getUserByLogIn(Login login);
}
