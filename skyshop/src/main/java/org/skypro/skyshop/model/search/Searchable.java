package org.skypro.skyshop.model.search;
import java.util.Collection;
import java.util.UUID;

public interface Searchable {
    // Геттеры
    String getTitle();
    String getDescription();
    UUID getId();
    String getSearchTerm();
    String getContentType();
    String getName();
    default String getStringRepresentation(){
        return getName() + " - " + getContentType();    }

    Collection<Object> searchTerm();
}
