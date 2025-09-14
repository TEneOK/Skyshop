package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchbar.Article;
import org.skypro.skyshop.searchbar.BestResultNotFound;
import org.skypro.skyshop.searchbar.SearchEngine;
import org.skypro.skyshop.searchbar.Searchable;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        SearchEngine engine = new SearchEngine();
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Молоко", 25));
        basket.addProduct(new FixPriceProduct("Хлеб"));
        basket.addProduct(new DiscountedProduct("Сыр", 20, 5));
        basket.addProduct(new SimpleProduct("Яблоки", 30));
        basket.addProduct(new DiscountedProduct("Яйца", 28, 3));


        engine.add(new SimpleProduct("Молоко", 25));
        engine.add(new FixPriceProduct("Хлеб"));
        engine.add(new DiscountedProduct("Молочный коктейл", 220, 5));
        engine.add(new SimpleProduct("Яблоки", 30));
        engine.add(new DiscountedProduct("Шоколадное молоко", 28, 3));

        Article magnit = new Article("Магнит", "Магазин для повседневных нужд");
        Article taxi = new Article("Такси", "Довезут куда угодно за ваши монеты");
        Article sudar = new Article("Сударь", "Магазин для настоящих джентельменов");
        Article milk = new Article("Молочкино", "Поможем выбрать молочный коктейл");
        Article apple = new Article("Яблоня", "Польза яблок и фруктов");

        engine.add(magnit);
        engine.add(taxi);
        engine.add(sudar);
        engine.add(milk);
        engine.add(apple);


        basket.printProductBasket();

        System.out.println("=========================================================================================");
        System.out.println("Демонстрация проверок");
        try {
            Product wrong1 = new SimpleProduct("Хлеб", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product wrong2 = new SimpleProduct("   ", 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product wrong3 = new DiscountedProduct("Сок", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product wrong4 = new DiscountedProduct("Яйца", 0, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

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
        System.out.println("Вывод всех совпадений");
        List<Searchable> allResults = engine.search("Молочный");
        System.out.println("Найдено результатов: " + allResults.size());

        for (Searchable result : allResults) {
            System.out.println(" - " + result.searchName() + " (" + result.contentType() + ")");
        }

        System.out.println("=========================================================================================");
        basket.addProduct(new SimpleProduct("Колбаса", 60));
        basket.addProduct(new FixPriceProduct("Сырок"));
        basket.addProduct(new DiscountedProduct("Сыр косичка", 20, 5));
        basket.addProduct(new SimpleProduct("Жиле", 300));
        basket.addProduct(new DiscountedProduct("Майонез", 28, 3));

        List<Product> removedProducts = basket.clearProduct("Жиле");
        System.out.println("Удаленные продукты:");
        System.out.println(removedProducts);
        System.out.println();

        basket.printProductBasket();

        List<Product> notFoundProduct = basket.clearProduct("Груша");

        if (notFoundProduct.isEmpty()) {
            System.out.println("\nСписок пуст");
        }
        System.out.println();

        basket.printProductBasket();
    }

    private static void printResults(Searchable[] results) {
        for (Searchable s : results) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }
    }
}