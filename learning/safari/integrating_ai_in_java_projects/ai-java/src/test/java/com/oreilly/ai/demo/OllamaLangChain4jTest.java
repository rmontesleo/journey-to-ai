package com.oreilly.ai.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.service.AiServices;

public class OllamaLangChain4jTest {

    
    private final OllamaChatModel model = OllamaChatModel.builder()            
        .baseUrl("http://localhost:11434")    
        .modelName("llama3.1" )           
        .logRequests(true)
        .logResponses(true)
        .build();

    private final ChatMemory memory = MessageWindowChatMemory.withMaxMessages(20);

    interface Assistant {
        String chat(String message);
    }

    Assistant assistant = AiServices.builder(Assistant.class)
            .chatLanguageModel(model)
            .chatMemory(memory)
            .build();

    

    @Test
    void generateWithString() {
        String answer = model.generate("""
                What is the Ultimate Answer to
                the Ultimate Question of Life,
                the Universe, and Everything?
                """);

        assertTrue(answer.contains("42"));
        System.out.println("Answer: " + answer);
    }

    @Test
    void generateWithMessages() {
        Response<AiMessage> response = model.generate(
                UserMessage.from("""
                        How many roads must a man walk down
                        before ywe call him a man
                        """));

        System.out.println("AI Message is" + response);
        System.out.println("text is " + response.content().text() );
        System.out.println("token usage is " + response.tokenUsage() );
        System.out.println("total token count: " + response.tokenUsage().totalTokenCount() );

    }

    @Test
    void statelessRequests() {
        String firstAnswer = model.generate("""
                My name is Inigo Montoya.
                You killed my father.
                Prepare to die!
                """);

        System.out.println("##### First answer: " + firstAnswer);
        
        String secondAnswer = model.generate(""" 
                What's my name?
                """);
        System.out.println("#### Second answer: " + secondAnswer);

    }


    @Test
    void statefullRequests(){
        String firstAnswer = assistant.chat("Hello!, My name is Klaus.");
        System.out.println("##### First answer: " + firstAnswer);

        String secondAnswer = assistant.chat("What's my name?" );
        System.out.println("#### Second answer: " + secondAnswer);


        String thirdAnswer = assistant.chat("""
                What is the most famous Christopher Nolan movie?
                """ );
        System.out.println("#### Third answer: " + thirdAnswer);
        
        String fourthAnswer = assistant.chat("""
                That movie won any Oscar ?
                """ );
        System.out.println("#### Fourth answer: " + fourthAnswer);         

        String fifthAnswer = assistant.chat("""
                What are the full filmography of this director?
                """ );
        System.out.println("#### Fifth answer: " + fifthAnswer);                 

    }



}
