
class LoginMenu implements MenuState{

    public void execute(AppContext context){
        String menuTemplate = """
                --------LOGIN----------
                Username    :""";
        System.out.print(menuTemplate);

        String inUsername = context.sc.next();
        System.out.print("Password    :");
        String inPassword= context.sc.next();
        ShopDB DBInstance = ShopDB.getDB();
        boolean loginSuccessful = context.setUser(DBInstance.loginUser(inUsername, inPassword));

        //Kalau ditemukan User dengan username dan password yang sesuai
        if (loginSuccessful){
            //keluarkan menu pemilihan pembeli/penjual
            System.out.println("LOGIN SUCCESSFUL");
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
                    
                    int selection = context.sc.nextInt();
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

        }else{
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
                int selection = context.sc.nextInt();
                try {
                    switch (selection) {
                    case 1 -> { 
                        context.setMenuState(new LoginMenu());
                    }
                    case 2 -> {
                        System.out.println("program exited");
                    }
                    default -> loop = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            } while (loop);
            
            //get change menuState back to LoginMenu
        }

    }
}
