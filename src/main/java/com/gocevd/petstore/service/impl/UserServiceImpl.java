package com.gocevd.petstore.service.impl;

import com.gocevd.petstore.model.Money;
import com.gocevd.petstore.model.User;
import com.gocevd.petstore.repository.jpa.UserRepository;
import com.gocevd.petstore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUsers() {
        for(int i = 1; i < 11; i++) {
            Money money = new Money();
            User user = new User();
            money.setAmount(Math.round(200+Math.random()*100));
            user.setFirstName("User" + i);
            user.setLastName("User" + i);
            user.setEmail("user" + i + "@example.com");
            user.setBudget(money);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
