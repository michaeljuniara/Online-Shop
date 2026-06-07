package Search;
import java.util.List;
import java.util.Scanner;

public interface SearchStrategy {
    public List<Product> search(AppContext app);
}
