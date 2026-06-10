package org.example.State;

import org.example.Entity.User;
import org.example.Observer.Notification;
import java.util.List;

class NotificationsMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        User user = context.getUser();
        List<Notification> notifications = user.getNotifications();
        String menuTemplate = "";
        int index = 1;
        for (Notification notif : notifications) {
            menuTemplate += "" + index + ".\t[" + notif.getTimestamp().toLocalDate().toString() + "] " + notif.getMessage() + "\n";
            index++;
        }
        menuTemplate += "Enter 1 to go back to main menu.";
        // System.out.println(menuTemplate);
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
