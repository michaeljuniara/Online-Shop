import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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

    public static ShopDB getDB() { return instance; }

    public void addProduct(User owner, String name, Category category, String description, double price, int stock) {
        Product p = new Product(owner, name, category, description, price, stock);
        products.add(p);
    }

    public void editProduct(Product p, String name, Category category, String description, double price, int stock) {
        p.setName(name);
        p.setCategory(category);
        p.setDescription(description);
        p.setPrice(price);
        p.setStock(stock);
    }

    public void deactivateProduct(Product p) {
        if (p != null) {
            p.deactivate();
        }
    } 

    public User loginUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) return u;
        }
        return null;
    }

    public boolean registerUser(String username, String password) {
        User user = new User(username, password);

        for (User u : users){
            if (u.equals(user)) return false;
        }

        users.add(user);
        return true;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addVoucher(Voucher v) {
        vouchers.put(v.getCode(), v);
    }

    public List<User> getUser() { return users; }
    public List<Product> getProducts() { return products; }
    public List<Category> getCategories() { return categories; }
    public Voucher getVoucher(String code) { return vouchers.get(code); }

    public List<Product> getProductByUser(User seller) {
        List<Product> lp = new ArrayList<>();

        for (Product product : products) {
            if (product.getOwner().equals(seller)) lp.add(product);
        }

        return lp;
    }
}