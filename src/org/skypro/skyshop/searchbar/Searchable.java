package org.skypro.skyshop.searchbar;

public interface Searchable {
    String searchTerm();

    String contentType();

    String searchName();

    default String getStringRepresentation() {
        return searchName() + " — " + contentType();
    }
}
