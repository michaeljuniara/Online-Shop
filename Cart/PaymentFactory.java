package Cart;
import java.io.IOException;

public class PaymentFactory {
    public PaymentStrategy createPayment(int i) throws Exception {
        try {
            if (i == 1) {
                return new QRIS();
            } else if (i == 2) {
                return new BCA();
            } else if (i == 3) {
                return new GoPay();
            }
        } catch (Exception e) {
            System.out.println("Mohon masukan angka saja");
            
        }
    }
}