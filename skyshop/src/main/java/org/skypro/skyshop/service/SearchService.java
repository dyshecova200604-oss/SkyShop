package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import  org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.Collection;
@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService){
        this.storageService = storageService;
    }
    public Collection<SearchResult> search(String pattern) {
        return this.storageService.getSearchableItems()
                .stream()
                .filter( searchable -> searchable.getSearchTerm().contains(pattern))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}