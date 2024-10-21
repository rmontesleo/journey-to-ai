package com.oreilly.ai.demo;

import dev.langchain4j.service.UserMessage;

public interface Assistant {
    String chat(String message);

    @UserMessage("Does {{it}} has a positive sentiment?")
    boolean isPositive(String text);

    @UserMessage("Classify {{it}} by the Sentiment enum")
    Sentiment clasify(String text);

    @UserMessage("Extract a Person instance from {{it}}")
    Person extractPerson(String text);



}
