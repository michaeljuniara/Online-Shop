import java.time.LocalDate;

public class CheckOutFacade implements MenuState {
    private Voucher voucher;
    private AppContext context;

    public CheckOutFacade(Voucher voucher, AppContext context) {
        this.voucher = voucher;
        this.context = context;
    }

    @Override
    public void execute(AppContext context) {
        double discount = 0;
        if (voucher != null) {
            discount = voucher.use();
        }
        double totalPrice = context.getUser().getCart().calculateTotal() - discount;
        String menuTemplate = String
                .format("\nDetail harga : %.2f\nList Metode Pembayaran\n1. BCA\n2. Gopay\n3. QRIS\n4. Kembali\n",
                        totalPrice);
        boolean loop = false;
        PaymentStrategy ps = null;
        do {
            loop = false;
            try {
                System.out.println(menuTemplate);
                int input = context.getSc().nextInt();
                if (input >= 1 && input <= 3) {
                    ps = PaymentFactory.getPaymentMethod(input);
                    ps.showMetode(totalPrice);
                } else if (input == 4) {
                    context.setMenuState(new CartMenu());
                } else {
                    System.out.println("\nMasukkan angka yang valid.\n");
                    context.getSc().nextLine();
                    loop = true;
                }
            } catch (Exception e) {
                System.out.println("\nMasukkan angka yang valid.\n");
                context.getSc().nextLine();
                loop = true;
            }
        } while (loop);

        if (ps != null) {
            double nominal = -1;
            boolean fail = false;
            try {
                nominal = context.getSc().nextDouble();

            } catch (Exception e) {
                System.out.print("\nMasukkan angka yang valid.\n");
                fail = true;
            }

            boolean pay = ps.pay(totalPrice, nominal);
            if (pay && !fail) {
                updateAll();
                context.setMenuState(new BuyerMainMenu());
            } else {
                context.setMenuState(new CartMenu());
            }
        }
    }

    public void updateAll() {
        User user = context.getUser();
        user.getBuyTransactions().add(new Transaction(user, LocalDate.now()));
    }
}
