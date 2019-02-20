package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import shoppinglist.database.Repository;
import shoppinglist.domain.Product;
import shoppinglist.service.ProductService;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    private Product product = new Product();
    @Mock
    private Repository repository;
    @InjectMocks
    private ProductService victim;

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
}
