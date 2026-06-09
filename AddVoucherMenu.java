class AddVoucherMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        String menuTemplate = """
                Masukkan kode voucher:

                """;
        User user = context.getUser();
        Cart userCart = user.getCart();
        boolean loop = false;
        do {
            try {
                loop = false;
                System.out.println(menuTemplate);
                String inputtedCode = context.getSc().next();
                if (userCart.setVoucher(inputtedCode)) {
                    Voucher v = ShopDB.getDB().getVoucher(inputtedCode);
                    context.setMenuState(new CheckOutFacade(v));
                } else {
                    System.out.println("Kode Voucher salah, coba lagi:");
                    context.setMenuState(new BuyMenu());
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (loop);

    }

}
