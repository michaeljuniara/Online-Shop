package org.example.Composite;

import org.example.Entity.User;

import java.util.List;

public class Product implements CategoryComponent {
    private String name;
    private String description;
    private double price;
    private int stock;
    private boolean active;
    private Category category;
    private User owner;

    public Product(User owner, String name, Category category, String description, double price, int stock) {
        this.owner = owner;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.active = true;//change
    }

    @Override
    public void getProducts(List<Product> list) {
        list.add(this);
    }

    public void deactivate() {
        active = false;
    }

    public boolean tempBuy(int amount) {
        if (stock < amount) return false;
        stock -= amount;
        return true;
    }

    public void cancelBuy(int amount) {
        stock += amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product other = (Product) obj;
        return this.name.equals(other.name) && this.category.equals(other.category) && this.owner.equals(other.owner);
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int amount) {
        if (amount >= 0) stock = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category c) {
        category = c;
    }

    public User getOwner() {
        return owner;
    }
}