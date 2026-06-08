package factory;

import strategy.*;

public class PaymentFactory {
    public static PaymentStrategy createPayment(int i) {
        switch (i) {
            case 1 -> 
                { return new BCA(); }
            case 2 -> 
                { return new QRIS(); }
            case 3 -> 
                { return new GoPay(); }
            default ->
                { return null; }
        }
    }
}
