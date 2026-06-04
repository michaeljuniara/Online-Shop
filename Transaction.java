import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    public enum Type {
        BUY,
        SELL
    }

    private Type orderType;
    private LocalDate transactionDate;
    private List<Order> orders;
    private double price;
    private User recipient;
    
    public Transaction(LocalDate transactionMade, User recipient, Type orderType) {
        this.transactionDate = transactionMade;
        this.recipient = recipient;
        this.orderType = orderType;
        this.orders = new ArrayList<>();
        this.price = 0.0;
    }

    public void addOrder(Order order) {
        orders.add(order);
        price += order.getItem().getTotalPrice();
    }

    public Type getOrderType() {
        return orderType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public double getPrice() {
        return price;
    }

    public User getRecipient() {
        return recipient;
    }
}
