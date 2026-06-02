import java.util.List;
import java.util.ArrayList;

public class Category implements CategoryComponent{
    private String name;
    private List<CategoryComponent> subcategories;

    public void getProducts(List<Products> list){
        for (Category child : subcategories) child.getProducts(list);
    }

    public String getName(){
        return name;
    }

    public void addProduct(Product p){
        subcategories.add(p);
    }

    public void removeProduct(Product p){
        subcategories.remove(p);
    }
}