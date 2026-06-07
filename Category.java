import java.util.List;
import java.util.ArrayList;

public class Category implements CategoryComponent {
    private String name;
    private List<CategoryComponent> subcategories = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void getProducts(List<Product> list) {
        for (CategoryComponent child : subcategories) 
            child.getProducts(list);
    }

    public String getName() {
        return name;
    }

    public void add(CategoryComponent cc) {
        subcategories.add(cc);
    }

    public void remove(CategoryComponent cc) {
        subcategories.remove(cc);
    }
}