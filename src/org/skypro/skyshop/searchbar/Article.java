package org.skypro.skyshop.searchbar;

public class Article implements Searchable {
    private String articleTitle;
    private String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    @Override
    public String searchTerm() {
        return articleTitle + " " + articleText;
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }

    @Override
    public String searchName() {
        return articleTitle;
    }

    @Override
    public String toString() {
        return "Статья: " + articleTitle + "\n" + articleText;
    }
}
