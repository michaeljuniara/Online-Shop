public class PaymentFactory implements MenuState {
    private int type;
    private double harga;
    private AppContext context;

    public PaymentFactory(AppContext context, int type, double harga) {
        this.type = type;
        this.harga = harga;
        this.context = context;
    }

    @Override
    public void execute(AppContext context) {
        String menuTemplate = String.format("Bayar Sejumlah %.2f\n0. Kembali\nBayar : ", harga);
        boolean loop = false;
        do {
            try {
                loop = false;
                System.out.println(menuTemplate);
                double transfer = context.getSc().nextDouble();
                if (harga == transfer) {
                    switch (type) {
                        case 1 -> {
                            new BCA().processPayment(context, transfer);
                        }
                        case 2 -> {
                            new Gopay().processPayment(context, transfer);
                        }
                        case 3 -> {
                            new QRIS().processPayment(context, transfer);
                        }
                    }
                } else if (harga > transfer) {
                    System.out.println("Uang yang ditransfer kurang");
                    loop = true;
                } else if (harga < transfer) {
                    System.out.println("Uang yang ditransfer lebih");
                    loop = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (loop);

    }
}