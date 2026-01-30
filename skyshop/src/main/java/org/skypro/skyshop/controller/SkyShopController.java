
package org.skypro.skyshop.controller;


import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SearchService;
import service.StorageService;

import java.util.Collection;

@RestController
@RequestMapping("/shop")
public class SkyShopController {
    private final SearchService searchService;
    private final StorageService storageService;

    public SkyShopController (StorageService storageService,
                             SearchService searchService,
                             BasketService basketService) {
        this.searchService = searchService;
        this.storageService = storageService;

    }

    @GetMapping("/search")
    public Collection<SearchResult> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getAllProducts();
    }

    // Метод для получения всех статей
    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getAllArticles();
    }
}