package com.nas.common;

public class PersonName {
    private String firstName;
    private String lastName;


    public PersonName(){

    }

    public PersonName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}