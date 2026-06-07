import java.util.List;
import java.util.ArrayList;

public class Category implements CategoryComponent {
    private String name;
    private List<CategoryComponent> subcategories = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void add(CategoryComponent cc) {
        subcategories.add(cc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Category other = (Category) obj;
        return name.equals(other.name);
    }
    public void remove(CategoryComponent cc) {
        subcategories.remove(cc);
    }

    public void getProducts(List<Product> list) {
        for (CategoryComponent child : subcategories) 
            child.getProducts(list);
    }
    public String getName() { return name; }
}