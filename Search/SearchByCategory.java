package Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

public class SearchByCategory implements SearchStrategy{

    public List<Product> search(AppContext app) {
        ArrayList<Category> lc = ShopDB.getDB().getCategories();
        String menuTemplate = "Kategori:\n";
        for (int i = 0; i < lc.size(); i++) {
            menuTemplate += ""+i + lc.get(i)+"\n";
        }
        System.out.println(menuTemplate);
        System.out.println("Cari berdasarkan kategori?");
        boolean carryon = true;
        while (carryon) {
            try {
                int input = context.sc.nextInt();
                List<Product> temp = ShopDB.getDB().getProducts();
                if (input >= 0 && input < lc.size()){
                    ShopDB.getDB().getCategories().get(input).getProducts(temp);
                    carryon = false;
                    return temp;
                }
            } catch (Exception e) {
                System.out.println("Masukan kategori yang valid");
                carryon = true;   
            }
        }
        return null;
    }
    
}
