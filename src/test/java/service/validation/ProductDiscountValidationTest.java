package service.validation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductDiscountValidation;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;
import shoppinglist.service.validation.ProductValidationRule;

import java.math.BigDecimal;

public class ProductDiscountValidationTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductDiscountValidation victim = new ProductDiscountValidation();
    private Product product = new Product();

    @Test
    public void shouldThrowProductDiscountLowerZeroException() {
        product.setDiscount(BigDecimal.valueOf(-5));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be < 0and > 100");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductDiscountGreatherHundredException() {
        product.setDiscount(BigDecimal.valueOf(101));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be < 0and > 100");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductDiscountNullException() {
        product.setDiscount(null);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be null");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductMinPriceToAddDiscountException() {
        product.setPrice(BigDecimal.valueOf(10));
        product.setDiscount(BigDecimal.valueOf(10));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("To add Discount product price must be ");
        victim.validate(product);
    }
}
