package shoppinglist.service.validation;

import shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidation implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNoNull(product);
        if (product.getDiscount().compareTo(BigDecimal.ZERO) < 0 || product.getDiscount().compareTo(BigDecimal.ZERO) >= 100) {
            throw new ProductValidationException("Product discount cannot be <0 and >100");
        }
        if (product.getDiscount() == null) {
            throw new ProductValidationException("Product discount cannot be null");
        }
    }
}
