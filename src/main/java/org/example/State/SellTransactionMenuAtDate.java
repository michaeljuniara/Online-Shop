package org.example.State;

import org.example.Entity.Transaction;

import java.time.LocalDate;
import java.util.List;

class SellTransactionMenuAtDate implements MenuState {
    private List<Transaction> transactions;
    private LocalDate chosenDate;

    public SellTransactionMenuAtDate(List<Transaction> transactions, LocalDate chosenDate) {
        this.transactions = transactions;
        this.chosenDate = chosenDate;
    }

    @Override
    public void execute(AppContext context) {
        String menuTemplate = "\nList transaksi pada tanggal " + chosenDate;
        int index = 1;
        for (Transaction transaction : transactions) {
            menuTemplate += index + ".\t" + transaction.getBuyer() + " " + transaction.getPrice();
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
                        context.setMenuState(new SellTransactionMenu());
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
