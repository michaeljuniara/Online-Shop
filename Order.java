public class Order {
    public enum Status { PACKING, DELIVERING, ARRIVED }

    private Status orderStatus;
    private CartItem item;
    private User seller;
    private OrderObserver buyer;

    public Order(CartItem item, User buyer) {
        this.item = item;
        this.buyer = buyer;
        this.seller = item.getProduct().getOwner();
        setStatus(Status.PACKING);
    }
    
    public void setStatus(Status newStatus) {
        orderStatus = newStatus;
        
        if (buyer != null) {
            buyer.onStatusChanged(this, orderStatus);
        }
    }

    public void setObserver(OrderObserver observer) {
        this.buyer = observer;
    }

    public Status getOrderStatus() { return orderStatus; }
    public CartItem getItem() { return item; }
    public User getBuyer() { return (User) buyer; }
    public User getSeller() { return seller; }
}