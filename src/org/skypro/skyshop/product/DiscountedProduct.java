package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int price;
    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        int discountedPrice = getProductPrice() * (100 - discount) / 100;
        return getProductName() + ": " + discountedPrice + " (" + discount + "%)";
    }

    @Override
    public int getProductPrice() {
        return price - discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
