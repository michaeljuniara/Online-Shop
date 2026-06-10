class BuyMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        String menuTemplate = """
                Masukkan Voucher?
                1.  Ya
                2.  Tidak
                3.  Cancel
                """;

        boolean loop = false;

        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getSc().nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new AddVoucherMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new CheckOutFacade(null, context));
                    }
                    case 3 -> {
                        context.setMenuState(new CartMenu());
                    }
                    default -> {
                        System.out.print("\nMasukkan angka yang valid.\n");
                        context.getSc().nextLine();
                        loop = true;
                    }
                }
            } catch (Exception e) {
                System.out.print("\nMasukkan angka yang valid.\n");
                context.getSc().nextLine();
                loop = true;
            }

        } while (loop);
    }
}
