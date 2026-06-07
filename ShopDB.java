import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class ShopDB {
    private static final ShopDB instance = new ShopDB();
    private List<User> users;
    private List<Product> products;
    private List<Category> categories;
    private Map<String, Voucher> vouchers;
    
    private ShopDB() {
        users = new ArrayList<>();
        products = new ArrayList<>();
        categories = new ArrayList<>();
        vouchers = new HashMap<>();
    }

    public static ShopDB getDB() {
        return instance;
    }

    public User loginUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) &&
            u.getUsername().equals(password)) return u;
        }
        return null;
    }

    public boolean registerUser(String username, String password) {
        for (User u : users){
            if (u.getUsername().equals(username)) return false;
        }
        users.add(new User(username, password));
        return true;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addVoucher(Voucher v) {
        vouchers.put(v.getCode(), v);
    }

    public List<Category> getCategories() { return Collections.unmodifiableList(categories); }
    public Voucher getVoucher(String code) { return vouchers.get(code); }
}