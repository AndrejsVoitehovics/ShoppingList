package service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import shoppinglist.database.Database;
import shoppinglist.domain.Product;
import shoppinglist.service.DefaultProductService;
import shoppinglist.service.validation.ProductValidationService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(MockitoJUnitRunner.class)
public class DefaultProductServiceTest {
    @Mock
    ProductValidationService productValidationService;
    @Mock
    Database database;
    @InjectMocks
    DefaultProductService victim;
    @Captor
    ArgumentCaptor<Product> captor;

    @Test
    public void shouldFinProductById() {
        Product product = new Product();
        when(database.findProductById(0L)).thenReturn(product);
        Product result = victim.findProductById(0L);
        assertEquals(result, product);
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

        when(database.insert(product)).thenReturn(product.getProductId());
        Long result = victim.createProduct(product);
        verify(productValidationService).validate(captor.capture());
        Product captorResult = captor.getValue();
        assertEquals(product.getProductId(), result);
        assertEquals(captorResult, product);
    }
}

