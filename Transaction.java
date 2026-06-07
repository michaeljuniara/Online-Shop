import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private LocalDate transactionDate;
    private List<Order> orders;
    private double price;
    
    public Transaction(LocalDate transactionMade) {
        this.transactionDate = transactionMade;
        this.orders = new ArrayList<>();
        this.price = 0.0;
    }

    public void addOrder(Order order) {
        orders.add(order);
        price += order.getItem().getTotalPrice();
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
}
