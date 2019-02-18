package shoppinglist.service.validation;

import shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidation implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        final BigDecimal MIN_PRICE = BigDecimal.valueOf(0);
        checkNoNull(product);
        if (product.getPrice() == null) {
            throw new ProductValidationException("Product price cannot be null");
        }
        if (product.getPrice().compareTo(MIN_PRICE) <= 0) {
            throw new ProductValidationException("Product price must be > " + MIN_PRICE);
        }

    }
}
