public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CartItem other = (CartItem) obj;
        return this.product.equals(other.product);
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return getProduct().getPrice() * getQuantity(); }

    @Override
    public String toString() {
        return product.getName() + " " + quantity + " " + getTotalPrice(); 
    }
}