package com.jdps.desingpatterns.creationaldp.builder;

/*
Created by J.Fırat ©
    Date : 6.08.2022
    Time : 12:04
*/

import java.time.LocalDate;

public class Client {
    public static void main(String[] args) {
        User user = createUser();
        //Builder tanımlama
        UserDTOBuilder userDTOBuilder = new UserWebDTOBuilder();
        //directBuild(userDTOBuilder,user);
        UserDTO userDTO=directBuild(userDTOBuilder,user);
        System.out.println(userDTO);
    }
    //Director
    private static UserDTO directBuild(UserDTOBuilder userDTOBuilder , User user) {
        return userDTOBuilder.withFname(user.getFname()).withLname(user.getLname()).withEmail(user.getEmail()).withDob(user.getDob()).withAddress(user.getAddress()).build();
    }
    //Return a sample user
    public static User createUser(){
        User user = new User();
        user.setFname("John");
        user.setLname("Doe");
        user.setEmail("johndoe@gmail.com");
        user.setDob(LocalDate.of(1990,8,8));
        Address address = new Address();
        address.setHouseNo("1");
        address.setStreet("Main Street");
        address.setCity("New York");
        address.setState("NY");
        address.setZip("10001");
        user.setAddress(address);
        return user;
    }
}
