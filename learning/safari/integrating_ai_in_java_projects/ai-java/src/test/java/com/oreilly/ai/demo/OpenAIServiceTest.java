package com.oreilly.ai.demo;

import java.util.Comparator;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.oreilly.ai.demo.OpenAIService.TTSRequest;
import static com.oreilly.ai.demo.OpenAIService.*;


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
           OpenAIService.ModelList models = service.getJsonModelsByBuilder();
            System.out.println(models);
            assertNotNull(models);
            assertTrue(models.data().size() > 0);        
            models.data().forEach(System.out::println);

            models.data().stream()
                .sorted( Comparator.comparing( Model::id ) )
                .forEach(System.out::println);

    }

    @Test
    void testSimpleJsonGetModels(){
           SimpleModelList models = service.getSimpleJsonModelsByGson();
            System.out.println(models);
            assertNotNull(models);
            assertTrue(models.data().size() > 0);        
            models.data().forEach(System.out::println);

            models.data().stream()
                .sorted( Comparator.comparing( SimpleModel::id ) )
                .forEach(System.out::println);
    }

    
    // This test was generated by chatgpt, and modify by myself
    @Test
    void testGenerateMp3() {
        TTSRequest request = new TTSRequest(
            "tts-1", 
            """
            Now that I know how to generate an audio file,
            I can use it to add the ability to convert
            text to speech to any existing Java system.
            THIS IS SPARTA !!!!!
            """, 
            "fable" );
        
        Path path = service.generateMp3(request);
        assertNotNull(path);
        assertTrue( path.toFile().exists() );
        assertTrue( Files.exists(path) );
        assertTrue( path.toString().endsWith("audio.mp3"));
        System.out.println("Generated MP3 file: " + path );

        try {
            long fileSize = Files.size(path);
            assertTrue(fileSize > 0, "Generated MP3 file should not be empty");
        } catch (IOException e) {
            fail("Failed to read the generated MP3 file");
        }
    }




}
