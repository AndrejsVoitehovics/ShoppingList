package shoppinglist.consoleUI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.domain.Category;
import shoppinglist.domain.Product;
import shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final ProductService productService;

    @Autowired
    public ConsoleUI(ProductService productService) {
        this.productService = productService;
    }


    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Create Product");
            System.out.println("2. Find product by id");
            System.out.println("3. Exit");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    findProduct();
                    break;
                case 3:
                    return;
            }
        }
    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Enter Product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Product description: ");
        String description = scanner.nextLine();
        System.out.println("Choose product Category ");
        System.out.println("1. Meat");
        System.out.println("2. Alcohol");
        System.out.println("3. Fruit");
        System.out.println("4. Exit");
        int chooseCategory = scanner.nextInt();
        switch (chooseCategory) {
            case 1:
                product.setProductCategory(Category.ProductCategory.MEAT);
                break;
            case 2:
                product.setProductCategory(Category.ProductCategory.ALCOHOL);
                break;
            case 3:
                product.setProductCategory(Category.ProductCategory.FRUIT);
                break;
            case 4:
                return;
        }

        System.out.println("Enter Product price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter Product discount: ");
        double discount = scanner.nextDouble();

        product.setProductName(name);
        product.setProductPrice(new BigDecimal(price));
        product.setProductDiscount(new BigDecimal(discount));
        product.setProductDescription(description);
        Long id = productService.createProduct(product);
        System.out.println("Result: " + id);
    }

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        Optional<Product> product = productService.findProductById(id);
        System.out.println(product);
    }
}

