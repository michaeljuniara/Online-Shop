package Search;
public class ProductSearchMenu implements MenuState {
    public void execute(AppContext context){
        String menuTemplate = """
                    Cari berdasarkan:
                    1.  Nama
                    2.  Kategori
                    3.  Lihat semua produk
                    4.  Kembali
                """;
        System.out.println(menuTemplate);
        boolean carryon = true;
        while (carryon) {
            try {
                int input = context.sc.nextInt();
                switch (input) {
                    case 1 ->{
                        SearchByName.search(context);
                        carryon = false;
                    }
                    case 2 ->{
                        SearchByCategory.search(context);
                        carryon = false;
                    }
                    case 3 ->{
                        DisplayAllProduct.search(context);
                        carryon = false;
                    }
                    case 4 ->{
                        carryon = true;
                        context.setMenuState(new MerchantMainMenu);
                    }        
                    default ->{
                        System.out.println("Masukan angka yang benar");
                        carryon = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Masukan angka yang benar");
                carryon = true;
            }   
        }
    }
}
