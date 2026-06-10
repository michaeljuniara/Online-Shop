import java.util.Scanner;
public class MenuTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShopDB db = ShopDB.getDB();
        db.registerUser("Ian", "yay");

        Category electronics = new Category("Electronics");
        Category laptops = new Category("Laptops");
        Category phones = new Category("Phones");
        Category gaming = new Category("Gaming");

        electronics.add(laptops);
        electronics.add(gaming);
        db.addCategory(electronics);

        db.addProduct(ShopDB.getDB().loginUser("Ian", "yay"), "kursi", electronics, "aaaaa", 1000, 1);
        db.addProduct(ShopDB.getDB().loginUser("Ian", "yay"), "pikachu", electronics, "bzzzzzz", 1000, 2);

        Voucher vo1 = new Voucher("min100", 100, 3);
        db.addVoucher(vo1);

        AppContext context = new AppContext(sc);
        context.run();
    }
}
