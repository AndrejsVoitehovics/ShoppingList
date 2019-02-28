package shoppinglist.service.validation;

import org.springframework.stereotype.Component;
import shoppinglist.domain.Product;

import java.math.BigDecimal;

@Component
public class ProductPriceValidation implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNoNull(product);
        validateForNullPrice(product);
        validateForMinPrice(product);

    }

    private void validateForNullPrice(Product product) {
        if (product.getPrice() == null) {
            throw new ProductValidationException("Product price cannot be null");
        }
    }

    private void validateForMinPrice(Product product) {
        final BigDecimal MIN_PRICE = BigDecimal.valueOf(0);
        if (product.getPrice().compareTo(MIN_PRICE) <= 0) {
            throw new ProductValidationException("Product price must be > " + MIN_PRICE);
        }
    }
}
