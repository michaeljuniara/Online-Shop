import java.util.List;

class OrderHistoryMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        User user = context.getUser();
        List<Transaction> userTransactions = user.getBuyTransactions();

        String menuTemplate = "Riwayat transaksi:\n(i).\t(transaksi)\n(-).\t(order)\n";

        int index = 1;

        for (Transaction transaction : userTransactions) {
            menuTemplate += index + ".\t" + transaction.getTransactionDate() + ", harga total:" + transaction.getPrice()
                    + "\n";
            List<Order> curTransactionOrders = transaction.getOrders();
            for (Order order : curTransactionOrders) {
                menuTemplate += "- " + order.getItem() + " Toko\t: " + order.getSeller().getUsername() + "\n";
            }
            index++;
        }

        menuTemplate = """
                1.  Kembali
                """;
        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);

            try {
                int selection = context.getSc().nextInt();
                switch (selection) {

                    case 1 -> {
                        context.setMenuState(new BuyerMainMenu());
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
