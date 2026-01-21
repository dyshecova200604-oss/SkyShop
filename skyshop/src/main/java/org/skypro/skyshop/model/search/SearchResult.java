package org.skypro.skyshop.model.search;

public class SearchResult {
    private final String title;
    private final String description;
    public SearchResult(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // Метод для создания SearchResult из Searchable
    public static SearchResult fromSearchable(Searchable searchable) {
        // Предположим, что у Searchable есть методы getTitle() и getDescription()
        String title = searchable.getTitle();
        String description = searchable.getDescription();

        return new SearchResult(title, description);
    }
}