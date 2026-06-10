
import java.util.ArrayList;
import java.util.List;

public class SearchByName implements SearchStrategy {

    public List<Product> search(AppContext context) {
        System.out.println("Masukan nama produk yang ingin dicari");
        try {
            String name = context.getSc().next();
            List<Product> sdb = (ArrayList<Product>) ShopDB.getDB().getProducts();
            List<Product> result = new ArrayList<>();
            for (int i = 0; i < sdb.size(); i++) {
                if (sdb.get(i).getName().contains(name)) {
                    result.add(sdb.get(i));
                }
            }
            return (List<Product>) result;
        } catch (Exception e) {
            System.out.println("Tidak ada barang di database");
            context.setMenuState(new ProductSearchMenu());
            return null;
        }
    }

}
