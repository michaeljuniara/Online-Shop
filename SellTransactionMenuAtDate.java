import java.time.LocalDate;
import java.util.*;
class SellTransactionMenuAtDate implements MenuState{
    List<Transaction> transactions;
    LocalDate chosenDate;
    @Override
    public void execute(AppContext context){
            String menuTemplate = "List transaksi pada tanggal "+chosenDate;
            int index = 1;
            for (Transaction transaction : transactions) {
                menuTemplate += index+".\t"+transaction.getInfo();
                index++;
            }
            boolean exit = false;
            do {
                System.out.println(menuTemplate);
                
                try {
                    int selection = context.sc.nextInt();
                    switch (selection) {
                    case 1 -> {
                        context.setMenuState(new SellTransactionMenu());
                    }
                    default -> exit = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            } while (exit);
    }

    public SellTransactionMenuAtDate(List<Transaction> transactions, LocalDate chosenDate) {
        this.transactions = transactions;
        this.chosenDate = chosenDate;
    }

    
}
