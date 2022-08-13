package com.jdps.desingpatterns.creationaldp.simplefactory;

import java.time.LocalDate;

/*
Created by J.Fırat ©
    Date : 13.08.2022
    Time : 12:00
*/
public class BasicCar extends Car{
    private String basicSegment;
    private String basicType;
    private LocalDate basicCreatedDate;

    public String getBasicSegment() {
        return basicSegment;
    }

    public void setBasicSegment(String basicSegment) {
        this.basicSegment = basicSegment;
    }

    public String getBasicType() {
        return basicType;
    }

    public void setBasicType(String basicType) {
        this.basicType = basicType;
    }

    public LocalDate getBasicCreatedDate() {
        return basicCreatedDate;
    }

    public void setBasicCreatedDate(LocalDate basicCreatedDate) {
        this.basicCreatedDate = basicCreatedDate;
    }

}
