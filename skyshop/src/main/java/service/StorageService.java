package service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import  java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> availableProducts;
    private final Map<UUID, Article> availableArticles;

    public StorageService() {
        this.availableProducts = new HashMap<>();
        this.availableArticles = new HashMap<>();
        this.createTestData();

    }
    private void createTestData() {
        Product banana = new DiscountedProduct( UUID.randomUUID(),"banana", 500, 10);
        Product apples = new SimpleProduct(UUID.randomUUID(),"Яблоко", 100);
        Product orange = new FixPriceProduct(UUID.randomUUID(),"Апельсин", 200);
        Product laptop = new SimpleProduct(UUID.randomUUID(),"Ноутбук", 50000);
        Product phone = new DiscountedProduct(UUID.randomUUID(),"Iphone 15", 90000, 20);

        Article aboutBananas = new Article(UUID.randomUUID(),"Гайд по выбору бананов" , "Как выбрать спелые бананы и хранить их правильно.");

        Article aboutLaptop = new Article(UUID.randomUUID(),"Скидки на электронику"," Большая распродажа ноутбуков и телевизоров.");

        this.availableArticles.put(aboutBananas.getId(),aboutBananas);

        this.availableArticles.put(aboutLaptop.getId(),aboutLaptop);

        this.availableProducts.put(banana.getId(),banana);
        this.availableProducts.put(apples.getId(),apples);
        this.availableProducts.put(orange.getId(),orange);
         this.availableProducts.put(laptop.getId(),laptop);
        this.availableProducts.put(phone.getId(),phone);
    }
    public Collection<Product> getAllProducts() {
        return availableProducts.values();
    }
    public Collection<Article> getAllArticles() {
        return availableArticles .values();

    }
    public Collection<Searchable> getSearchableItems(){
        List<Searchable> searchableItems = new ArrayList<>();

        searchableItems.addAll(this.availableProducts.values());

        searchableItems.addAll(this.availableArticles.values());

        return searchableItems;
    }
}