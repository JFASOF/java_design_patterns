package com.jdps.srp;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
Created by J.Fırat ©
    Date : 30.07.2022
    Time : 23:39
*/
//SRP - Single Responsibility Principle
class Car {
    private final List<String> carList=new ArrayList<>();

    private static int carCount=0;

    public void addEntry(String carText){
        carList.add("Car "+(++carCount)+" : "+carText);
    }

    public void removeEntry(int index){
        carList.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), carList);
    }

    // here we break SRP
    public void save(String filename) throws Exception
    {
        try (PrintStream out = new PrintStream(filename))
        {
            out.println(toString());
        }
    }

    public void load(String filename) {}
    public void load(URL url) {}

}

class Persistence{
    public void saveToFile(Car car,String filename, boolean overwrite) throws Exception{
        if(overwrite || new File(filename).exists()){
            try(PrintStream out = new PrintStream(filename))
            {
                out.println(car.toString());
            }
        }
    }
    public void load(Car car,String filename) {}
    public void load(Car car,URL url) {}
}


public class SRPDemo{
    public static void main(String[] args) throws IOException {
        Car car = new Car();
        car.addEntry("BMW");
        car.addEntry("Audi");
        car.addEntry("Mercedes");
        car.addEntry("Ferrari");
        car.addEntry("Lamborghini");
        car.addEntry("Porsche");

        Persistence persistence = new Persistence();
        String filename = "cars.txt";
        try {
            persistence.saveToFile(car, filename, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // windows!
        Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}

