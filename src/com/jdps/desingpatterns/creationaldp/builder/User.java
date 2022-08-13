package com.jdps.desingpatterns.creationaldp.builder;

/*
Created by J.Fırat ©
    Date : 6.08.2022
    Time : 12:02
*/

import java.time.LocalDate;

//Entity
public class User {
    private String fname;
    private String lname;
    private String email;
    private LocalDate dob;
    private Address address;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
