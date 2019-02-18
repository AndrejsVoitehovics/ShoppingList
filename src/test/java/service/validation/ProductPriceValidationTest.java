package service.validation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductPriceValidation;
import shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;

public class ProductPriceValidationTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductPriceValidation victim = new ProductPriceValidation();
    private Product product = new Product();

    @Test
    public void shouldThrowProductPriceLowerZeroException() {
        product.setPrice(BigDecimal.valueOf(-5));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product price must be > 0");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductPriceNullException() {
        product.setPrice(null);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product price cannot be null");
        victim.validate(product);
    }
}
