package org.example.State;

import org.example.Composite.Product;

import java.util.List;

class WindowShoppingMenu implements MenuState {

    List<Product> productList;

    public WindowShoppingMenu(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void execute(AppContext context) {
        // User user = context.getUser();
        // ShopDB db = ShopDB.getDB();
        // String username = user.getUsername();
        // List<Product> userProducts = db.getActiveProductByUser(username);

        // list all the active user Products to choose from
        String menuTemplate = "\nList Produk:\n(i).\t(nama produk)\n";

        int index = 1;

        for (Product product : this.productList) {
            menuTemplate += index + ".\t" + product.getName() + "\n";
            index++;
        }

        menuTemplate += "Pilih (i) dari list produk:";
        System.out.print(menuTemplate);

        // input the index of the product
        boolean loop = false;
        Product chosenProduct = null;
        do {
            loop = false;
            try {
                int chosenIndex = context.getSc().nextInt() - 1;
                chosenProduct = this.productList.get(chosenIndex);

            } catch (Exception e) {
                System.out.println(e);
                loop = true;
            }

        } while (loop);

        if (chosenProduct != null)
            System.out.println("\nProduk yang dipilih: " + chosenProduct.getName());

        menuTemplate = """
                1. Lihat Detail Produk
                2. Kembali
                """;

        loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getSc().nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new PutProductInCartMenu(chosenProduct));//
                    }
                    case 2 -> {
                        context.setMenuState(new ProductSearchMenu());//
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
        // index produk sudah terpilih, sekarang beneran dimasukkan ke cart
    }

}
