package org.skypro.skyshop.model.product;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
public class FixPriceProduct extends org.skypro.skyshop.model.product.Product {
    private static final int PRICE = 400;
    private final UUID id;

    public FixPriceProduct(UUID id,String name, int i) {
        super(name);
        this.id = UUID.randomUUID();
    }

    public int getPrice() {
        return PRICE;
    }

    public boolean isSpecial(){
        return true;
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public UUID getId(){
        return id;
    }

    @Override
    public Collection<Object> searchTerm() {
        return List.of();
    }

    @Override
    public String toString() {
        return getName() +
                " с фиксированной ценой: " +
                getPrice();
    }
}