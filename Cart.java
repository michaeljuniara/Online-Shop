import java.util.List;
import java.util.ArrayList;

public class Cart {
    private List<CartItem> items;

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return this.items;
    }
    
    public void addItem(CartItem item) {
        this.items.add(item);
    }

    public boolean removeItem(int itemNumber) {
        if (itemNumber < 0 || itemNumber >= items.size()) return false;

        items.remove(itemNumber);
        return true;
    }

    public void clear() {
        this.items.clear();
    }

    public double calculateTotal() {
        double total = 0.0;

        for (CartItem cartItem : items) {
            total += cartItem.getTotalPrice();
        }

        return total;
    }
}
