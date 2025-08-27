package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int fixPrice = 59;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return (name + " : " + "Фиксированная цена " + fixPrice);
    }

    @Override
    public String searchTerm() {
        return "";
    }

    @Override
    public String contentType() {
        return "";
    }

    @Override
    public String getStringRepresentation() {
        return "";
    }

    @Override
    public int getProductPrice() {
        return fixPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

