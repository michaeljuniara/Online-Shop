package org.example.State;

import org.example.Entity.ShopDB;

class LoginMenu implements MenuState {

    public void execute(AppContext context) {
        String menuTemplate = "--------LOGIN----------\nUsername    : ";
        System.out.print(menuTemplate);

        String inUsername = context.getSc().next();
        System.out.print("Password    : ");
        String inPassword = context.getSc().next();
        ShopDB DBInstance = ShopDB.getDB();
        boolean loginSuccessful = context.setUser(DBInstance.loginUser(inUsername, inPassword));

        // Kalau ditemukan User dengan username dan password yang sesuai
        if (loginSuccessful) {
            // keluarkan menu pemilihan pembeli/penjual
            System.out.println("\n----------LOGIN SUCCESSFUL----------");
            String userTypeMenuTemplate = """
                    Selamat datang di TokopedIAN
                    
                    Silahkan login sebagai:
                    1.  Pembeli
                    2.  Penjual
                    """;

            boolean loop = false;
            do {
                loop = false;
                System.out.println(userTypeMenuTemplate);
                try {
                    int selection = context.getSc().nextInt();
                    context.getSc().nextLine();
                    switch (selection) {
                        case 1 -> {
                            context.setMenuState(new BuyerMainMenu());
                        }
                        case 2 -> {
                            context.setMenuState(new MerchantMainMenu());
                        }
                        default -> loop = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } while (loop);

        } else {
            System.out.println("LOGIN FAILED!");
            String failedMenuTemplate = """
                    Maaf, username/password salah.
                    
                    1.  Kembali ke menu Login.
                    2.  Keluar Aplikasi.
                    """;
            boolean loop = false;

            do {
                loop = false;
                System.out.println(failedMenuTemplate);
                int selection = context.getSc().nextInt();
                try {
                    switch (selection) {
                        case 1 -> {
                            context.setMenuState(new LoginMenu());
                        }
                        case 2 -> {
                            System.out.println("Program exited");
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

            // get change menuState back to LoginMenu
        }

    }
}
