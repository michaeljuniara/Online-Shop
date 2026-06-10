import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User implements OrderObserver {
    private String username;
    private String password;
    private Cart shoppingCart;

    // buyer & seller
    private List<Transaction> buyTransactions;  // apa yang aku beli
    private List<Order> sellOrders;             // apa yang harus aku kirim
    private List<Notification> notifications;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        shoppingCart = new Cart();

        buyTransactions = new ArrayList<>();
        sellOrders = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    public void addBuyTransaction(Transaction transaction) {
        buyTransactions.add(transaction);
    }

    public void addSellOrder(Order order) {
        sellOrders.add(order);
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User other = (User) obj;
        return username.equals(other.username);
    }

    @Override
    public void onStatusChanged(Order order, Order.Status newStatus) {
        if (newStatus == Order.Status.PACKING) {
            addNotification(new Notification("Order " + order.getItem().getProduct().getName() + "-mu sedang diproses!"));
        }
        else if (newStatus == Order.Status.DELIVERING) {
            addNotification(new Notification("Order " + order.getItem().getProduct().getName() + "-mu sedang dalam pengiriman!"));
        }
        else if (newStatus == Order.Status.ARRIVED) {
            addNotification(new Notification("Order " + order.getItem().getProduct().getName() + "-mu sudah sampai!"));
        }
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; } 
    public Cart getCart() { return shoppingCart; }
    public List<Transaction> getBuyTransactions() { return Collections.unmodifiableList(buyTransactions); }
    public List<Notification> getNotifications() { return Collections.unmodifiableList(notifications); }
    public List<Order> getSellOrders() { return Collections.unmodifiableList(sellOrders); }
}