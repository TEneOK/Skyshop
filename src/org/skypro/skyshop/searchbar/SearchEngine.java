package org.skypro.skyshop.searchbar;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();
    private int size = 0;

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();

        if (query == null || query.isBlank()) {
            return results;
        }
        return results;
    }

    public Searchable checkSearch(String search) throws BestResultNotFound {
        Searchable bestVariant = null;
        int maxCount = 0;

        for (Searchable item : searchables) {
            if (item != null) {
                String term = item.searchTerm();
                int count = countOccurrences(term, search);
                if (count > maxCount) {
                    maxCount = count;
                    bestVariant = item;
                }
            }
        }

        if (bestVariant == null) {
            throw new BestResultNotFound(search);
        }

        return bestVariant;
    }

    public List<Searchable> getAllSearchables() {
        return new ArrayList<>(searchables);
    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }

        return count;
    }
}