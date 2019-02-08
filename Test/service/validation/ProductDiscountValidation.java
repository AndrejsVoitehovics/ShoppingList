package service.validation;

import org.junit.Test;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;

public class ProductDiscountValidation {
    @Test(expected = ProductValidationException.class)

    public void shouldThrowProductDiscountLowerZeroException() {
        ProductNameValidation victim;
        victim = new ProductNameValidation();
        Product product = new Product();
        product.setDiscount(BigDecimal.valueOf(-5));
        victim.validate(product);
    }
    @Test(expected = ProductValidationException.class)

    public void shouldThrowProductDiscountGreatherHundredException() {
        ProductNameValidation victim;
        victim = new ProductNameValidation();
        Product product = new Product();
        product.setDiscount(BigDecimal.valueOf(105));
        victim.validate(product);
    }
    @Test(expected = ProductValidationException.class)

    public void shouldThrowProductDiscountNullException() {
        ProductNameValidation victim;
        victim = new ProductNameValidation();
        Product product = new Product();
        product.setDiscount(null);
        victim.validate(product);
    }
}
