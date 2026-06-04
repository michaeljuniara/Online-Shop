public class BuyerMainMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        String menuTemplate = """
                    1.  Cari Produk
                    2.  Lihat Keranjang
                    3.  Lihat History Transaksi
                    4.  Lihat History Pemesanan
                    5.  Keluar Aplikasi
                """;
        System.out.println(menuTemplate);

    }
}
