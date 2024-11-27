package com.oreilly.ai.demo;

import java.time.LocalDate;

public record Person( 
    String first,
    String last,
    LocalDate datOfBirth
) {

}
