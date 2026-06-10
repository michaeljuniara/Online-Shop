package org.example.State;

import org.example.Composite.Product;
import org.example.Entity.ShopDB;
import org.example.Entity.User;

import java.util.List;

class RemoveProductMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        User user = context.getUser();
        ShopDB db = ShopDB.getDB();
        String username = user.getUsername();
        List<Product> userProducts = db.getActiveProductByUser(username);

        // list all the active user Products to choose from
        String menuTemplate = "List Produkmu:\n(i).\t(nama produk)\n";

        int index = 1;

        if (userProducts.size() > 0) {
            for (Product product : userProducts) {
                menuTemplate += index + ".\t" + product.getName() + "\n";
                index++;
            }

            menuTemplate += "Pilih produk yang mau dihapus berdasarkan index:\n";
            System.out.println(menuTemplate);

            // input the index of the product
            boolean loop = false;
            Product chosenProduct = null;
            do {
                loop = false;
                try {
                    int chosenIndex = context.getSc().nextInt() - 1;
                    chosenProduct = userProducts.get(chosenIndex);

                } catch (Exception e) {
                    System.out.println(e);
                    loop = true;
                }

            } while (loop);

            if (chosenProduct != null)
                System.out.println("Product yang dipilih :" + chosenProduct.getName());

            //
            menuTemplate = """
                    1. Hapus produk (PERINGATAN: TIDAK BISA DIAKTIFKAN KEMBALI)
                    2. Cancel
                    
                    """;

            loop = false;
            do {
                loop = false;
                System.out.println(menuTemplate);
                try {
                    int selection = context.getSc().nextInt();
                    switch (selection) {
                        case 1 -> {
                            db.deactivateProduct(chosenProduct);
                            System.out.println("-------------PRODUK TERHAPUS----------------");
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
        } else {
            System.out.println("""
                    Anda tidak memiliki produk.
                    Buatlah sebuah produk terlebih dahulu.
                    """);
            context.setMenuState(new ProductManagementMenu());
        }
    }
}
