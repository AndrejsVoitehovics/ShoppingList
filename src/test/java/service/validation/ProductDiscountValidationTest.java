package service.validation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductDiscountValidation;
import shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;

public class ProductDiscountValidationTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductDiscountValidation victim = new ProductDiscountValidation();
    private Product product = new Product();

    @Test
    public void shouldThrowProductDiscountLowerZeroException() {
        product.setProductDiscount(BigDecimal.valueOf(-5));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be < 0and > 100");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductDiscountGreatherHundredException() {
        product.setProductDiscount(BigDecimal.valueOf(101));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be < 0and > 100");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductDiscountNullException() {
        product.setProductDiscount(null);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be null");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductMinPriceToAddDiscountException() {
        product.setProductPrice(BigDecimal.valueOf(10));
        product.setProductDiscount(BigDecimal.valueOf(10));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("To add Discount product price must be ");
        victim.validate(product);
    }
}
