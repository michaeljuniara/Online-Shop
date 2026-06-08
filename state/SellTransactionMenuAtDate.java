package state;
import entity.Transaction;
import java.time.LocalDate;
import java.util.*;

class SellTransactionMenuAtDate implements MenuState {
    List<Transaction> transactions;
    LocalDate chosenDate;

    @Override
    public void execute(AppContext context) {
        String menuTemplate = "List transaksi pada tanggal " + chosenDate;
        int index = 1;
        for (Transaction transaction : transactions) {
            menuTemplate += index + ".\t" + transaction.getBuyer() + " " + transaction.getPrice();
            index++;
        }
        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);

            try {
                int selection = context.getScanner().nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new SellTransactionMenu());
                    }
                    default -> loop = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (loop);
    }

    public SellTransactionMenuAtDate(List<Transaction> transactions, LocalDate chosenDate) {
        this.transactions = transactions;
        this.chosenDate = chosenDate;
    }

}
