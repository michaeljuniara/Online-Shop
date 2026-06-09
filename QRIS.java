import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class QRIS implements PaymentStrategy {

    @Override
    public void processPayment(AppContext context, double amount) {
        String menuTemplate = ("\n" + "=".repeat(45));
        menuTemplate += ("\n         STRUK PEMBAYARAN QRIS           \n");
        menuTemplate += ("=".repeat(45));
        menuTemplate += ("\nStatus      : Berhasil\n");
        menuTemplate += ("Nominal     : Rp " + String.format("%,.2f\n", amount));
        menuTemplate += ("Waktu       : "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss\n")));
        menuTemplate += ("ID Transaksi: " + "QR" + UUID.randomUUID().toString().substring(0, 6).toUpperCase() + "\n");
        menuTemplate += ("=".repeat(45));
        System.out.println(menuTemplate);
    }
}
