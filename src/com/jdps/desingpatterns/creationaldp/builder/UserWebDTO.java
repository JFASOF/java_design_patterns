package com.jdps.desingpatterns.creationaldp.builder;

/*
Created by J.Fırat ©
    Date : 7.08.2022
    Time : 15:10
*/
//A product in the builder pattern.
//Oluşturucular üzerinden nesneler oluşturur.
public class UserWebDTO implements UserDTO {
    private String fullname;
    private String email;
    private String address;
    private String age;

    public UserWebDTO(String fullname, String email, String address, String age) {
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
