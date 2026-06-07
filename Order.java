public class Order {
    public enum Status {
        PACKING,
        DELIVERED,
        SENT
    }

    private Status orderStatus;
    private CartItem item;

    public Order(CartItem item) {
        this.item = item;
        orderStatus = Status.PACKING;
    }
    
    public void setStatus(Status newStatus) {
        orderStatus = newStatus;
        
        if (orderStatus == Status.SENT) notify();;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public CartItem getItem() {
        return item;
    }

    public void notify() {
        buyer.update(orderStatus.name(), item);
    }
}