public class CheckOutFacade implements MenuState {
    private Voucher voucher;

    public CheckOutFacade(Voucher voucher) {
        this.voucher = voucher;
    }

    @Override
    public void execute(AppContext context) {
        double diskon = 0;
        if (voucher != null) {
            diskon = voucher.use();
        }
        double totalHarga = context.getUser().getCart().calculateTotal() - diskon;
        String menuTemplate = String
                .format("Detail harga:\n%.2f\nList Metode Pembayaran\n1. BCA\n2. Gopay\n3. QRIS\n4. Kembali",
                        totalHarga);
        boolean loop = false;
        do {
            try {
                loop = false;
                System.out.println(menuTemplate);
                int input = context.getSc().nextInt();
                if (input >= 1 && input <= 3) {
                    context.setMenuState(new PaymentFactory(context, input, totalHarga));
                    context.setMenuState(new BuyerMainMenu());
                } else {
                    loop = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (loop);

    }
}
