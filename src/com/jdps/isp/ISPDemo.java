package com.jdps.isp;

/*
Created by J.Fırat ©
    Date : 30.07.2022
    Time : 23:46
*/
//ISP - Interface Segregation Principle
//Nesneler asla ihtiyacı olmayan property/metot vs içeren interfaceleri implement etmeye zorlanmamalıdır
interface Flyable {
    void fly();
}
interface Swimmable {
    void swim();
}
interface Walkable {
    void walk();
}
interface Runable {
    void run();
}
interface Barkable {
    void bark();
}

class Cat implements Barkable {
    public void bark() {
        System.out.println("Meeow");
    }
}
class Dog implements Barkable {
    public void bark() {
        System.out.println("Woof");
    }
}
class Bird implements Flyable, Swimmable, Walkable {
    public void fly() {
        System.out.println("Flying");
    }
    public void swim() {
        System.out.println("Swimming");
    }
    public void walk() {
        System.out.println("Walking");
    }
}
public class ISPDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Bird bird = new Bird();
        cat.bark();
        dog.bark();
        bird.fly();
        bird.swim();
        bird.walk();
    }
}

