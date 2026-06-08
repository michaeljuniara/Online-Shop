package state;
import entity.User;
import java.util.*;
import observer.Notification;

class NotificationsMenu implements MenuState {
    @Override
    public void execute(AppContext context) {
        User user = context.getUser();
        List<Notification> notifications = user.getNotifications();
        String menuTemplate = "";
        int index = 1;
        for (Notification notif : notifications) {
            menuTemplate += "" + index + ".\t" + notif.toString() + "\n";
            index++;
        }
        menuTemplate += "Enter 0 to go back to main menu.";
        System.out.println(menuTemplate);
        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getScanner().nextInt();
                switch (selection) {
                    case 0 -> {
                        context.setMenuState(new BuyerMainMenu());
                    }

                    default -> loop = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (loop);
    }
}
