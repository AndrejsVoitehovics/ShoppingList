package shoppinglist.service.validation;

import org.springframework.stereotype.Component;
import shoppinglist.domain.Product;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidation implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNoNull(product);
        validateForNullDiscount(product);
        validateForRangeDiscount(product);
        validateForMinPriceToAddDiscount(product);
    }

    private void validateForNullDiscount(Product product) {
        if (product.getProductDiscount() == null) {
            throw new ProductValidationException("Product discount cannot be null");
        }
    }

    private void validateForRangeDiscount(Product product) {
        final BigDecimal MIN_DISCOUNT = BigDecimal.valueOf(0);
        final BigDecimal MAX_DISCOUNT = BigDecimal.valueOf(100);
        if (product.getProductDiscount().compareTo(MIN_DISCOUNT) < 0 || product.getProductDiscount().compareTo(MAX_DISCOUNT) >= 0) {
            throw new ProductValidationException("Product discount cannot be < " + MIN_DISCOUNT + "and > " + MAX_DISCOUNT);
        }
    }

    private void validateForMinPriceToAddDiscount(Product product) {
        final BigDecimal MIN_PRICE_TO_ADD_DISCOUNT = BigDecimal.valueOf(20);
        if (product.getProductPrice().compareTo(MIN_PRICE_TO_ADD_DISCOUNT) < 0) {
            throw new ProductValidationException("To add Discount product price must be > " + MIN_PRICE_TO_ADD_DISCOUNT);
        }
    }
}



