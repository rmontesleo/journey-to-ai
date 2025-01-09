package com.example.chatgpt.bot.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatGPTResponse {
    private List<Choice> choices;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {
        private String index;
        private Message message;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Message {
        private String role;
        private String content;
    }

}
