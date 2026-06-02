import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Database{
    private static Database instance = new Database();
    private List<User> users;
    private List<Product> products;
    private List<Category> categories;
    private Map<String, Voucher> vouchers;
    private List<PaymentStrategy> paymentMethods;
    
    private Database(){
        users = new ArrayList<>();
        products = new ArrayList<>();
        categories = new ArrayList<>();
        vouchers = new HashMap<>();
        paymentMethods = new ArrayList<>();
    }

    public Database getDB(){
        return instance;
    }

    public List<User> getUsers(){
        return users;
    }

    public boolean registerUser(String username, String password){
        for (User u : users){
            if (u.getUsername().equals(username) &&
            u.getUsername().equals(password)) return false;
        }
        users.add(new User(username, password));
        return true;
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public void addVoucher(Voucher v){
        vouchers.put(v.getCode(), v);
    }

    public void addPaymentMethod(PaymentStrategy ps){
        paymentMethods.add(ps);
    }

    public List<Category> getCategories(){
        return categories;
    }

    public Voucher getVoucher(String code){
        return vouchers.get(code);
    }

    public List<PaymentStrategy> getPaymentMethods(){
        return paymentMethods;
    }
}