package org.skypro.skyshop.searchbar;

public class SearchEngine {
    private Searchable[] items;
    private int size = 0;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size >= items.length) {
            System.out.println("Невозможно добавить элемент массив полен");
            return;
        }
        items[size] = item;
        size++;
    }

    public Searchable[] search(String entered) {
        Searchable[] results = new Searchable[5]; // массив на 5 элементов
        int foundCount = 0;

        if (entered == null || entered.isEmpty()) {
            return results;
        }

        for (int i = 0; i < size; i++) {
            Searchable item = items[i];
            if (item != null && item.searchTerm().contains(entered)) {
                results[foundCount] = item;
                foundCount++;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}
