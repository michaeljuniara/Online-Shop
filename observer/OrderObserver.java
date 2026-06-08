package observer;

public interface OrderObserver {
    public void onStatusChanged(Order order, Order.Status newStatus);
}
