class PutProductInCartMenu implements MenuState {

    private Product chosenProduct;

    @Override
    public void execute(AppContext context) {

        // beri detail produk
        String menuTemplate = "\nNama : " + chosenProduct.getName() + "\nHarga : " + chosenProduct.getPrice() +
                "\nStok : " + chosenProduct.getStock() + "\nDeskripsi : " + chosenProduct.getDescription() + "\n";

        menuTemplate += """
                1.  Tambahkan ke keranjang
                2.  Cancel
                """;

        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.getSc().nextInt();
                switch (selection) {
                    case 1 -> {
                        context.setMenuState(new AddCartItemMenu(this.chosenProduct));
                    }
                    case 2 -> {
                        context.setMenuState(new ProductSearchMenu());
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

    public PutProductInCartMenu(Product chosenProduct) {
        this.chosenProduct = chosenProduct;
    }
}
