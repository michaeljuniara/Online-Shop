package org.example.Observer;

public interface OrderObserver {
    public void onStatusChanged(Order order, Order.Status newStatus);
}
