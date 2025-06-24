package com.gocevd.petstore.service;

import com.gocevd.petstore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void createUsers();
    List<User> listUsers();
    User saveUser(User user);
}
