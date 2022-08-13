package com.jdps.desingpatterns.creationaldp.simplefactory;

/*
Created by J.Fırat ©
    Date : 13.08.2022
    Time : 12:10
*/

public class Client {
    public static void main(String[] args) {
        Car car =CarFactory.createCar("basic");
        System.out.println(car);
        Car car2 =CarFactory.createCar("luxury");
        System.out.println(car2);
    }
}
