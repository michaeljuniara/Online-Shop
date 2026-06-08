public class BuyMenu implements MenuState {

    @Override
    public void execute(AppContext context) {
        String menuTemplate = """
                Masukan Voucher?
                1. Ya
                2. Tidak
                3. Cancel """;
        System.out.println(menuTemplate);
        boolean carryon = true;
        while (carryon) {
            try {
                int input = context.getScanner().nextInt();
                switch (input) {
                    case 1 -> {

                    }
                    case 2 -> {

                    }
                    case 3 -> {
                        carryon = false;
                        context.setMenuState(new CartMenu());
                    }
                    default -> {
                        carryon = true;
                        System.out.println("Masukan angka yang valid");
                    }
                }
            } catch (Exception e) {
                System.out.println("Masukan angka yang valid");
                carryon = true;
            }
        }
    }

}
