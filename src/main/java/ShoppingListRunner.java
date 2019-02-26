import shoppinglist.consoleUI.ConsoleUI;
import shoppinglist.database.Repository;
import shoppinglist.service.ProductService;
import shoppinglist.service.validation.ProductValidationService;

public class ShoppingListRunner {
    public static void main(String[] args) {
        Repository repository = new Repository();
        ProductValidationService productValidationService = new ProductValidationService(repository);
        ProductService productService = new ProductService(repository, productValidationService);
        ConsoleUI consoleUI = new ConsoleUI(productService);
        consoleUI.execute();
    }
}
