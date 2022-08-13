package com.jdps.desingpatterns.creationaldp.simplefactory;

/*
Created by J.Fırat ©
    Date : 13.08.2022
    Time : 12:00
*/

import java.time.LocalDate;

public class LuxuryCar extends Car {
    private String luxurySegment;
    private String luxuryType;
    private LocalDate luxuryCreatedDate;

    public String getLuxurySegment() {
        return luxurySegment;
    }

    public void setLuxurySegment(String luxurySegment) {
        this.luxurySegment = luxurySegment;
    }

    public String getLuxuryType() {
        return luxuryType;
    }

    public void setLuxuryType(String luxuryType) {
        this.luxuryType = luxuryType;
    }

    public LocalDate getLuxuryCreatedDate() {
        return luxuryCreatedDate;
    }

    public void setLuxuryCreatedDate(LocalDate luxuryCreatedDate) {
        this.luxuryCreatedDate = luxuryCreatedDate;
    }
}
