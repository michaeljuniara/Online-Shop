public class Order {
    public enum Status {
        PACKING,
        DELIVERED,
        SENT
    }

    private Status orderStatus;
    private CartItem item;
    private User buyer;
    private String address;

    public Order(User buyer, CartItem item, String address) {
        this.buyer = buyer;
        this.item = item;
        this.address = address;
        orderStatus = Status.PACKING;
    }
    
    public void setStatus(Status newStatus) {
        orderStatus = newStatus;
        
        if (orderStatus == Status.SENT) notify();
    }

    private void notify() {
        
    } 
}