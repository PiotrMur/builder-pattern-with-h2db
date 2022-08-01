package com.example.h2jdbc.entities;

public class AddressBuilder {

    private final String street;
    private String city;

    public AddressBuilder(String street) {
        this.street = street;
    }

    public AddressBuilder city(String city){
        this.city = city;
        return this;
    }

    public Address build(){
        return new Address(street, city);
    }
}
