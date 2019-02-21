package service.validation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import shoppinglist.database.Repository;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductNameValidation;
import shoppinglist.service.validation.ProductValidationException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameValidationTest {

    @Mock
    Repository repository;
    @InjectMocks
    ProductNameValidation victim;

    private Product product = new Product();

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void shouldThrowProductShortNameException() {
        product.setName("hh");
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name cannon be < 3and > 32");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductLongNameException() {
        final String TOO_LONG_PRODUCT_NAME = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";
        product.setName(TOO_LONG_PRODUCT_NAME);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name cannon be < 3and > 32");
        victim.validate(product);
    }

    @Test
    public void shouldThrowProductUniqueNameException() {
        product.setName("qqq");
        when(repository.findProductByName(product.getName())).thenReturn(true);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name must be unique");
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
