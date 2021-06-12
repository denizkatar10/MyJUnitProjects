package com.techproed;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day06_JavaFaker {

    @Test
    public void javaFakerTest(){
        // create Faker object
        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
    }
}
