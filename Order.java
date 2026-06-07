public class Order {
    public enum Status {
        PACKING,
        DELIVERED,
        SENT
    }

    private Status orderStatus;
    private CartItem item;
    private User buyer, seller;

    public Order(CartItem item, User buyer) {
        this.item = item;
        this.buyer = buyer;
        this.seller = item.getProduct().getOwner();
        orderStatus = Status.PACKING;
    }
    
    public void setStatus(Status newStatus) {
        orderStatus = newStatus;
        
        if (orderStatus == Status.SENT) notifyObserver();
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public CartItem getItem() {
        return item;
    }

    public User getBuyer() {
        return buyer;
    }

    public User getSeller() {
        return seller;
    }

    private void notifyObserver() { return; }
}