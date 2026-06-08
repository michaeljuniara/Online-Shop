import java.util.List;

public class DetailProductMenu implements MenuState {

    @Override
    public void execute(AppContext context) {
        String menuTemplate = """
                List Produk:\n""";

        List<CartItem> cart = context.getUser().getCart().getItems();

        if (cart.size() > 0) {
            for (int i = 0; i < cart.size(); i++) {
                menuTemplate += "" + (i + 1) + ". " + cart.get(i).getProduct().getName() + "\n";
            }
            menuTemplate += "Pilih salah satu produk\n";
            System.out.println(menuTemplate);
            boolean carryon = true;
            while (carryon) {
                carryon = false;
                try {
                    int input = context.getScanner().nextInt();
                    if (input >= 0 && input < cart.size()) {
                        System.out.println(cart.get(input));
                    }
                } catch (Exception e) {
                    carryon = true;
                    System.out.println("Masukkan angka yang valid.");
                }
            }
        } else {
            System.out.println("Masukkan Produk ke Keranjang terlebih dahulu.");
            context.setMenuState(new CartMenu());
        }
    }

}
