public class Gopay implements PaymentStrategy{

    @Override
    public void processPayment(AppContext context, double amount) {
        String menuTemplate = "\n" + "=".repeat(45);
        menuTemplate +=("\n        STATUS PEMBAYARAN - GOPAY        \n");
        menuTemplate +=("=".repeat(45));
        menuTemplate +=("\nStatus      : BERHASIL\n");
        menuTemplate +=("Nominal     : Rp " + String.format("%,.2f\n", amount));
        menuTemplate +=("Waktu       : " + java.time.LocalDateTime.now()
                                        .format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss\n")));
        menuTemplate +=("ID Transaksi: GP-" + System.currentTimeMillis() + "\n");
        menuTemplate +=("=".repeat(45));
        menuTemplate +=("\nTerima kasih telah menggunakan GoPay!\n");
        System.out.println(menuTemplate);
    }
}
