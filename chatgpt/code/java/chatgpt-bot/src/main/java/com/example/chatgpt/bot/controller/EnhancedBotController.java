package com.example.chatgpt.bot.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.chatgpt.bot.dto.ChatGPTRequest;
import com.example.chatgpt.bot.dto.ChatGPTResponse;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/bot/v2")
public class EnhancedBotController {

    //TODO: move this attribute to the Service layer
    @Value("${openai.model}")
    private String model;

    //TODO: move this attribute to the Service layer
    @Value("${openai.api.url}")
    private String apiURL;

    //TODO: move this attribute to the Service layer
    @Autowired
    private RestTemplate template;

   
    @GetMapping("/chat")    
    public String chat( @RequestParam("prompt") String prompt ){    

        ChatGPTRequest.Message message = new   ChatGPTRequest.Message("user", prompt); 
        final List<ChatGPTRequest.Message> messages = Collections.singletonList(message);
        
        ChatGPTRequest request = new ChatGPTRequest( model, messages );
        ChatGPTResponse gptResponse =  template.postForObject(apiURL, request, ChatGPTResponse.class);

        return gptResponse.getChoices().get(0).getMessage().getContent();
    }

}
