package com.jdps.desingpatterns.creationaldp.builder;

import java.time.LocalDate;

/*
Created by J.Fırat ©
    Date : 7.08.2022
    Time : 15:13
*/
//Abstract Builder
public interface UserDTOBuilder {
    //methods to build "parts" of product at a time
    UserDTOBuilder withFname(String fname);
    UserDTOBuilder withLname(String lname);
    UserDTOBuilder withEmail(String email);
    UserDTOBuilder withDob(LocalDate dob);
    UserDTOBuilder withAddress(Address address);
    //method to "assemble" the final product
    UserDTO build();
    //(optional) method to fetch already built object (for testing).
    UserDTO getUserDTO();
}
