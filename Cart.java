import java.util.List;
import java.time.LocalDate;

public class Cart {
    private List<CartItem> items;
    private Voucher voucher;

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

    public Voucher getVoucher() {
        return this.voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public void clearItems() {
        this.items.clear();
    }

    public double calculateTotal() {
        double total = 0.0;

        for (CartItem cartItem : items) {
            total += cartItem.getTotalPrice();
        }

        return total;
    }

    public Transaction buy(User recipient) {
        Transaction t = new Transaction(LocalDate.now(), recipient, Transaction.Type.BUY);
    
        for (CartItem cartItem : items) {
            t.addOrder(new Order(cartItem));
        }

        return t;
    }
}
