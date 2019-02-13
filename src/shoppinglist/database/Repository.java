package shoppinglist.database;

import shoppinglist.domain.Product;


import java.util.HashMap;
import java.util.Map;

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
}


