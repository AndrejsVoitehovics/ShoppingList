package service.validation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shoppinglist.domain.Category;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductCategoryValidation;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;

public class ProductCategoryValidationTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductCategoryValidation victim = new ProductCategoryValidation();
    private Product product = new Product();

    @Test
    public void shouldThrowProductCategoryException() {
        product.setProductCategory(null);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product category cannon be null");
        victim.validate(product);
    }
}
