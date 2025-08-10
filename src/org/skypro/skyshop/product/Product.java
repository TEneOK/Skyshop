package org.skypro.skyshop.product;

public abstract class Product {
    protected final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getProductName() {
        return name;
    }

    public abstract int getProductPrice();

    public boolean isSpecial() {
        return false;
    }
}