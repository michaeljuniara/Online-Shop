package org.example.State;

import org.example.Composite.Product;
import org.example.Singleton.ShopDB;

import java.util.List;

class SearchProductByNameMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        String menuTemplate = "\nInput Nama Produk : ";

        boolean loop = false;
        do {
            loop = false;
            System.out.print(menuTemplate);

            try {
                String potentialProductName = context.getSc().next();
                List<Product> productsByName = ShopDB.getDB().getActiveProducts(potentialProductName);
                if (!productsByName.isEmpty()) {
                    context.setMenuState(new WindowShoppingMenu(productsByName));
                } else {//edge case tidak ada produk dengan nama yang diinput user
                    System.out.println("\nBarang tidak ditemukan\n");
                    context.setMenuState(new ProductSearchMenu());
                }
            } catch (Exception e) {
                System.out.println("\nBarang tidak ditemukan\n");
                context.setMenuState(new ProductSearchMenu());
            }

        } while (loop);


    }
}
