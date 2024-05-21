package com.example.stockmanagement.controller;

import com.example.stockmanagement.entity.user.User;
import com.example.stockmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/users")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        // Getting all users from the database
        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "admin";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Creating new user for model attribute to binding form data
        model.addAttribute("user", new User());

        return "forms/user-form";
    }

    @PostMapping("save")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/user-form";
        }
        // Saving user to database
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        // Deleting the user from database
        userService.deleteById(id);

        return "redirect:/admin/users";
    }

}
