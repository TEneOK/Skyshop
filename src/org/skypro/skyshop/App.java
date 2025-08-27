package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchbar.Article;
import org.skypro.skyshop.searchbar.SearchEngine;
import org.skypro.skyshop.searchbar.Searchable;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine(9);
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Молоко", 25));
        basket.addProduct(new FixPriceProduct("Хлеб"));
        basket.addProduct(new DiscountedProduct("Сыр", 220, 5));
        basket.addProduct(new SimpleProduct("Яблоки", 30));
        basket.addProduct(new DiscountedProduct("Яйца", 28, 3));

        basket.addProduct(new SimpleProduct("Сок", 20));

        engine.add(new SimpleProduct("Молоко", 25));
        engine.add(new FixPriceProduct("Хлеб"));
        engine.add(new DiscountedProduct("Сыр", 220, 5));
        engine.add(new SimpleProduct("Яблоки", 30));
        engine.add(new DiscountedProduct("Яйца", 28, 3));

        Article magnit = new Article("Магнит", "Магазин для повседневных нужд");
        Article taxi = new Article("Такси", "Довезут куда угодно за ваши монеты");
        Article sudar = new Article("Сударь", "Магазин для настоящих джентельменов");

        engine.add(magnit);
        engine.add(taxi);
        engine.add(sudar);

        basket.printProductBasket();

        System.out.println("=========================================================================================");
        System.out.println("Проверка наличия продукта в корзине");
        System.out.println(basket.checkProduct("Мороженое"));
        System.out.println(basket.checkProduct("Яблоки"));

        System.out.println("=========================================================================================");
        basket.clearBasket();
        System.out.println("в корзине пусто");
        basket.printProductBasket();
        System.out.println("=========================================================================================");
        System.out.println("Проверка наличия продукта в пустой корзине");
        System.out.println(basket.checkProduct("Яблоки"));

        System.out.println("=========================================================================================");
        System.out.println("Поиск по слову 'Mагнит':");
        printResults(engine.search("Магнит"));

        System.out.println("\nПоиск по слову 'Такси':");
        printResults(engine.search("Такси"));

        System.out.println("\nПоиск по слову 'джентельменов':");
        printResults(engine.search("джентельменов"));

        System.out.println("\nПоиск по слову 'php':");
        printResults(engine.search("php"));
    }

    private static void printResults (Searchable[]results) {
        for (Searchable s : results) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }
    }
}