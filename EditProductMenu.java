class EditProductMenu implements MenuState {
    private Product product;

    @Override
    public void execute(AppContext context) {
        User user = context.getUser();

        System.out.println("Nama?");
        String name = context.getSc().next();

        System.out.println("Pilih Kategori:");
        // Buka menu pilih kategori
        CategoryPicker cpm = new CategoryPicker();
        cpm.chooseCategory(context);
        Category category = cpm.getChosenCategory();

        System.out.println("Deskripsi?");
        String description = context.getSc().next();

        System.out.println("Harga?");
        double price = context.getSc().nextDouble();

        System.out.println("Stok tersedia?");
        int stock = context.getSc().nextInt();

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
