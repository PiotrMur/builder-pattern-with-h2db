package com.example.h2jdbc.entities;

public class Employee {

    private final PersonalData personalData;
    private final Address address;

    public Employee(PersonalData personalData, Address address) {
        this.personalData = personalData;
        this.address = address;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return personalData + " " + address;
    }
}
