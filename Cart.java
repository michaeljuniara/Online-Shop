import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private Voucher voucher;

    public Cart() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Product product, int quantity) {
        CartItem ci = new CartItem(product, quantity);

        items.add(ci);
    }

    public boolean removeItem(int itemNumber) {
        if (itemNumber < 0 || itemNumber >= items.size()) return false;

        items.remove(itemNumber);
        return true;
    }

    public boolean setVoucher(String code) {
        Voucher v = ShopDB.getDB().getVoucher(code);

        if (v != null) {
            this.voucher = v;
            
            return true;
        } else return false;
    }

    public void clearCart() {
        this.items.clear();
    }

    public double calculateTotal() {
        double total = 0.0;

        for (CartItem cartItem : items) {
            total += cartItem.getTotalPrice();
        }

        return total;
    }

    public List<CartItem> getItems() { return Collections.unmodifiableList(this.items); }
    public Voucher getVoucher() { return voucher; }
}
