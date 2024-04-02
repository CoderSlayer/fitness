package com.coderslayer.fitness.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslayer.fitness.model.User;
import com.coderslayer.fitness.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public boolean login(User user){
        Optional<User> u = userRepo.findByUsername(user.getUsername());
        if(u.isEmpty()) return false;

        if(u.get().getPassword() == user.getPassword()) return true;

        return false;
    }
}
