package org.example.State;

import org.example.Entity.Cart;
import org.example.Entity.CartItem;
import org.example.Entity.User;
import java.util.List;

class CartMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        User user = context.getUser();
        Cart userCart = user.getCart();

        List<CartItem> userCartItems = userCart.getItems();
        String menuTemplate = """
                
                Isi Keranjang:
                (i). Nama produk - Kuantitas - Total Harga
                """;

        int index = 1;

        // tampilkan semua product
        for (CartItem cartItem : userCartItems) {
            menuTemplate += String.format(
                    "%3d. " + cartItem.getProduct().getName() + " - " + cartItem.getQuantity() + " - %.2f\n", index,
                    cartItem.getTotalPrice());
            index++;
        }
        menuTemplate += """
                (i). Lihat Detail
                 0 . Beli
                -1 . Cancel
                """;

        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getSc().nextInt();
                if (selection == 0) {
                    context.setMenuState(new BuyMenu());
                } else if (selection == -1) {
                    context.setMenuState(new BuyerMainMenu());//
                } else if (selection >= 1 && selection <= userCartItems.size()) {
                    int chosenCartItemIndex = selection - 1;// user input untuk melihat detail cartItem
                    CartItem chosenCartItem = userCartItems.get(chosenCartItemIndex);
                    context.setMenuState(new DetailCartItemMenu(userCart, chosenCartItem, chosenCartItemIndex));
                } else {
                    System.out.print("\nMasukkan angka yang valid.\n");
                    context.getSc().nextLine();
                    loop = true;
                }
            } catch (Exception e) {
                System.out.print("\nMasukkan angka yang valid.\n");
                context.getSc().nextLine();
                loop = true;
            }

        } while (loop);
    }
}
