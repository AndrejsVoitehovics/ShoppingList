package service.validation;

import org.junit.Test;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;

public class ProductCategoryValidationTest {
    @Test(expected = ProductValidationException.class)
    public void shouldThrowProductCategoryException() {
        ProductNameValidation victim;
        victim = new ProductNameValidation();
        Product product = new Product();
        product.setProductCategory(null);
        victim.validate(product);
    }
}
