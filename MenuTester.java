import java.util.Scanner;
public class MenuTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShopDB db = ShopDB.getDB();
        db.registerUser("Ian", "yay");
        AppContext context = new AppContext(sc);
        context.run();
    }
}
