package com.jdps.ocp;

import java.util.List;
import java.util.stream.Stream;

/*
Created by J.Fırat ©
    Date : 30.07.2022
    Time : 23:42
*/
//OCP - Open Closed Principle
enum Color {
    RED,
    GREEN,
    BLUE
}

enum Size {
    SMALL,
    MEDIUM,
    LARGE
}

interface Specification<T> {
    boolean isSatisfied(T t);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class Product {
    public String name;
    public double price;
    public Color color;
    public Size size;

    public Product(String name, double price, Color color, Size size) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterByPrice(List<Product> products, double minPrice, double maxPrice) {
        return products.stream().filter(p -> p.price >= minPrice && p.price <= maxPrice);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) {
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
}

class AndSpecification<T> implements Specification<T> {
    private final Specification<T> first;
    private final Specification<T> second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }

}

class BetterFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}


class SizeSpecification implements Specification<Product> {
    private final Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.size == size;
    }
}


class ColorSpecification implements Specification<Product> {
    private final Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.color == color;
    }
}

public class OCPDemo {
    public static void main(String[] args) {
        Product apple = new Product("Apple", 12.0, Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", 12.0, Color.GREEN, Size.LARGE);
        Product house = new Product("House", 12.0, Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products (old):");
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(" - " + p.name + " is green"));

        // ^^ BEFORE

        // vv AFTER
        BetterFilter bf = new BetterFilter();
        System.out.println("Green products (new):");
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.name + " is green"));

        System.out.println("Large products:");
        bf.filter(products, new SizeSpecification(Size.LARGE))
                .forEach(p -> System.out.println(" - " + p.name + " is large"));

        System.out.println("Large blue items:");
        bf.filter(products,
                        new AndSpecification<>(
                                new ColorSpecification(Color.BLUE),
                                new SizeSpecification(Size.LARGE)
                        ))
                .forEach(p -> System.out.println(" - " + p.name + " is large and blue"));
    }
}

