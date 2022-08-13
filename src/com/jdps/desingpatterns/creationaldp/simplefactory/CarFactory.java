package com.jdps.desingpatterns.creationaldp.simplefactory;

/*
Created by J.Fırat ©
    Date : 13.08.2022
    Time : 11:50
*/
//Simple Factory Pattern
//key yapısı ile switch case kullanabiliriz.
public class CarFactory {

    public static Car createCar(String type) {
        Car car = null;
        if (type.equals("basic")) {
            car = new BasicCar();
        } else if (type.equals("luxury")) {
            car = new LuxuryCar();
        }else {
            throw new IllegalArgumentException("Invalid car type");
        }
        return car;
    }

    public static Car createCar2(String type) {
        Car car = null;
        switch (type) {
            case "basic":
                car = new BasicCar();
                break;
            case "luxury":
                car = new LuxuryCar();
                break;
            default:
                throw new IllegalArgumentException("Invalid car type");
        }
        return car;
    }
}
