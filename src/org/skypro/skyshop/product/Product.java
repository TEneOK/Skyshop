package org.skypro.skyshop.product;

import org.skypro.skyshop.searchbar.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    protected final String name;

    public Product(String name) {
        if (name.isBlank() || name == null) {
            throw new IllegalArgumentException(
                    "товар " + name + " не соответсвует условиям именования"
            );
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(searchName(), product.searchName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchName());
    }

    @Override
    public abstract String toString();
}