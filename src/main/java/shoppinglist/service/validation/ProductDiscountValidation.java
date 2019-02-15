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
        if (product.getPrice().compareTo(BigDecimal.valueOf(20)) < 0) {
            throw new ProductValidationException("To add Discount product price must be >20");
        }
    }

}
