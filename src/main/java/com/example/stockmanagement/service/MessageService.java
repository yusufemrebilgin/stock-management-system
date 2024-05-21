package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.MessageDTO;
import com.example.stockmanagement.entity.user.Message;
import com.example.stockmanagement.entity.user.User;
import com.example.stockmanagement.exception.MessageNotFoundException;
import com.example.stockmanagement.repository.user.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserService userService;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("Message not found with id " + id));
    }

    public List<Message> getMessagesByReceiverId(long receiverId) {
        User receiver = userService.findById(receiverId);
        return messageRepository.findByReceiver(receiver);
    }

    public void sendMessage(MessageDTO messageDTO) {
        User sender = userService.findById(messageDTO.getSenderId());
        User receiver = userService.findById(messageDTO.getReceiverId());

        Message message = Message.builder()
                .sender(sender)
                .receiver(receiver)
                .title(messageDTO.getTitle())
                .content(messageDTO.getContent())
                .timestamp(LocalDateTime.now())
                .isRead(false)
                .build();

        messageRepository.save(message);
    }

    public void markAsRead(Long messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new MessageNotFoundException("Message not found with id " + messageId));
        message.setRead(true);
        messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

}
