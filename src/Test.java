package src;

import composite.*;
import entity.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import observer.*;

public class Test {
    // test categoryComponent
    public static void categoryComponentTest() {
        User seller = new User("Ian", "Ian123");

        Category electronics = new Category("Electronics");
        Category laptops = new Category("Laptops");
        Category phones = new Category("Phones");
        Category gaming = new Category("Gaming");

        Product macbook = new Product(seller, "Macbook Neo", laptops, "Apple A18 Pro Chip", 15_000_000.00, 10);
        Product dellXps = new Product(seller, "Dell XPS 13", laptops, "Intel i7", 10_249.99, 5);
        Product iphone = new Product(seller, "iPhone 2026 Promek", phones, "???", 9_999_999.00, 10);
        Product ps5 = new Product(seller, "PlayStation 5 Slim", gaming, "1TB Digital Edition", 8500000.0, 8);
        Product switchOled = new Product(seller, "Nintendo Switch OLED", gaming, "Neon Blue/Red", 4200000.0, 15);
        Product rogAlly = new Product(seller, "ASUS ROG Ally", gaming, "RC71L AMD Z1 Extreme", 11000000.0, 3);
        
        electronics.add(laptops);
        electronics.add(iphone);
        electronics.add(gaming);
        
        laptops.add(macbook);
        laptops.add(dellXps);
        phones.add(iphone);
        gaming.add(rogAlly);
        gaming.add(ps5);
        gaming.add(switchOled);
        
        Locale idrLocale = Locale.of("id", "ID");
        NumberFormat idrFormat = NumberFormat.getCurrencyInstance(idrLocale);
        
        System.out.println("=== Show all ===");
        List<Product> allCatalog = new ArrayList<>();
        electronics.getProducts(allCatalog);
        for (Product p : allCatalog) {
            System.out.println(p.getName() + " " + idrFormat.format(p.getPrice()));
        }
        System.out.println("================");

        System.out.println("=== Show laptops ===");
        List<Product> laptopCatalog = new ArrayList<>();
        laptops.getProducts(laptopCatalog);
        for (Product p : laptopCatalog) {
            System.out.println(p.getName() + " " + idrFormat.format(p.getPrice()));
        }
        System.out.println("====================");
    }

    // test orderObserver
    public static void orderObserverTest() {
        User buyer = new User("Ian", "Ian123");

        Category electronics = new Category("Electronics");
        Category laptops = new Category("Laptops");
        Product macbook = new Product(buyer, "Macbook Neo", laptops, "Apple A18 Pro Chip", 15_000_000.00, 10);

        electronics.add(laptops);
        laptops.add(macbook);

        Transaction t = new Transaction(buyer, LocalDate.now());

        CartItem item = new CartItem(macbook, 1);
        Order order = new Order(item, t);

        t.addOrder(order);

        System.out.println("Buyer  : " + buyer.getUsername());
        System.out.println("Barang : " + order.getItem().getProduct().getName());
        System.out.println();
        order.setStatus(Order.Status.DELIVERING);
        order.setStatus(Order.Status.ARRIVED);

        List<Notification> userNotif = buyer.getNotifications();

        for (Notification n : userNotif) {
            System.out.println(n.getMessage());
            n.markAsRead();
        }
        System.out.println();

        for (Order ord : t.getOrders()) {
            System.out.println(ord.getItem().getProduct().getName());
            System.out.println(ord.getBuyer().getUsername());
        }
    }

    public static void main(String[] args) {
        orderObserverTest();
    }
}
