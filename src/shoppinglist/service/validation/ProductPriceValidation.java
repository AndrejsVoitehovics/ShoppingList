package shoppinglist.service.validation;

import shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidation implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNoNull(product);
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Product price must be > 0");
        }
        if (product.getPrice() == null) {
            throw new ProductValidationException("Product price cannot be null");
        }
    }
}
