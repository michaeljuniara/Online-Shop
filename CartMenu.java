import java.util.List;

public class CartMenu implements MenuState {

    @Override
    public void execute(AppContext context) {
        // TODO Auto-generated method stub
        String menuTemplate = """
                List Produk:\n""";
        List<CartItem> cart = context.getUser().getCart().getItems();
        for (int i = 0; i < cart.size(); i++) {
            menuTemplate += "" + (i + 1) + cart.get(i) + "\n";
        }
        menuTemplate += "1. Lihat Detail\n2. Beli\n 3. Cancel";
        System.out.println(menuTemplate);
        boolean carryon = true;
        while (carryon) {
            carryon = false;
            try {
                int input = context.getScanner().nextInt();
                switch (input) {
                    case 1 -> {
                        context.setMenuState(new DetailProductMenu());
                    }
                    case 2 -> {
                        context.setMenuState(new BuyMenu());
                    }
                    case 3 -> {
                        context.setMenuState(new BuyerMainMenu());
                    }
                    default -> {
                        System.out.println("Masukan angka yang valid");
                        carryon = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Masukan angka yang valid");
                carryon = true;
            }
        }

    }

}
