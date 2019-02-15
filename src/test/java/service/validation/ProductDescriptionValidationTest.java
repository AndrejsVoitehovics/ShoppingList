package service.validation;

import org.junit.Test;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;

public class ProductDescriptionValidationTest {
    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductShortDescriptionException() {
        ProductNameValidation victim = new ProductNameValidation();
        Product product = new Product();
        product.setDescription("hh");
        victim.validate(product);
    }

    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductLongDescriptionException() {
        ProductNameValidation victim = new ProductNameValidation();
        Product product = new Product();
        product.setName("hhuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        victim.validate(product);
    }

    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductNullDescriptionException() {
        ProductNameValidation victim = new ProductNameValidation();
        Product product = new Product();
        product.setDescription(null);
        victim.validate(product);
    }
}
