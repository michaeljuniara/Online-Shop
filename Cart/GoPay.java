package Cart;
public class GoPay implements PaymentStrategy {
    public boolean pay(AppContext app) {
        System.out.println("=========================================");
        System.out.println("                   gopay                 ");
        System.out.println("                  by gojek               ");
        System.out.println("=========================================");
        System.out.println(" Merchant : KEDAI MANTAP REJEKI          ");
        System.out.println(" Order ID : GP-7729104-XYZ               ");
        System.out.println("=========================================");
        System.out.println();

        app.getInput().nextLine();
        return true;
    }

}
