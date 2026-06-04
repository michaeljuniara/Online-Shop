public class MerchantMainMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        String menuTemplate = """
                    1.  Kelola Produk
                    2.  Lihat History Transaksi
                    3.  Keluar Aplikasi
                """;
        System.out.println(menuTemplate);
    }
}
