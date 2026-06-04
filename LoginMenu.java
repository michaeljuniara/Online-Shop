
class LoginMenu implements MenuState{

    public void execute(AppContext context){
        String menuTemplate = """
                --------LOGIN----------
                Username    :
                Password    :
                """;
        System.out.println(menuTemplate);

        String inUsername = context.sc.next();
        String inPassword= context.sc.next();

        Database DBInstance = Database.getDB();
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
            
            
            boolean exit = false;
            do {
                System.out.println(userTypeMenuTemplate);
                int selection = context.sc.nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new BuyerMainMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new MerchantMainMenu());
                    }
                    default -> exit = true;
                }
            } while (!exit);

        }
        
        
        
        
        
        
        
        
        else{
            System.out.println("LOGIN FAILED!");
            String failedMenuTemplate = """
                Maaf, username/password salah.

                1.  Kembali ke menu Login.
                2.  Keluar Aplikasi.
                """;
            boolean exit = false;

            do {
                System.out.println(failedMenuTemplate);
                int selection = context.sc.nextInt();
                switch (selection) {
                    case 1 -> { 
                        context.setMenuState(new LoginMenu());
                    }
                    case 2 -> {
                        System.out.println("program exited");
                    }
                    default -> exit = true;
                }
            } while (!exit);
            
            //get change menuState back to LoginMenu
        }

    }
}
