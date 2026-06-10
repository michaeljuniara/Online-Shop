package org.example.Observer;

public interface OrderSubject {
    public void setObserver(OrderObserver observer);

    public void notifyObserver();
}
