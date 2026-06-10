package org.example.State;

import org.example.Composite.Product;
import org.example.Entity.Cart;

class AddCartItemMenu implements MenuState {

    private Product chosenProduct;

    public AddCartItemMenu(Product chosenProduct) {
        this.chosenProduct = chosenProduct;
    }

    @Override
    public void execute(AppContext context) {
        Cart userCart = context.getUser().getCart();
        String menuTemplate = "\nStok produk penjual saat ini : ";
        menuTemplate += chosenProduct.getStock();
        menuTemplate += "\n0. Kembali\n";
        menuTemplate += "Isi kuantitas: ";
        int newQuantity = 0;
        boolean loop = false;

        do {
            loop = false;
            System.out.print(menuTemplate);
            try {
                newQuantity = context.getSc().nextInt();
                context.getSc().nextLine();
                if (newQuantity == 0) {
                    context.setMenuState(new ProductSearchMenu());
                } else if (newQuantity < 0) {
                    System.out.println("\nKuantitas tidak boleh negatif.\n");
                    loop = true;
                } else if (newQuantity > chosenProduct.getStock()) {
                    System.out.print("\nKuantitas masih lebih banyak dari stok.\n");
                    loop = true;
                } else if (newQuantity <= chosenProduct.getStock()) {
                    System.out.print("\nProduk berhasil ditambahkan ke keranjang.\n");
                    userCart.addItem(this.chosenProduct, newQuantity);
                    context.setMenuState(new BuyerMainMenu());
                } else {
                    System.out.println("\nMasukkan angka yang valid.\n");
                    loop = true;
                }

            } catch (Exception e) {
                System.out.println("\nMasukkan angka yang valid.\n");
                context.getSc().nextLine();
                loop = true;
            }
        } while (loop);

    }
}
