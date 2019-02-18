package service.validation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;

public class ProductNameValidationTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductNameValidation victim = new ProductNameValidation();
    private Product product = new Product();

    @Test
    public void shouldThrowProductShortNameException() {
        product.setName("hh");
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name cannon be < 3and > 32");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductLongNameException() {
        product.setName("hhuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name cannon be < 3and > 32");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductNullNameException() {
        product.setName(null);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name cannon be null");
        victim.validate(product);
    }
}
