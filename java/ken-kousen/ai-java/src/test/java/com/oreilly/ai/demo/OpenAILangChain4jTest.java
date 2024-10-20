package com.oreilly.ai.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dev.langchain4j.data.image.Image;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.image.ImageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiImageModel;
import dev.langchain4j.model.openai.OpenAiImageModelName;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.service.AiServices;

public class OpenAILangChain4jTest {

    private final String apiKey = System.getenv("OPENAI_API_KEY");
    
    private final OpenAiChatModel model = OpenAiChatModel.builder()
            .apiKey(apiKey)
            .modelName(OpenAiChatModelName.GPT_4_O_MINI)
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
    void useo1Mini(){
        //OpenAiChatModelName.GPT_4_O_MINI
        OpenAiChatModel model = OpenAiChatModel.builder()
            .apiKey(apiKey)
            .modelName(OpenAiChatModelName.GPT_4_O_MINI)
            .build();

        String anwer = model.generate("Tell me how Java is awesome?");
        System.out.println("Answer: " + anwer);
    }            


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

    @Test
    void imageGeneration(){

        ImageModel model = OpenAiImageModel.builder()
            .apiKey(apiKey)
            .modelName( OpenAiImageModelName.DALL_E_3 )
            .logRequests(true)
            .logResponses(true)
            .build();

        
        String userMessage = """
                        A warrior cat riding into battle
                        on the back of a giant squirrel
                        """;    
        Response<Image> response = model.generate(userMessage);
        System.out.println("### Image URL: " + response.content().url() );
        System.out.println("Token usage: " + response.tokenUsage() );
        //System.out.println("Revised prompt: " + response.content().revisedPrompt() );
                
                


    }



}
