import java.util.*;

class CategoryPicker{
    private Category chosenCategory;
    
    public void chooseCategory(AppContext context){
        ShopDB db = ShopDB.getDB();
        String menuTemplate = "Berikut adalah semua kategori untuk dipilih:\n(i).\t(kategori)";
        //list the categories to choose
        List<Category> categories = db.getCategories();
        int index = 1;
        for (Category category : categories) {
            menuTemplate += index+".\t"+category.getName()+"\n";
            index++;
        }
        menuTemplate += "Pilih kategori berdasarkan index:\n";

        boolean loop = false;
        do { 
            loop = false;
            try {
                int chosenIndex = context.sc.nextInt() - 1;
                this.chosenCategory = categories.get(chosenIndex);
            } catch (Exception e) {
                System.out.println(e);
                loop = true;
            }

        } while (loop);
    }

    public Category getChosenCategory(){
        return this.chosenCategory;
    }
}
