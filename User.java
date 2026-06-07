import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class User {
    private String username;
    private String password;
    private List<Product> products;
    private List<Order> orderHistory;
    private List<Transaction> buyTransactions;
    private List<Transaction> sellTransactions;
    private List<Order> managedOrders;
    //private List<Notification> notifications;
    private Cart shoppingCart;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        products = new ArrayList<>();
        orderHistory = new ArrayList<>();
        buyTransactions = new ArrayList<>();
        sellTransactions = new ArrayList<>();
        managedOrders = new ArrayList<>();
        //notifications = new ArrayList<>();
    }
    
    public void deactivateProduct(int i) {
        products.get(i).deactivate();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // public List<Transaction> getTransactionHistory() {
    //     return transactionHistory;
    // }
    
    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    // public List<Notification> getLiNotifications() {
    //     return notifications;
    // }

    public Cart getCart() {
        return shoppingCart;
    }

    public void newProduct(String name, Category category, String description, double price, int stock) {
        Product p = new Product(name, category, description, price, stock);
        products.add(p);
        ShopDB.addProduct(p);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void editProduct(int i, String name, Category category, String description, double price, int stock) {
        if (i >= 1 && i <= products.size()) {
            Product p = products.get(i - 1);
            p.setName(name);
            p.setCategory(category);
            p.setDescription(description);
            p.setPrice(price);
            p.setStock(stock);
        }
    }
}