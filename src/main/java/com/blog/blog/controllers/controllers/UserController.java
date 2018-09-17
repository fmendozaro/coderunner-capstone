package com.blog.blog.controllers.controllers;

import com.blog.blog.controllers.repositories.UserRepo;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepo users;
    //private PasswordEncoder passwordEncoder;

    public UserController(UserRepo users) {
        this.users = users;
        //this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        //model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        //String hash = passwordEncoder.encode(user.getPassword());
        //user.setPassword(hash);

        users.save(user);
        return "redirect:/login";
    }
}

