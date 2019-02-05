package shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        if (name.length() < 3 || name.length() > 32) {
            throw new IllegalProductFieldExeption("Product name must be > 3. and < 32");
        }
        System.out.println("Enter product price: ");
        int price = scanner.nextInt();

        if (price <= 0) {
            throw new IllegalProductFieldExeption("Price must be > 0");
        }
        System.out.println("Enter product discount ");
        int discount = scanner.nextInt();
        if (discount > 100) {
            throw new IllegalProductFieldExeption("Discount must be < 100");
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(new BigDecimal(discount));


        try {
            Long response = productService.create(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
