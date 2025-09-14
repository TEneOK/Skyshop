package org.skypro.skyshop.searchbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();
    private int size = 0;

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();

        if (query == null || query.isBlank()) {

            return results;
        }

        String lowerQuery = query.toLowerCase();

        for (Searchable item : searchables) {
            if (item != null) {
                String term = item.searchTerm();
                String name = item.searchName();

                if ((term != null && term.toLowerCase().contains(lowerQuery)) ||
                        (name != null && name.toLowerCase().contains(lowerQuery))) {
                    results.put(item.searchName(), item);
                }
            }
        }

        return results;
    }

    public Searchable checkSearch(String search) throws BestResultNotFound {
        Searchable bestVariant = null;
        int maxCount = 0;

        if (search == null || search.isBlank()) {
            throw new BestResultNotFound("Пустой поисковый запрос");
        }

        String lowerSearch = search.toLowerCase();

        for (Searchable item : searchables) {
            if (item != null) {
                String term = item.searchTerm();
                if (term != null) {
                    int count = countOccurrences(term.toLowerCase(), lowerSearch);
                    if (count > maxCount) {
                        maxCount = count;
                        bestVariant = item;
                    }
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
        if (text == null || search == null || search.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }

        return count;
    }
}