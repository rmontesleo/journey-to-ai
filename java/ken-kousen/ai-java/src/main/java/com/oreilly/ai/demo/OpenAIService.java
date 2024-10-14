package com.oreilly.ai.demo;

import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenAIService {

    private final static String MODEL_ENDPOINT="https://api.openai.com/v1/models";
    private final static String APIKEY=System.getenv("OPENAI_API_KEY");


    // The records was created by Claude of Antropic
    public record ModelList(String object, List<Model> data) {}
    public record Model(String id, String object, long created, String ownedBy) {}


    //Very Basic gson builder
    //private final Gson gson = new Gson();


    // This policy will convert field names to lower case and separate words with underscores
    // in other words, it will convert camel case to snake case
    private final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();


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


    public ModelList getJsonModels(){
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

            return gson.fromJson( response.body(), ModelList.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } 

        
    }

}
