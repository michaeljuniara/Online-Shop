class AddVoucherMenu implements MenuState{
    @Override
    public void execute(AppContext context){
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
                String inputtedCode = context.sc.next();
                if (userCart.setVoucher(inputtedCode)){
                    context.setMenuState(new CheckOutFacade());
                }else{
                    loop = true;
                    System.out.println("Kode Voucher salah, coba lagi:");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (loop);

    }

}
