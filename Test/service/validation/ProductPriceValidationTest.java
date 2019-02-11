package service.validation;

import org.junit.Test;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;

public class ProductPriceValidationTest {
    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductPriceLowerZeroException() {
        ProductNameValidation victim = new ProductNameValidation();
        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(-5));
        victim.validate(product);
    }


    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductPriceNullException() {
        ProductNameValidation victim = new ProductNameValidation();
        Product product = new Product();
        product.setPrice(null);
        victim.validate(product);
    }
}
