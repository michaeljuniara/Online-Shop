import javax.management.Notification;

class NotificationsMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        User user = context.getUser();
        List<Notification> notifications = user.getNotifications();
        String menuTemplate = "";
        int index = 1;
        for (Notification notif : notifications) {
            menuTemplate += ""+index+".\t"+notif.toString()+"\n";
            index++;
        }
        menuTemplate += "Enter 0 to go back to main menu.";
        System.out.println(menuTemplate);
        boolean exit = false;
            do {
                System.out.println(menuTemplate);
                try {
                    int selection = context.sc.nextInt();
                    switch (selection) {
                        case 0 -> {
                            context.setMenuState(new BuyerMainMenu());
                        }

                        default -> exit = true;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } while (!exit);
    }
}
