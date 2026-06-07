public interface OrderObserver {
    void onStatusChanged(Order order, Order.Status newStatus);
}
