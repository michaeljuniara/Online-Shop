package org.example.State;

class MerchantMainMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        String menuTemplate = """
                1.  Kelola Produk
                2.  Lihat History Transaksi
                3.  Keluar Aplikasi
                4.  Logout
                """;
        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getSc().nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new ProductManagementMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new SellTransactionMenu());
                    }
                    case 3 -> {
                        System.out.println("program exited");
                    }
                    case 4 -> {
                        context.setMenuState(new LoginMenu());// NOT SAFE, NOT ACTUALLY LOGGED OUT
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
                // loop = true; breaks things somehow, don't really understand
            }

        } while (loop);
    }
}
