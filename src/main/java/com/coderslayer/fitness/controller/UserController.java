package com.coderslayer.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderslayer.fitness.model.User;
import com.coderslayer.fitness.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register-user")
    public String getRegisterUserForm(Model model){
        model.addAttribute("user", new User());

        return "register-user";
    }

    @PostMapping("/register-user")
    public String registerUser(@ModelAttribute User user){
        userService.saveUser(user);

        return "home";
    }
}
