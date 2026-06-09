import java.util.*;

class SearchProductByNameMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        String menuTemplate = "Input Nama Produk: ";

        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            
            try {
                String potentialProductName = context.sc.next();
                List<Product> productsByName = ShopDB.getDB().getActiveProducts(potentialProductName);
                if (!productsByName.isEmpty()){
                    context.setMenuState(new WindowShoppingMenu(productsByName));
                }else{//edge case tidak ada produk dengan nama yang diinput user
                    System.out.println("Barang dengan nama "+potentialProductName+" tidak ditemukan");
                    context.setMenuState(new ProductSearchMenu());                    
                }
            } catch (Exception e) {
                System.out.println(e);
            }
                
        } while (loop);



        
    }
}
