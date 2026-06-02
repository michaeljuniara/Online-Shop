import java.util.List;

public class Product implements CategoryComponent{
    private String name;
    private String description;
    private double price;
    private int stock;
    private boolean active;
    private Category category;

    public void getProducts(List<Product> list){
        list.add(this);
    }

    public boolean isActive(){
        return active;
    }

    public void deactivate(){
        active = false;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(Category c){
        category.removeProduct(this);
        category = c;
        c.add(this);
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void addStock(int amount){
        if (amount > 0) stock += amount;
    }

    public void getStock(){
        return stock;
    }

    public boolean tempBuy(int amount){
        if (stock < amount) return false;
        stock -= amount;
        return true;
    }

    public void cancelBuy(int amount){
        stock += amount;
    }
}