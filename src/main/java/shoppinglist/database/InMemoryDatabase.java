package shoppinglist.database;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import shoppinglist.domain.Product;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
@Profile("inMemory")
public class InMemoryDatabase implements Database {
    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    @Override
    public Long insert(Product product) {
        product.setProductId(productIdSequence);
        products.put(productIdSequence, product);
        productIdSequence++;
        System.out.println("Product with id " + product.getProductId() + " added in database");
        return product.getProductId();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        Optional<Product> searchingProduct = products.values().stream().filter(product -> product.getProductName().equalsIgnoreCase(name)).findFirst();
        return searchingProduct;
    }

    @Override
    public Product findProductById(Long id) {
        return products.get(id);
    }

    @Override
    public boolean existsByName(String name) {
        return products.values().stream()
                .anyMatch(product -> product.getProductName().equalsIgnoreCase(name));
    }
}