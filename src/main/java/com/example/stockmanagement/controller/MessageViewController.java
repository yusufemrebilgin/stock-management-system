package com.example.stockmanagement.controller;

import com.example.stockmanagement.dto.MessageDTO;
import com.example.stockmanagement.entity.user.Message;
import com.example.stockmanagement.entity.user.User;
import com.example.stockmanagement.service.MessageService;
import com.example.stockmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/messages")
public class MessageViewController {

    private final MessageService messageService;
    private final UserService userService;

    @Autowired
    public MessageViewController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping
    public String getReceivedMessages(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByUsername(authentication.getName());

        model.addAttribute("receivedMessages", messageService.getMessagesByReceiverId(currentUser.getId()));

        return "messages";
    }

    @GetMapping("/new")
    public String newMessage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        if (!model.containsAttribute("messageDTO")) {
            model.addAttribute("messageDTO", new MessageDTO());
        }

        return "forms/message-form";
    }

    @PostMapping("/send")
    public String sendMessage(@Valid @ModelAttribute MessageDTO messageDTO, BindingResult bindingResult,
                              Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByUsername(authentication.getName());

        messageDTO.setSenderId(currentUser.getId());

        if (bindingResult.hasErrors()) {
            model.addAttribute("messageDTO", messageDTO);
            model.addAttribute("users", userService.findAll());
            return "forms/message-form";
        }

        messageService.sendMessage(messageDTO);
        return "redirect:/messages";
    }

    @GetMapping("/read")
    public String readMessage(@RequestParam long id, Model model) {
        Message message = messageService.getMessageById(id);
        messageService.markAsRead(id);

        model.addAttribute("message", message);

        return "message";
    }

    @GetMapping("/delete")
    public String deleteMessage(@RequestParam Long id) {
        messageService.deleteMessage(id);

        return "redirect:/messages";
    }

}
