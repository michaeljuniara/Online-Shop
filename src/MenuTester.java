package src;

import composite.*;
import entity.*;
import java.util.Scanner;
import singleton.*;
import state.*;

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
        electronics.add(phones);

        User ian = db.loginUser("Ian", "yay");
        db.addProduct(ian, "Pelumas wow", gaming, "Agar mesinmu tidak macet gunakanlah Pelumas wow!!!", 69.42, 1);
        
        db.addCategory(electronics);
        
        AppContext context = new AppContext(sc);
        context.run();
    }
}
