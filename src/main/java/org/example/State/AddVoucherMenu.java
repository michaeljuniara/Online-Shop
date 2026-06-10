package org.example.State;

import org.example.Entity.Cart;
import org.example.Singleton.ShopDB;
import org.example.Entity.User;
import org.example.Entity.Voucher;

class AddVoucherMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        String menuTemplate = "\nMasukkan kode voucher: ";
        User user = context.getUser();
        Cart userCart = user.getCart();
        boolean loop = false;
        do {
            try {
                loop = false;
                System.out.print(menuTemplate);
                String inputtedCode = context.getSc().next();
                if (userCart.setVoucher(inputtedCode)) {
                    Voucher v = ShopDB.getDB().getVoucher(inputtedCode);
                    context.setMenuState(new CheckOutMenu(v, context));
                } else {
                    System.out.println("\nKode Voucher salah\n");
                    context.setMenuState(new BuyMenu());
                }
            } catch (Exception e) {
                System.out.println("\nKode Voucher salah\n");
                context.setMenuState(new BuyMenu());
            }
        } while (loop);
    }

}
