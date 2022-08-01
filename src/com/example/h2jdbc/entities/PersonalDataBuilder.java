package com.example.h2jdbc.entities;

public class PersonalDataBuilder {

    private final String firstName;
    private final String lastName;
    private String age;

    public PersonalDataBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonalDataBuilder age(String age){
        this.age = age;
        return this;
    }

    public PersonalData build(){
        return new PersonalData(firstName, lastName, age);
    }
}
