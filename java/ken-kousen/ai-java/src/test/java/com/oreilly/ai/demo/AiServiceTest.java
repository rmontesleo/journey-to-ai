package com.oreilly.ai.demo;

import org.junit.jupiter.api.Test;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.service.AiServices;

public class AiServiceTest {

    private final String apiKey = System.getenv("OPENAI_API_KEY");

    private final ChatLanguageModel model = OpenAiChatModel.builder()
            .apiKey(apiKey)
            .modelName(OpenAiChatModelName.GPT_4_O_MINI)
            .logRequests(true)
            .logResponses(true)
            .build();

    Assistant assistant = AiServices.builder(Assistant.class)
            .chatLanguageModel(model)
            .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
            .build();

    @Test
    void conversation() {

        String firstAnswer = assistant.chat("""
                My name is Inigo Montoya.
                You killed my father.
                Prepare to die!
                """);

        System.out.println("##### First answer: " + firstAnswer);

        String secondAnswer = assistant.chat("""
                What's my name?
                """);
        System.out.println("#### Second answer: " + secondAnswer);

    }

    @Test
    void sentimentTest() {

        System.out.println("Is this positive 1? " + assistant.isPositive("I am happy"));
        System.out.println("Is this positive 2? " + assistant.isPositive("I am sad"));
        System.out.println("Is this positive 3? " + assistant.isPositive("Estoy cansado"));
        System.out.println("Is this positive 4? " + assistant.isPositive("Estoy a tope"));
        System.out.println("Is this positive 5? " + assistant.isPositive("Estoy canchero"));
    }

    @Test
    void clasifySentimentEnumTest() {

        System.out.println("Sentiment 1: " + assistant.clasify("I am happy"));
        System.out.println("Sentiment 2: " + assistant.clasify("I am sad"));
        System.out.println("Sentiment 3: " + assistant.clasify("Estoy cansado"));
        System.out.println("Sentiment 4: " + assistant.clasify("Estoy a tope"));
        System.out.println("Sentiment 5: " + assistant.clasify("Estoy canchero"));
        System.out.println("Sentiment 6: " + assistant.clasify("I just got up in the morning"));
        System.out.println("Sentiment 7: " + assistant.clasify("Estoy flipando en colores"));

    }

    @Test
    void extractPersonTest() {
        Person person = assistant.extractPerson("""
                Capitain Picard was born on the 13th of juillet
                in the year 2305 in La Barre, France,
                on the family winery, Chateau Picard.
                """);
        System.out.println("Person " + person);
    }

}
