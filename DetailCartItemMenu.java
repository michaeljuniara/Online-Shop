public class DetailCartItemMenu implements MenuState{
    private int cartItemIndex;
    private CartItem cartItem;
    private Cart userCart;
    @Override
    public void execute(AppContext context){
        String menuTemplate = """
                Detail Produk:
                """;
        menuTemplate += "Nama:\t"+cartItem.getProduct().getName()+"\nHarga:\t"+cartItem.getTotalPrice();
        menuTemplate += "\nStok:\t"+cartItem.getProduct().getStock()+"\nDeskripsi:\t"+cartItem.getProduct().getDescription();
        menuTemplate += "\nKuantitas:\t"+cartItem.getQuantity();

        System.out.println(menuTemplate);

        menuTemplate = """
                1.  Ubah Kuantitas
                2.  Hapus dari Keranjang
                3.  Kembali
                """;
        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.sc.nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new ChangeCartItemQuantityMenu(this.userCart, this.cartItem, this.cartItemIndex));
                    }
                    case 2 -> {
                        userCart.removeItem(this.cartItemIndex);
                        System.out.println("-------Produk Dihapus dari Keranjang-------------");
                        context.setMenuState(new CartMenu());
                    }
                    case 3 -> {
                        context.setMenuState(new CartMenu());
                    }             
                    default -> loop = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
                
        } while (loop);
    }

    public DetailCartItemMenu(Cart userCart, CartItem chosenCartItem, int chosenCartItemIndex){
        this.cartItemIndex = chosenCartItemIndex;
        this.cartItem = chosenCartItem;
        this.userCart = userCart;
    }
}
