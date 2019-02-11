package service.validation;

import org.junit.Test;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;

public class ProductNameValidationTest {

    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductShortNameException() {
        ProductNameValidation victim = new ProductNameValidation();
        Product product = new Product();
        product.setName("hh");
        victim.validate(product);
    }

    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductLongNameException() {
        ProductNameValidation victim = new ProductNameValidation();
        Product product = new Product();
        product.setName("hhuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        victim.validate(product);
    }

    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductNullNameException() {
        ProductNameValidation victim = new ProductNameValidation();
        Product product = new Product();
        product.setName(null);
        victim.validate(product);
    }
}
