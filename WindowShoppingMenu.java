import java.util.*;
class WindowShoppingMenu implements MenuState{

    List<Product> productList;
    
    @Override
    public void execute(AppContext context){
        // User user = context.getUser();
        // ShopDB db = ShopDB.getDB();
        // String username = user.getUsername();
        // List<Product> userProducts = db.getActiveProductByUser(username); 

        //list all the active user Products to choose from
        String menuTemplate = "List Produk:\n(i).\t(nama produk)\n";

        int index = 1;

        for (Product product : this.productList) {
            menuTemplate += index+".\t"+product.getName()+"\n";
            index++;
        }

        menuTemplate += "Pilih (i) dari list produk:\n";
        System.out.println(menuTemplate);

        //input the index of the product
        boolean loop = false;
        Product chosenProduct = null;
        do { 
            loop = false;
            try {
                int chosenIndex = context.sc.nextInt() - 1;
                chosenProduct = this.productList.get(chosenIndex);

            } catch (Exception e) {
                System.out.println(e);
                loop = true;
            }

        } while (loop);

        if (chosenProduct != null) System.out.println("Product chosen:"+ chosenProduct.getName());

        
        menuTemplate = """
                1.  Lihat Detail Product
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
                        context.setMenuState(new PutProductInCartMenu(chosenProduct));//
                    }
                    case 2 -> {
                        context.setMenuState(new ProductSearchMenu());//
                    }
                    
                    default -> loop = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
                
        } while (loop);
        //index produk sudah terpilih, sekarang beneran dimasukkan ke cart
    }

    public WindowShoppingMenu(List<Product> productList) {
        this.productList = productList;
    }

    
}
