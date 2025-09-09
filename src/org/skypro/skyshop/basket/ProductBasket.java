package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    LinkedList<Product> basket = new LinkedList<>();

    private int size = 0;

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Ошибка: товар не найден.");
            return;
        }

        basket.add(size, product);
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
        int specialCount = 0;

        for (int i = 0; i < size; i++) {
            Product p = basket.get(i);
            System.out.println(p);

            total += p.getProductPrice();

            if (p.isSpecial()) {
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
                size--;
            }
        }

        return removedProducts;
    }

    public boolean checkProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (name.equalsIgnoreCase(basket.get(i).getProductName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.size(); i++) {
            basket.clear();
        }
        size = 0;
    }

    public int getBasketSize() {
        return basket.size();
    }
}