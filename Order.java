public class Order {
    public enum Status { PACKING, DELIVERING, ARRIVED }

    private Status orderStatus;
    private CartItem item;
    private User buyer, seller;
    private OrderObserver observer;

    public Order(CartItem item, User buyer) {
        this.item = item;
        this.buyer = buyer;
        this.seller = item.getProduct().getOwner();
        observer = buyer;
        setStatus(Status.PACKING);
    }
    
    public void setStatus(Status newStatus) {
        orderStatus = newStatus;
        
        if (observer != null) {
            observer.onStatusChanged(this, orderStatus);
        }
    }

    public void setObserver(OrderObserver observer) {
        this.observer = observer;
    }

    public Status getOrderStatus() { return orderStatus; }
    public CartItem getItem() { return item; }
    public User getBuyer() { return buyer; }
    public User getSeller() { return seller; }
}