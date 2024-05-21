package com.example.stockmanagement.repository.user;

import com.example.stockmanagement.entity.user.Message;
import com.example.stockmanagement.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByReceiver(User receiver);

}
