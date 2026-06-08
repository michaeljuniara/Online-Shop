package state;

import composite.Category;
import entity.User;
import singleton.ShopDB;

class CreateProductMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        User user = context.getUser();

        System.out.println("Nama?");
        String name = context.getScanner().next();

        System.out.println("Pilih Kategori:");
        // Buka menu pilih kategori
        CategoryPicker cpm = new CategoryPicker();
        cpm.chooseCategory(context);
        Category category = cpm.getChosenCategory();

        System.out.println("Deskripsi?");
        String description = context.getScanner().next();

        System.out.println("Harga?");
        double price = context.getScanner().nextDouble();

        System.out.println("Stok tersedia?");
        int stock = context.getScanner().nextInt();

        // pilihannya adalah untuk buat produk atau kembali ke product management menu
        // (Cancel)
        String menuTemplate = """
                    1.  Create
                    2.  Cancel
                """;
        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getScanner().nextInt();
                switch (selection) {
                    case 1 -> {
                        ShopDB db = ShopDB.getDB();
                        db.addProduct(user, name, category, description, price, stock);
                        System.out.println(db.getActiveProducts().toArray().toString());
                        System.out.println("--------------Product Created!--------------\n");
                        context.setMenuState(new ProductManagementMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new ProductManagementMenu());
                    }

                    default -> loop = true;
                }
            } catch (Exception e) {
                System.out.println(e);
                loop = true;
            }

        } while (loop);
    }
}
