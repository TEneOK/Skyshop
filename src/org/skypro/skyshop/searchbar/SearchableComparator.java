package org.skypro.skyshop.searchbar;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable item1, Searchable item2) {
        String name1 = item1.searchName();
        String name2 = item2.searchName();

        int lengthCompare = Integer.compare(name2.length(), name1.length());

        if (lengthCompare != 0) {
            return lengthCompare;
        }

        return name1.compareTo(name2);
    }
}