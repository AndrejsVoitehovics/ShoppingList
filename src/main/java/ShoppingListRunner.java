import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shoppinglist.config.ShoppingListConfig;
import shoppinglist.consoleUI.ConsoleUI;

public class ShoppingListRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShoppingListConfig.class);
        ConsoleUI consoleUI = context.getBean(ConsoleUI.class);
        consoleUI.execute();
    }
}
