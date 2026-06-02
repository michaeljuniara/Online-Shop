import java.util.List;
import java.util.ArrayList;

public class User{
    private String username;
    private String password;
    private List<Product> products;
    private List<Order> orderHistory;
    private List<Transaction> transactionHistory;
    private List<Order> managedOrders;
    private List<Notification> notifications;
    private Cart shoppingCart;

    public User(String username, String password){
        this.username = username;
        this.password = password;

        products = new ArrayList<>();
        orderHistory = new ArrayList<>();
        transactionHistory = new ArrayList<>();
        managedOrders = new ArrayList<>();
        notifications = new ArrayList<>();
    }
    
    public void deactivateProduct(int i){
        products.get(i).deactivate();
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public List<Transaction> getTransactionHistory(){
        return transactionHistory;
    }
    
    public List<Order> getOrderHistory(){
        return orderHistory;
    }

    public List<Notification> getLiNotifications(){
        return notifications;
    }

    public Cart getCart(){
        return shoppingCart;
    }
}