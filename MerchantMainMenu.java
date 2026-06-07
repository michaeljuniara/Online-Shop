class MerchantMainMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        String menuTemplate = """
                1.  Kelola Produk
                2.  Lihat History Transaksi
                3.  Keluar Aplikasi
                """;
        boolean exit = false;
        do {
            System.out.println(menuTemplate);
            try {
                int selection = context.sc.nextInt();
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
                    
                    default -> exit = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
                
        } while (exit);
    }
}
