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
        

        

        AppContext context = new AppContext(sc);
        context.run();
    }
}
