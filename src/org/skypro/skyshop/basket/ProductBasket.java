package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Ошибка: товар не найден.");
            return;
        }

        String productName = product.getProductName();
        List<Product> products = basket.getOrDefault(productName, new ArrayList<>());
        products.add(product);
        basket.put(productName, products);

    }

    public int sumProduct() {
        int total = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    total += product.getProductPrice();
                }
            }
        }
        return total;
    }

    public void printProductBasket() {
        int total = 0;
        int specialCount = 0;

        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            String productName = entry.getKey();
            List<Product> products = entry.getValue();

            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                    total += product.getProductPrice();
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public Map<String, List<Product>> clearProduct(String name) {
        Map<String, List<Product>> result = new HashMap<>();

        if (name == null || name.trim().isEmpty()) {
            return result;
        }
        List<Product> removedProducts = basket.remove(name);

        if (removedProducts != null) {
            result.put(name, removedProducts);
        }

        return result;
    }

    public boolean checkProduct(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return basket.containsKey(name);
    }

    public void clearBasket() {
        basket.clear();
    }

    public int getBasketSize() {
        return basket.size();
    }
}