import java.util.List;

class CartMenu implements MenuState{
    @Override
    public void execute(AppContext context){
        User user = context.getUser();
        Cart userCart = user.getCart();
        
        List<CartItem> userCartItems = userCart.getItems();
        String menuTemplate = """
                Isi Keranjang:
                (i). (produk) Kuantitas: (kuantitas) Total Harga: (total harga)
                """;

        int index = 1;

        //tampilkan semua product
        for (CartItem cartItem : userCartItems) {
            menuTemplate += ""+index+".\t"+cartItem.getProduct().getName()+" Kuantitas: "+cartItem.getQuantity()+" Total Harga: "+cartItem.getTotalPrice()+"\n";
            index++;
        }
        // if (userCart.getItems().isEmpty()){
        //     System.out.println("Kerangjang kosong, tekan 1 untuk kembali ke halaman utama.");
        //     boolean loop = false;
        //     do {
        //         loop = false;
        //         System.out.println(menuTemplate);
        //         try {
        //             int selection = context.sc.nextInt();
        //             switch (selection) {
        //                 case 0 -> {
        //                     context.setMenuState(new BuyMenu());
        //                 }
        //                 case -1 -> {
        //                     context.setMenuState(new BuyerMainMenu());//
        //                 }
        //                 default ->{
        //                     try {
        //                         int chosenCartItemIndex = context.sc.nextInt()-1;//user input untuk melihat detail cartItem
        //                         CartItem chosenCartItem = userCartItems.get(chosenCartItemIndex);
        //                         context.setMenuState(new DetailCartItemMenu(userCart, chosenCartItem, chosenCartItemIndex));
        //                     } catch (Exception e) {
        //                     }
        //                     loop = true;
        //                 }
        //             }
        //         } catch (Exception e) {
        //             System.out.println(e);
        //         }
                    
        //     } while (loop);
        // }
        menuTemplate += """

        
                (i).    Lihat Detail
                0.      Beli
                -1.     Cancel
                """;

        boolean loop = false;
        do {
            loop = false;
            System.out.println(menuTemplate);
            try {
                int selection = context.sc.nextInt();
                switch (selection) {
                    case 0 -> {
                        context.setMenuState(new BuyMenu());
                    }
                    case -1 -> {
                        context.setMenuState(new BuyerMainMenu());//
                    }
                    default ->{
                        try {
                            int chosenCartItemIndex = selection-1;//user input untuk melihat detail cartItem
                            CartItem chosenCartItem = userCartItems.get(chosenCartItemIndex);
                            context.setMenuState(new DetailCartItemMenu(userCart, chosenCartItem, chosenCartItemIndex));
                        } catch (Exception e) {
                        }
                        loop = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
                
        } while (loop);
    }
}
