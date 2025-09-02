package org.skypro.skyshop.searchbar;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("Не найдено подходящего результата для поискового запроса: " + search);
    }
}