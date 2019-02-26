package shoppinglist.database;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import shoppinglist.domain.Product;
import sun.awt.SunHints;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

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

    public Optional<Product> findProductByName(String name) {
        Optional<Product> searchingProduct = products.values().stream().filter(product -> product.getName().equalsIgnoreCase(name)).findFirst();
        return searchingProduct;
    }

    public Product findProductById(Long id) {
        return products.get(id);
    }
}


