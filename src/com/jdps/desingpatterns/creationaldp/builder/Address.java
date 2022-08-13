package com.jdps.desingpatterns.creationaldp.builder;

/*
Created by J.Fırat ©
    Date : 6.08.2022
    Time : 12:04
*/
public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;
    private String houseNo;

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
