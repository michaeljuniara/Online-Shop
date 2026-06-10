package org.example.State;

import org.example.Composite.Category;
import org.example.Entity.ShopDB;
import java.util.List;

class CategoryPickerMenu {
    private Category chosenCategory;

    public void chooseCategory(AppContext context) {
        ShopDB db = ShopDB.getDB();
        String menuTemplate = "\nBerikut adalah semua kategori untuk dipilih:\n(i).\t (kategori)\n";
        // list the categories to choose
        List<Category> categories = db.getCategories();
        int index = 1;
        for (Category category : categories) {
            menuTemplate += index + ".\t" + category.getName() + "\n";
            index++;
        }
        menuTemplate += "\nPilih kategori berdasarkan index : ";

        boolean loop = false;
        do {
            loop = false;
            System.out.print(menuTemplate);
            try {
                int chosenIndex = context.getSc().nextInt() - 1;
                if (categories.get(chosenIndex) != null) {
                    this.chosenCategory = categories.get(chosenIndex);
                } else {
                    System.out.println("\nMasukkan angka yang valid.");
                    context.getSc().nextLine();
                    loop = true;
                }
            } catch (Exception e) {
                System.out.println("\nMasukkan angka yang valid.");
                context.getSc().nextLine();
                loop = true;
            }

        } while (loop);
    }

    public Category getChosenCategory() {
        return this.chosenCategory;
    }
}
