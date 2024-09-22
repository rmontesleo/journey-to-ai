package com.example.gen.ai.ollama.demo.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamaAiService {
    
    @Autowired
    private OllamaChatModel chatModel;


    public String generateResult(String promptMessage) {
        ChatResponse response = chatModel.call(
            new Prompt(promptMessage,
            OllamaOptions.create()
                .withModel("llama2")
        ));

        return response.getResult().getOutput().getContent();
    }

    public String generateResultBuilder(String promptMessage) {
        ChatResponse response = chatModel.call(
            new Prompt( promptMessage,
            OllamaOptions.builder()
                .withModel(OllamaModel.LLAMA3_1)
                .withTemperature(0.4F)
                .build()
            ));

        return response.getResult().getOutput().getContent();
    }

}
