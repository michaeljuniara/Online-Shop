class AddCartItemMenu implements MenuState{
    
    Product chosenProduct;
    
    @Override
    public void execute(AppContext context){
        Cart userCart = context.getUser().getCart();
        String menuTemplate = "Stok produk penjual saat ini: ";
        menuTemplate += chosenProduct.getStock();
        menuTemplate += " stok\n\n";
        menuTemplate += "Isi kuantitas:\n";
        int newQuantity = 0;
        boolean loop = false;

        do {
            loop = false;
            System.out.println(menuTemplate);
            newQuantity = context.sc.nextInt();
            if (newQuantity > chosenProduct.getStock()){
                loop = true;
                System.out.println("Kuantitas masih lebih banyak dari stok.");
            }            
        } while (loop);

        //efektif beneran memasukkan Product sebagai cartItem ke dalam keranjang user
        userCart.addItem(this.chosenProduct, newQuantity);
        context.setMenuState(new BuyerMainMenu());
    }

    public AddCartItemMenu(Product chosenProduct){
        this.chosenProduct = chosenProduct;
    }
}
