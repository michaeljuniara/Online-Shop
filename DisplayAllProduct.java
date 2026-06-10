

import java.util.List;

public class DisplayAllProduct implements SearchStrategy {
    public List<Product> search(AppContext app) {
        try {
            return ShopDB.getDB().getProducts();
        } catch (Exception e) {
            System.out.println("Tidak ada barang di database");
            return null;
        }
    }
}
