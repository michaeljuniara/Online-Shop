package state;

public class BuyerMainMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        String menuTemplate = """
                1.  Cari Produk
                2.  Lihat Keranjang
                3.  Lihat History Transaksi
                4.  Lihat History Pemesanan
                5.  Lihat Notifikasi
                6.  Keluar Aplikasi
                """;
        boolean loop = false;
            do {
                loop = false;
                System.out.println(menuTemplate);
                try {
                    int selection = context.getScanner().nextInt();
                    switch (selection) {
                        case 1 -> {
                            context.setMenuState(new BuyerMainMenu());
                        }
                        case 2 -> {
                            context.setMenuState(new MerchantMainMenu());
                        }
                        case 3 -> {
                            context.setMenuState(new MerchantMainMenu());
                        }
                        case 4 -> {
                            context.setMenuState(new MerchantMainMenu());
                        }
                        case 5 -> {
                            context.setMenuState(new MerchantMainMenu());
                        }
                        case 6 -> {
                            System.out.println("program exited");
                        }
                        default -> loop = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                
            } while (loop);

    }
}
