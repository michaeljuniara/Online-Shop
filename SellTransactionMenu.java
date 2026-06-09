import java.util.List;
import java.time.LocalDate;
import java.util.LinkedList;

class SellTransactionMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        User user = context.getUser();
        List<Order> orders = user.getSellOrders();
        
        List<Transaction> transactions = new LinkedList<>();
        
        for (Order order : orders) {
            Transaction orderTransaction = order.getParentTransaction();
            if (!transactions.contains(orderTransaction)){
                transactions.add(orderTransaction);
            }
        }



        String menuTemplate = """
                    List Riwayat Transaksi
                    (i). Tanggal Belanja
                """;

        int index = 1;

        List<LocalDate> allSavedLocalDate = new LinkedList<>();

        //tampilan semua date terjadinya transaksi (distinct)
        for (Transaction transaction : transactions) {

            LocalDate curDate = transaction.getTransactionDate();

            if (!allSavedLocalDate.contains(curDate)){
                menuTemplate += index+".\t"+curDate+"\n";
                allSavedLocalDate.add(curDate);
                index++;
            }
        }

        menuTemplate += "Pilih (i) dari list tanggal\n";
        System.out.println(menuTemplate);
        

        int chosenDateIndex = context.getSc().nextInt() - 1;

        //kalau index tidak valid
        while (chosenDateIndex < 0 || chosenDateIndex > allSavedLocalDate.size()-1){
            System.out.println("Index tidak valid, mohon input index yang valid:");
            System.out.println(menuTemplate);
            chosenDateIndex = context.getSc().nextInt() - 1;
        }

        //Date ditentukan, buat List Transaksi dengan Date yang ditemukan
        LocalDate chosenDate = allSavedLocalDate.get(chosenDateIndex);
        List<Transaction> transactionsAtDate = new LinkedList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getTransactionDate().equals(chosenDate)){
                transactionsAtDate.add(transaction);
            }
        }
        menuTemplate = """
                1.  Lihat Detail
                2.  Cancel
                """;
        System.out.println(menuTemplate);

        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getSc()
                .nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new SellTransactionMenuAtDate(transactionsAtDate, chosenDate));
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
    }
}
