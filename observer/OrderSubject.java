package observer;

public interface OrderSubject {
    public void setObserver(OrderObserver observer);
    public void notifyObserver();
}
