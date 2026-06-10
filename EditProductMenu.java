class EditProductMenu implements MenuState {
    private Product product;

    @Override
    public void execute(AppContext context) {
        User user = context.getUser();

        System.out.print("Nama:");
        context.getSc().nextLine();
        String name = context.getSc().nextLine();

        System.out.println("Pilih Kategori:");
        // Buka menu pilih kategori
        CategoryPicker cpm = new CategoryPicker();
        cpm.chooseCategory(context);
        Category category = cpm.getChosenCategory();

        System.out.println("Deskripsi:");
        context.getSc().nextLine();
        String description = context.getSc().nextLine();

        System.out.println("Harga:");
        double price = 0;
        while (true) {
            try {
                price = context.getSc().nextDouble();
                if (price < 0)
                    System.out.println("Harga tidak boleh negatif.");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }

        System.out.println("Stok tersedia:");
        int stock = 0;
        while (true) {
            try {
                stock = context.getSc().nextInt();
                if (stock <= 0)
                    System.out.println("Stock minimal 1.");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }

        // pilihannya adalah untuk buat produk atau kembali ke product management menu
        // (Cancel)
        String menuTemplate = """
                    1.  Confirm edit
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
                        db.editProduct(this.product, name, category, description, price, stock);
                        System.out.println("--------------Product Edited!--------------\n");
                        context.setMenuState(new ProductManagementMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new UserProductPickerMenu());
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

    public EditProductMenu(Product product) {
        this.product = product;
    }
}
