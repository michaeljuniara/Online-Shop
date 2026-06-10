package org.example.Factory;

import org.example.Strategy.BCA;
import org.example.Strategy.Gopay;
import org.example.Strategy.PaymentStrategy;
import org.example.Strategy.QRIS;

public class PaymentFactory {
    public static PaymentStrategy getPaymentMethod(int i) {
        switch (i) {
            case 1:
                System.out.println();
                return new BCA();
            case 2:
                return new Gopay();
            case 3:
                return new QRIS();
            default:
                throw new IllegalArgumentException("Metode pembayaran tidak dikenali.\n");
        }
    }
}