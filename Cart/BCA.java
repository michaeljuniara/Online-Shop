package Cart;
public class BCA implements PaymentStrategy {
    public boolean pay(AppContext app) {
        System.out.println("=========================================");
        System.out.println("               [  BCA  ]                 ");
        System.out.println("=========================================");
        System.out.println(" MID : 0001002938475   TID : 92837482    ");
        System.out.println(" NM  : KEDAI MANTAP REJEKI               ");
        System.out.println("=========================================");
        System.out.println();

        app.getInput().nextLine();
        return true;
    }
}
