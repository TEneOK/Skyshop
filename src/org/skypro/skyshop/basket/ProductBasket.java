package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private Product[] basket = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Ошибка: товар не найден.");
            return;
        }

        if (size >= basket.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }

        basket[size] = product;
        size++;
    }

    public int sumProduct() {
        int total = 0;
        for (Product product : basket) {
            if (product != null) {
                total += product.getProductPrice();
            }
        }
        return total;
    }

    public void printProductBasket() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            Product p = basket[i];
            System.out.println(p.getProductName() + ": " + p.getProductPrice());
            total += p.getProductPrice();
        }
        System.out.println("Итого: " + total);
    }

    public boolean checkProduct(String name) {
        if (name == null) {
            return false;
        }
        return true;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
        size = 0;
    }
}