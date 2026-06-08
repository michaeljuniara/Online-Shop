package state;
class ProductManagementMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        String menuTemplate = """
                1.  Add
                2.  Remove
                3.  Edit
                4.  Kembali
                """;
        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getScanner().nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new CreateProductMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new RemoveProductMenu());
                    }
                    case 3 -> {
                        context.setMenuState(new UserProductPickerMenu());
                    }
                    case 4 -> {
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

