package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new Product("Молоко", 25));
        basket.addProduct(new Product("Хлеб", 12));
        basket.addProduct(new Product("Сыр", 40));
        basket.addProduct(new Product("Яблоки", 30));
        basket.addProduct(new Product("Яйца", 28));

        basket.addProduct(new Product("Сок", 20));

        basket.printProductBasket();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Проверка наличия продукта в корзине");
        System.out.println(basket.checkProduct("Мороженое"));
        System.out.println(basket.checkProduct("Яблоки"));

        System.out.println("---------------------------------------------------------------------------------------");
        basket.clearBasket();
        System.out.println("в корзине пусто");
        basket.printProductBasket();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Проверка наличия продукта в пустой корзине");
        System.out.println(basket.checkProduct("Яблоки"));
    }
}