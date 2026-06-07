class CreateProductMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        User user = context.getUser();

        System.out.println("Nama?");
        String name = context.sc.next();

        System.out.println("Pilih Kategori:");
        //Buka menu pilih kategori
        CategoryPicker cpm = new CategoryPicker();
        cpm.chooseCategory(context);
        Category category = cpm.getChosenCategory();

        System.out.println("Deskripsi?");
        String description = context.sc.nextLine();

        System.out.println("Harga?");
        double price = context.sc.nextDouble();

        System.out.println("Stok tersedia?");
        int stock = context.sc.nextInt();

        //pilihannya adalah untuk buat produk atau kembali ke product management menu
        String menuTemplate = """
                    1.  Create
                    2.  Cancel
                """;
        boolean exit = false;
        do {
            System.out.println(menuTemplate);
            try {
                int selection = context.sc.nextInt();
                switch (selection) {
                    case 1 -> {
                        user.newProduct(name, category, description, price, stock);
                        System.out.println("--------------Product Created!--------------");
                        context.setMenuState(new ProductManagementMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new ProductManagementMenu());
                    }
                    
                    default -> exit = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
                
        } while (exit);
    }
}
