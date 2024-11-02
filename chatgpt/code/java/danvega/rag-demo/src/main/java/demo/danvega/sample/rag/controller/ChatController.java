package demo.danvega.sample.rag.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder, PgVectorStore vectorStore) {
        this.chatClient = builder                
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore)) 
                .build();
    }


    @GetMapping("/")
    public String chat(){
        String userPrompt ="""
                How did the Federal Reserve's recent interest rate cut impact various asset classes according to the analysis
                """;

        //String userPrompt = "What is the current stock price of AVGO";        

        return chatClient.prompt()
                .user(userPrompt)                
                .call()                
                .content();
    }

}
