package shoppinglist.service;

import shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductService {
    Long createProduct(Product product);

    BigDecimal calculateDiscount(Product product);

    Optional<Product> findProductById(Long id);
}
