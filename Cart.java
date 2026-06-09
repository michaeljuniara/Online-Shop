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
        if (product.tempBuy(quantity)){
            if(product.getStock() <= 0) product.deactivate();
            items.add(ci);
        }
        
        
    }

    public boolean removeItem(int itemNumber) {
        if (itemNumber < 0 || itemNumber >= items.size()) return false;
        CartItem chosenCartitem = items.get(itemNumber);
        chosenCartitem.getProduct().cancelBuy(chosenCartitem.getQuantity());
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
        for (CartItem cartItem : items) {
            cartItem.getProduct().cancelBuy(cartItem.getQuantity());
        }
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
