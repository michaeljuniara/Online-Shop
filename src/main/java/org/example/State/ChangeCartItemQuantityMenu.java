package org.example.State;

import org.example.Entity.Cart;
import org.example.Entity.CartItem;

class ChangeCartItemQuantityMenu implements MenuState {
    private Cart userCart;
    private CartItem cartItem;
    private int cartItemIndex;

    public ChangeCartItemQuantityMenu(Cart userCart, CartItem cartItem, int cartItemIndex) {
        this.userCart = userCart;
        this.cartItem = cartItem;
        this.cartItemIndex = cartItemIndex;
    }

    @Override
    public void execute(AppContext context) {
        String menuTemplate = """
                Stok produk penjual saat ini 
                """;
        menuTemplate += cartItem.getProduct().getStock();
        menuTemplate += "stok\n\n";
        menuTemplate += "Isi kuantitas:\n";
        int newQuantity = 0;
        boolean loop = false;

        do {
            loop = false;
            System.out.println(menuTemplate);
            newQuantity = context.getSc().nextInt();
            if (newQuantity > cartItem.getProduct().getStock()) {
                loop = true;
                System.out.println("Kuantitas masih terlalu banyak");
            }
        } while (loop);

        //efektif "edit kuantitas"
        userCart.removeItem(this.cartItemIndex);
        userCart.addItem(cartItem.getProduct(), newQuantity);
        context.setMenuState(new CartMenu());
    }
}
