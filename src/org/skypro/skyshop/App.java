package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Молоко", 25));
        basket.addProduct(new FixPriceProduct("Хлеб"));
        basket.addProduct(new FixPriceProduct("Сыр"));
        basket.addProduct(new SimpleProduct("Яблоки", 30));
        basket.addProduct(new DiscountedProduct("Яйца", 28, 3));

        basket.addProduct(new SimpleProduct("Сок", 20));

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