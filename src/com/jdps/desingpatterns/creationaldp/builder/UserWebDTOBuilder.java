package com.jdps.desingpatterns.creationaldp.builder;

import java.time.LocalDate;
import java.time.Period;

/*
Created by J.Fırat ©
    Date : 7.08.2022
    Time : 15:25
*/
public class UserWebDTOBuilder implements UserDTOBuilder{

    private String firstName;
    private String lastName;
    private String age;
    private String email_i;
    private String address;
    private UserWebDTO userWebDTO;

    @Override
    public UserDTOBuilder withFname(String fname) {
        firstName = fname;
        return this;
    }

    @Override
    public UserDTOBuilder withLname(String lname) {
        lastName = lname;
        return this;
    }

    @Override
    public UserDTOBuilder withEmail(String email) {
        email_i= email;
        return this;
    }

    @Override
    public UserDTOBuilder withDob(LocalDate dob) {
        Period age_i = Period.between(dob, LocalDate.now());
        age = Integer.toString(age_i.getYears());
        return this;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        this.address = address.getHouseNo()+", "+address.getStreet()+", "+address.getCity()+", "+address.getState()+", "+address.getZip();
        return this;
    }

    @Override
    public UserDTO build() {
        userWebDTO = new UserWebDTO(firstName+" "+lastName,age,email_i,address);
        return userWebDTO;
    }

    @Override
    public UserDTO getUserDTO() {
        return null;
    }
}
