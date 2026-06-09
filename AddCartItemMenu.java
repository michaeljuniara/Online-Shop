class AddCartItemMenu implements MenuState {

    private Product chosenProduct;

    @Override
    public void execute(AppContext context) {
        Cart userCart = context.getUser().getCart();
        String menuTemplate = "Stok produk penjual saat ini: ";
        menuTemplate += chosenProduct.getStock();
        menuTemplate += " stok\n";
        menuTemplate += "0. Kembali\n";
        menuTemplate += "Isi kuantitas:\n";
        int newQuantity = 0;
        boolean loop = false;

        do {
            loop = false;
            System.out.print(menuTemplate);
            newQuantity = context.getSc().nextInt();
            if (newQuantity == 0) {
                context.setMenuState(new ProductSearchMenu());
            } else if (newQuantity < 0) {
                System.out.println("Kuantitas tidak boleh negatif");
                loop = true;
            } else if (newQuantity > chosenProduct.getStock()) {
                System.out.println("Kuantitas masih lebih banyak dari stok.");
                loop = true;
            }
        } while (loop);

        // efektif beneran memasukkan Product sebagai cartItem ke dalam keranjang user
        userCart.addItem(this.chosenProduct, newQuantity);
        context.setMenuState(new BuyerMainMenu());
    }

    public AddCartItemMenu(Product chosenProduct) {
        this.chosenProduct = chosenProduct;
    }
}
