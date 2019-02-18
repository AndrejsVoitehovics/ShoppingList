package shoppinglist.service.validation;

import shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidation implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        final BigDecimal MIN_DISCOUNT = BigDecimal.valueOf(0);
        final BigDecimal MAX_DISCOUNT = BigDecimal.valueOf(100);
        final BigDecimal MIN_PRICE_TO_ADD_DISCOUNT = BigDecimal.valueOf(20);
        checkNoNull(product);
        if (product.getDiscount().compareTo(MIN_DISCOUNT) < 0 || product.getDiscount().compareTo(MAX_DISCOUNT) >= 0) {
            throw new ProductValidationException("Product discount cannot be < " + MIN_DISCOUNT + "and > " + MAX_DISCOUNT);
        }
        if (product.getDiscount() == null) {
            throw new ProductValidationException("Product discount cannot be null");
        }
        if (product.getPrice().compareTo(MIN_PRICE_TO_ADD_DISCOUNT) < 0) {
            throw new ProductValidationException("To add Discount product price must be > " + MIN_PRICE_TO_ADD_DISCOUNT);
        }
    }
}
