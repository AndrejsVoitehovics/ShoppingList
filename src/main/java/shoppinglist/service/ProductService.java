package shoppinglist.service;

import shoppinglist.domain.Product;

import java.math.BigDecimal;

public interface ProductService {
    Long createProduct(Product product);

    BigDecimal calculateDiscount(Product product);

    Product findProductById(Long id);
}
