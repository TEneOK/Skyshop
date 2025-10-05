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
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getProductPrice)
                .sum();
    }

    public void printProductBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(product ->
                        System.out.println(product.getProductName() + ": " + product.getProductPrice())
                );

        int specialCount = getSpecialCount();
        System.out.println("Итого: " + sumProduct());
        System.out.println("Количество специальных продуктов: " + specialCount);
    }

    private int getSpecialCount() {
        return (int) basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
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