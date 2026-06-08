package observer;

import entity.*;

public class Order implements OrderSubject {
    public enum Status { PACKING, DELIVERING, ARRIVED }

    private Status orderStatus;
    private CartItem item;
    private OrderObserver buyer;
    private Transaction parentTransaction;

    public Order(CartItem item, Transaction parentTransaction) {
        this.item = item;
        this.parentTransaction = parentTransaction;

        setObserver(parentTransaction.getBuyer());
        setStatus(Status.PACKING);
    }
    
    public void setStatus(Status newStatus) {
        orderStatus = newStatus;
        
        if (buyer != null) notifyObserver();
    }

    @Override
    public void notifyObserver() {
        buyer.onStatusChanged(this, orderStatus);
    }

    @Override
    public void setObserver(OrderObserver observer) {
        this.buyer = observer;
    }

    public Status getOrderStatus() { return orderStatus; }
    public CartItem getItem() { return item; }
    public User getBuyer() { return parentTransaction.getBuyer(); }
    public User getSeller() { return item.getProduct().getOwner(); }
    public Transaction getParentTransaction() { return parentTransaction; }
}