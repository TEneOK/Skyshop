package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    List<Product> basket = new LinkedList<>();

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Ошибка: товар не найден.");
            return;
        }

        basket.add(product);

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
        int specialCount = 0;

        for (Product product : basket) {
            System.out.println(product);

            total += product.getProductPrice();

            if (product.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public List<Product> clearProduct(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }

    public boolean checkProduct(String name) {
        for (Product product : basket) {
            if (name.equalsIgnoreCase(product.getProductName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
            basket.clear();
        }

    public int getBasketSize() {
        return basket.size();
    }
}