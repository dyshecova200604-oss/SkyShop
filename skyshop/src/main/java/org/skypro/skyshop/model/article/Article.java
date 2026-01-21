package org.skypro.skyshop.model.article;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.skypro.skyshop.model.search.Searchable;

public class Article implements Searchable {
    private final UUID id;
    private final String title;
    private final String text;

    public Article(UUID id, String title, String text) {
        this.title = title;
        this.text = text;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getSearchTerm() {
        return title + " " +
                text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return getTitle();
    }

    @Override
    public Collection<Object> searchTerm() {
        return List.of();
    }

    @Override
    public String toString() {
        return title + ": " +
                text;
    }
}