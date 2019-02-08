package shoppinglist.service.validation;

import shoppinglist.domain.Product;

public interface ProductValidationRule {
    void validate(Product product);

    default void checkNoNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Produck cannot be null");
        }
    }
}

