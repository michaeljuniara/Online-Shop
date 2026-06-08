public class DetailPriceMenu implements MenuState {

    @Override
    public void execute(AppContext context) {
        String menuTemplate = String.format(
                "Detail harga\n%s\nList Metode Pembayaran\n1. BCA\n2. Gopay\n3.QRIS\n4. Cancel",
                context.getUser().getCart().calculateTotal());
        boolean carryon = true;
        while (carryon) {
            carryon = false;
            try {
                int input = context.getScanner().nextInt();
                switch (input) {
                    case 1 -> {
                        context.setMenuState(new BCA());
                    }
                    case 2 -> {
                        context.setMenuState(new Gopay());
                    }
                    case 3 -> {
                        context.setMenuState(new QRIS());
                    }
                    case 4 -> {
                        context.setMenuState(new BuyMenu());
                    }
                    default -> {
                        carryon = true;
                        System.out.println("Masukan angka yang valid");
                    }
                }
            } catch (Exception e) {
                carryon = true;
                System.out.println("Masukan angka yang valid");
            }
        }

        System.out.println(menuTemplate);
    }

}
