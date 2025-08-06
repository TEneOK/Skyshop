package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getProductName() {
        return name;
    }

    public int getProductPrice() {
        return price;
    }
}