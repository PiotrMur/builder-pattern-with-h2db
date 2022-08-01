package com.example.h2jdbc.entities;

public class PersonalData {

    private final String firstName;
    private final String lastName;
    private String age;

    public PersonalData(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return " " + firstName + " " + lastName + " " + age;
    }
}
