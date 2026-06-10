import java.util.ArrayList;
import java.util.List;

class ProductSearchMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        String menuTemplate = """

                Pilih metode mencari produk:
                1.  Cari berdasarkan nama
                2.  Cari berdasarkan kategori
                3.  Tampilkan semua produk
                4.  Kembali
                """;

        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);

            try {
                int selection = context.getSc().nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new SearchProductByNameMenu());
                    }

                    case 2 -> {
                        CategoryPicker cpm = new CategoryPicker();
                        cpm.chooseCategory(context);
                        Category chosenCategory = cpm.getChosenCategory();
                        List<Product> productsInChosenCategory = new ArrayList<>();
                        chosenCategory.getProducts(productsInChosenCategory);
                        System.out.println(productsInChosenCategory);
                        //
                        if (productsInChosenCategory.isEmpty()) {
                            System.out.print("\nTidak ada produk di dalam kategori tersebut.\n");
                            context.setMenuState(new ProductSearchMenu());
                        } else {
                            // semua produk dalam category ditampilkan
                            context.setMenuState(new WindowShoppingMenu(productsInChosenCategory));
                        }
                    }
                    case 3 -> {
                        List<Product> allActiveProducts = ShopDB.getDB().getActiveProducts();
                        if (allActiveProducts.isEmpty()) {
                            System.out.print("\nTokopedIAN sedang tidak memiliki produk yang dijual.\n");
                            context.setMenuState(new ProductSearchMenu());
                        } else {
                            // semua produk ditampilkan belum cek ada produk atau tidak
                            context.setMenuState(new WindowShoppingMenu(allActiveProducts));
                        }
                    }
                    case 4 -> {
                        context.setMenuState(new BuyerMainMenu());//
                    }
                    default -> {
                        System.out.println("\nMasukkan angka yang valid.");
                        loop = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("\nMasukkan angka yang valid.");
                loop = true;
            }
        } while (loop);
    }
}
