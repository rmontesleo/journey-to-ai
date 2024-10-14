package com.oreilly.ai.demo;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class OpenAIServiceTest {


    private OpenAIService service = new OpenAIService();

    @Test
    void testGetModels(){
        String models = service.getStringModels();
        System.out.println(models);
        assertNotNull(models);
        assertTrue(models.contains("davinci"));
    }


    @Test
    void testJsonGetModels(){
           OpenAIService.ModelList models = service.getJsonModels();
            System.out.println(models);
            assertNotNull(models);
            assertTrue(models.data().size() > 0);        
            models.data().forEach(System.out::println);

            models.data().stream()
                .sorted( Comparator.comparing( OpenAIService.Model::id ) )
                .forEach(System.out::println);


    }


}
