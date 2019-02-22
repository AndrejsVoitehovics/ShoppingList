package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import shoppinglist.database.Repository;
import shoppinglist.domain.Product;
import shoppinglist.service.ProductService;
import shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    private Product product = new Product();
    @Mock
    private Repository repository;

    @Mock
    ProductValidationService productValidationService;
    @InjectMocks
    private ProductService victim;
    @Captor
    ArgumentCaptor<Product> captor;


    @Test
    public void shouldFinProductById() {
        when(repository.findProductById(0L)).thenReturn(product);
        Product result = victim.findProductById(0L);
        assertEquals(result, product);
    }

    @Test
    public void shouldAddDiscount() {
        product.setPrice(BigDecimal.valueOf(100));
        product.setDiscount(BigDecimal.valueOf(10));
        BigDecimal actual = victim.calculateDiscount(product);
        BigDecimal expected = BigDecimal.valueOf(90);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateProduct() {
        product.setId(100L);
        product.setPrice(BigDecimal.valueOf(100));
        product.setDiscount(BigDecimal.valueOf(10));
        when(repository.insert(product)).thenReturn(product);
        Long result = victim.createProduct(product);
        verify(productValidationService).validate(captor.capture());
        Product captorResult = captor.getValue();
        assertEquals(product.getId(), result);
        assertEquals(captorResult, product);
    }
}
