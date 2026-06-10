package org.example.State;

import org.example.Composite.Category;
import org.example.Singleton.ShopDB;
import org.example.Entity.User;

class CreateProductMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        User user = context.getUser();

        System.out.print("Nama: ");
        context.getSc().nextLine();
        String name = context.getSc().nextLine();

        System.out.println("Pilih Kategori:");
        // Buka menu pilih kategori
        CategoryPickerMenu cpm = new CategoryPickerMenu();
        cpm.chooseCategory(context);
        Category category = cpm.getChosenCategory();

        System.out.print("\nDeskripsi: ");
        context.getSc().nextLine();
        String description = context.getSc().nextLine();

        System.out.print("Harga: ");
        double price = context.getSc().nextDouble();

        System.out.print("Stok tersedia: ");
        int stock = context.getSc().nextInt();

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
                int selection = context.getSc().nextInt();
                switch (selection) {
                    case 1 -> {
                        ShopDB db = ShopDB.getDB();
                        db.addProduct(user, name, category, description, price, stock);
                        System.out.println("--------------Product Created!--------------\n");
                        context.setMenuState(new ProductManagementMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new ProductManagementMenu());
                    }

                    default -> {
                        System.out.print("\nMasukkan angka yang valid.\n");
                        context.getSc().nextLine();
                        loop = true;
                    }
                }
            } catch (Exception e) {
                System.out.print("\nMasukkan angka yang valid.\n");
                context.getSc().nextLine();
                loop = true;
            }

        } while (loop);
    }
}
