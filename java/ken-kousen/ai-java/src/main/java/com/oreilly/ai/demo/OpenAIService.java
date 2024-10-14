package com.oreilly.ai.demo;

import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class OpenAIService {

    private final static String MODEL_ENDPOINT="https://api.openai.com/v1/models";
    private final static String TTS_ENDPOINT="https://api.openai.com/v1/audio/speech";
    private final static String APIKEY=System.getenv("OPENAI_API_KEY");


    //Very Basic gson builder
    private final Gson gson = new Gson();


    // This policy will convert field names to lower case and separate words with underscores
    // in other words, it will convert camel case to snake case
    private final Gson gsonBuilder = new GsonBuilder()
        .setPrettyPrinting()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();


    // The records was created by Claude of Antropic
    public record ModelList(String object, List<Model> data) {}
    public record Model(String id, String object, long created, String ownedBy) {}

    // The records was created by Claude of Antropic, but using another way to serialize the attribute from json
    public record SimpleModelList(String object, List<SimpleModel> data) {}
    public record SimpleModel(
        String id, 
        String object, 
        long created,         
        @SerializedName("owned_by") String ownedBy) {}



    public record TTSRequest(String model, String input, String voice) {}



    
    public Path generateMp3(TTSRequest request){
        try (var client = HttpClient.newHttpClient() ) {
            var body = gson.toJson(request);
            
            var httpPostRequest = HttpRequest.newBuilder()
                .uri( URI.create(TTS_ENDPOINT) )
                .header("Authorization", "Bearer " + APIKEY )
                .header("Content-Type", "application/json")
                .header("Accept", "audio/mpeg")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
            
            Path destination = Path.of("src/main/resources/audio.mp3");    

            var response = client.send( httpPostRequest, 
                HttpResponse.BodyHandlers.ofFile(destination) );
            
            System.out.println("Response code: " + response.statusCode() );
            if( response.statusCode() != 200 ){
                throw new RuntimeException("Failed to get models: " + response.statusCode() );
            }

            return destination;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }




    public String getStringModels(){
        try (var client = HttpClient.newHttpClient() ) {
            var request = HttpRequest.newBuilder()
                .uri( URI.create(MODEL_ENDPOINT) )
                .header("Authorization", "Bearer " + APIKEY )
                .header("Accept", "application/json")
                .build();
            var response = client.send( request, HttpResponse.BodyHandlers.ofString() );

            System.out.println("Response code: " + response.statusCode() );
            if( response.statusCode() != 200 ){
                throw new RuntimeException("Failed to get models: " + response.statusCode() );
            }
            
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        
    }


    public ModelList getJsonModelsByBuilder(){
        try (var client = HttpClient.newHttpClient() ) {
            var request = HttpRequest.newBuilder()
                .uri( URI.create(MODEL_ENDPOINT) )
                .header("Authorization", "Bearer " + APIKEY )
                .header("Accept", "application/json")
                .build();
            var response = client.send( request, HttpResponse.BodyHandlers.ofString() );
            System.out.println("Response code: " + response.statusCode() );
            
            if( response.statusCode() != 200 ){
                throw new RuntimeException("Failed to get models: " + response.statusCode() );
            }

            return gsonBuilder.fromJson( response.body(), ModelList.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }        
    }


    public SimpleModelList getSimpleJsonModelsByGson(){
        try (var client = HttpClient.newHttpClient() ) {
            var request = HttpRequest.newBuilder()
                .uri( URI.create(MODEL_ENDPOINT) )
                .header("Authorization", "Bearer " + APIKEY )
                .header("Accept", "application/json")
                .build();
            var response = client.send( request, HttpResponse.BodyHandlers.ofString() );
            System.out.println("Response code: " + response.statusCode() );
            
            if( response.statusCode() != 200 ){
                throw new RuntimeException("Failed to get models: " + response.statusCode() );
            }

            return gson.fromJson( response.body(), SimpleModelList.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }        
    }


}
