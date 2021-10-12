package com.techproed.tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JU_JavaFaker {
    @Test
    public void fakerTest(){

        //1. Create Faker object
        Faker faker = new Faker();

        //2. Generate fake data such as ; firstname, lastname, address, city, state, title...
       String name = faker.name().firstName();
       String lName = faker.name().lastName();
       String fName = faker.name().fullName();
        System.out.println("Name is :" + name );
        System.out.println("Lastname is :" + lName );
        System.out.println("Full name is :" + fName);

        System.out.println(faker.address().country());

        System.out.println(faker.phoneNumber().cellPhone());

        System.out.println(faker.number().digits(5));

        System.out.println(faker.chuckNorris());

        System.out.println(faker.internet().emailAddress());
    }
}
