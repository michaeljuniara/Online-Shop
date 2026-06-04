import java.util.List;

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

    public void buy() {
        Transaction t = new Transaction();
    }
}
