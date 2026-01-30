package org.skypro.skyshop.model.product;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
public class SimpleProduct extends Product {
    private final UUID id;
    private final double price;
    public SimpleProduct(UUID id, String name, double price) {
        super(name);

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.id = UUID.randomUUID();
        this.price = price;

    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    public int getPrice() {
        return (int) price;
    }

    @Override
    public String toString() {
        return getName() +
                ": " +
                price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SimpleProduct)) return false;
        SimpleProduct other = (SimpleProduct) obj;
        return Double.compare(other.price, price) == 0 && getName().equals(other.getName());
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
    public int hashCode() {
        return java.util.Objects.hash(getName(), price);
    }
}