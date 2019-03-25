package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import shoppinglist.database.InMemoryDatabase;
import shoppinglist.domain.Product;
import shoppinglist.service.InMemoryProductService;
import shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InMemoryProductServiceTest {


    @Mock
    private InMemoryDatabase inMemoryDatabase;

    @Mock
    ProductValidationService productValidationService;
    @InjectMocks
    private InMemoryProductService victim;
    @Captor
    ArgumentCaptor<Product> captor;


    @Test
    public void shouldFinProductById() {
        Product product = new Product();
        when(inMemoryDatabase.findProductById(0L)).thenReturn(Optional.of(product));
        Optional result = victim.findProductById(0L);
        assertEquals(result, Optional.of(product));
    }

    @Test
    public void shouldAddDiscount() {
        Product product = new Product();
        product.setProductPrice(BigDecimal.valueOf(100));
        product.setProductDiscount(BigDecimal.valueOf(10));

        BigDecimal actual = victim.calculateDiscount(product);
        BigDecimal expected = BigDecimal.valueOf(90);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateProduct() {
        Product product = new Product();
        product.setProductId(100L);
        product.setProductPrice(BigDecimal.valueOf(100));
        product.setProductDiscount(BigDecimal.valueOf(10));

        when(inMemoryDatabase.insert(product)).thenReturn(product.getProductId());
        Long result = victim.createProduct(product);
        verify(productValidationService).validate(captor.capture());
        Product captorResult = captor.getValue();
        assertEquals(product.getProductId(), result);
        assertEquals(captorResult, product);
    }
}
