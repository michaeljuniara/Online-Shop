import java.util.List;

class UserProductPickerMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        User user = context.getUser();
        ShopDB db = ShopDB.getDB();
        String username = user.getUsername();
        List<Product> userProducts = db.getActiveProductByUser(username); 

        //list all the active user Products to choose from
        String menuTemplate = "List Produkmu:\n(i).\t(nama produk)\n";

        int index = 1;

        if (userProducts.size() > 0) {
            for (Product product : userProducts) {
                menuTemplate += index+".\t"+product.getName()+"\n";
                index++;
            }

            menuTemplate += "Pilih produkmu berdasarkan index:\n";
            System.out.println(menuTemplate);

            //input the index of the product
            boolean loop = false;
            Product chosenProduct = null;
            do { 
                loop = false;
                try {
                    int chosenIndex = context.sc.nextInt() - 1;
                    chosenProduct = userProducts.get(chosenIndex);

                } catch (Exception e) {
                    System.out.println(e);
                    loop = true;
                }

            } while (loop);

            if (chosenProduct != null) System.out.println("Product chosen:"+ chosenProduct.getName());

            
            menuTemplate = """
                    1.  Edit Product
                    2.  Cancel
                    """;

            loop = false;
            do {
                loop = false;
                System.out.println(menuTemplate);
                try {
                    int selection = context.sc.nextInt();
                    switch (selection) {
                        case 1 -> {
                            context.setMenuState(new EditProductMenu(chosenProduct));
                        }
                        case 2 -> {
                            context.setMenuState(new ProductManagementMenu());
                        }
                        
                        default -> loop = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                    
            } while (loop);
            //index produk sudah terpilih, sekarang beneran edit
        } else {
            System.out.println("""
                    Anda tidak memiliki produk.
                    Buatlah sebuah produk terlebih dahulu.
                    """);
            context.setMenuState(new ProductManagementMenu());
        }
    }
}
