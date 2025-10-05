package org.skypro.skyshop.searchbar;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables = new HashSet<>();
    private int size = 0;

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        if (query == null || query.isBlank()) {
            return new TreeSet<>(new SearchableComparator());
        }

        String lowerQuery = query.toLowerCase();

        return searchables.stream()
                .filter(item ->
                        (item.searchTerm() != null && item.searchTerm().toLowerCase().contains(lowerQuery)) ||
                                (item.searchName() != null && item.searchName().toLowerCase().contains(lowerQuery))
                )
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
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

    public Set<Searchable> getAllSearchables() {
        return new HashSet<>(searchables);
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