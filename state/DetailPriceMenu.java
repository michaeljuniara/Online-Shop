package state;

import factory.PaymentFactory;
import observer.Order;
import strategy.PaymentStrategy;
import entity.Cart;
import entity.CartItem;
import entity.Transaction;
import entity.Voucher;
import java.time.LocalDate;

public class DetailPriceMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        Cart userCart = context.getUser().getCart();
        double totalPrice = userCart.calculateTotal();

        String menuTemplate = String.format(
                "Detail harga\n%s\nList Metode Pembayaran\n1. BCA\n2. Gopay\n3.QRIS\n4. Cancel",
                totalPrice);
        boolean carryon = true;
        while (carryon) {
            carryon = false;
            try {
                int input = context.getScanner().nextInt();

                if (1 <= input && input <= 4) {
                    PaymentStrategy pay = PaymentFactory.createPayment(input);
                    
                    if (pay != null) {
                        pay.pay();
                        Transaction newTransaction = new Transaction(context.getUser(), LocalDate.now());

                        for (CartItem item : userCart.getItems()) {
                            newTransaction.addOrder(new Order(item, newTransaction));
                        }

                        userCart.clearCart();
                    }
                    
                    context.setMenuState(new BuyerMainMenu());
                } 
                else {
                    carryon = true;
                    System.out.println("Masukan angka yang valid");
                }
            } catch (Exception e) {
                carryon = true;
                System.out.println("Masukan angka yang valid");
            }
        }

        System.out.println(menuTemplate);
    }

}
