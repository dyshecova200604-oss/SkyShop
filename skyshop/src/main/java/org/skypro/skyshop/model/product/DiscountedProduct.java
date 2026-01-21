package org.skypro.skyshop.model.product;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class DiscountedProduct extends org.skypro.skyshop.model.product.Product {
    private final UUID id;
    private final int price;
    private final int discountPercent;

    public DiscountedProduct(UUID id,String name, int price, int discountPercent) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100");
        }
        this.id = id;
        this.price = price;
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return this.discountPercent;
    }

    public int getPrice() {
        return (int) (this.price * ((double) 1 - ((double) this.discountPercent / 100)));
    }

    public boolean isSpecial() {
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
                " со скидкой: " + getPrice() +
                " (" + discountPercent +
                "%)";
    }
}