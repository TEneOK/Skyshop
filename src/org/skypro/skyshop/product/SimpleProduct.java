package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException(
                    "товар " + name + " не соответсвует условиям цены"
            );
        }
        this.price = price;
    }


    @Override
    public int getProductPrice() {
        return price;
    }


    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice();
    }
}
