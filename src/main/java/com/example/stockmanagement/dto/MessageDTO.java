package com.example.stockmanagement.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private long senderId;

    private long receiverId;

    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Message content is required")
    private String content;

}
