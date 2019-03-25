package service.validation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductDescriptionValidation;
import shoppinglist.service.validation.ProductValidationException;

public class ProductDescriptionValidationTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    ProductDescriptionValidation victim = new ProductDescriptionValidation();
    Product product = new Product();

    @Test
    public void shouldThrowProductShortDescriptionException() {
        product.setProductDescription("hh");
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product description cannon be <3 and > 50");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductLongDescriptionException() {
        final String TOO_LONG_PRODUCT_DESCRIPTION = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
        product.setProductDescription(TOO_LONG_PRODUCT_DESCRIPTION);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product description cannon be <3 and > 50");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductNullDescriptionException() {
        product.setProductDescription(null);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product description cannon be null");
        victim.validate(product);
    }
}
