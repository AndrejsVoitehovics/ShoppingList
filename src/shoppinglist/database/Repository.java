package shoppinglist.database;

import shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Repository {
    private Long productIdSequence = 0L;

    private Map<Long, Product> products = new HashMap<>();


    public Product insert(Product product) {
        product.setId(productIdSequence);
        products.put(productIdSequence, product);
        productIdSequence++;
        System.out.println("Product with id " + product.getId() + " added in database");
        return product;
    }

    public Product findProductById(Long id) {
        return products.get(id);
    }

    public boolean findUniqueProductName(String productName) {
        boolean uniqueName = false;
        for (Map.Entry<Long, Product> elements : products.entrySet()) {
            if (elements.getValue().getName().equalsIgnoreCase(productName)) {
                uniqueName = true;
            }
        }
        return uniqueName;
    }

}


