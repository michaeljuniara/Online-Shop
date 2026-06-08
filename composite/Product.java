package composite;
import entity.User;
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

    public void getProducts(List<Product> list) { list.add(this); }

    public void deactivate() {
        active = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category c) {
        category = c;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int amount) {
        if (amount >= 0) stock = amount;
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

    public boolean isActive() { return active; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public Category getCategory() { return category; }
    public User getOwner() { return owner; }

    @Override
    public String toString() {
        return name + " " + price + " " + description;
    }
}