class PutProductInCartMenu implements MenuState{

    private Product chosenProduct;

    @Override
    public void execute(AppContext context){
        String menuTemplate = """
                Detail Produk:

                """;
        //beri detail produk
        menuTemplate += "Nama: "+chosenProduct.getName()+" Harga: "+chosenProduct.getPrice()+
            " Stok: "+chosenProduct.getStock()+" Deskripsi: "+chosenProduct.getDescription()+"\n";

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
                    
                    default -> loop = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
                
        } while (loop);




    }
    
    public PutProductInCartMenu(Product chosenProduct){
        this.chosenProduct = chosenProduct;
    }
}
