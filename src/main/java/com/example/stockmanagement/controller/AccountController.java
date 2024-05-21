package com.example.stockmanagement.controller;

import com.example.stockmanagement.dto.PasswordChangeDTO;
import com.example.stockmanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/change-password")
    public String changePasswordForm(Model model) {
        model.addAttribute("passwordChangeDTO", new PasswordChangeDTO());
        return "forms/change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(@Valid @ModelAttribute PasswordChangeDTO passwordChangeDTO,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/change-password";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        boolean success = userService.changePassword(username, passwordChangeDTO.getCurrentPassword(),
                passwordChangeDTO.getNewPassword());

        if (success) {
            return "redirect:/";
        } else {
            bindingResult.rejectValue("currentPassword", "currentPasswordError", "Current password is incorrect");
            return "forms/change-password";
        }
    }

}
