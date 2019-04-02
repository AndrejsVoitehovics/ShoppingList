package shoppinglist.database;

import shoppinglist.domain.Product;

import java.util.Optional;

public interface Database {
    Long insert(Product product);

    Optional<Product> findProductByName(String name);

    Product findProductById(Long id);

    boolean existsByName(String name);
}
