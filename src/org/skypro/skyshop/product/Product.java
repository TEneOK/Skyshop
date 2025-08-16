package org.skypro.skyshop.product;

import org.skypro.skyshop.searchbar.Searchable;

public abstract class Product implements Searchable {
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

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String contentType() {
        return "PRODUCT"; // тип контента
    }

    @Override
    public String searchName() {
        return name;
    }

    // toString используем отдельно для корзины (например, "Молоко: 100")
    @Override
    public abstract String toString();
}