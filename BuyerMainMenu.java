class BuyerMainMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        String menuTemplate = """
                1.  Cari Produk
                2.  Lihat Keranjang
                3.  Lihat History Transaksi
                4.  Lihat Notifikasi
                5.  Keluar Aplikasi
                6.  Logout
                """;
        boolean loop = false;
            do {
                loop = false;
                System.out.println(menuTemplate);
                try {
                    int selection = context.sc.nextInt();
                    switch (selection) {
                        case 1 -> {
                            context.setMenuState(new ProductSearchMenu());
                        }
                        case 2 -> {
                            context.setMenuState(new CartMenu());
                        }
                        case 3 -> {
                            context.setMenuState(new OrderHistoryMenu());//
                        }
                        case 4 -> {
                            context.setMenuState(new NotificationsMenu());//
                        }
                        case 5 -> {
                            System.out.println("program exited");
                        }
                        case 6 -> {
                            context.setMenuState(new LoginMenu());//NOT SAFE, NOT ACTUALLY LOGGED OUT
                        }
                        default -> loop = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                
            } while (loop);

    }
}
