package service;

import org.junit.Test;
import shoppinglist.domain.Category;
import shoppinglist.domain.Product;
import shoppinglist.service.ProductService;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest {

    ProductService victim = new ProductService();

    public Product createProductForTests() {
        Product product = new Product();
        product.setId((long) 0);
        product.setPrice(BigDecimal.valueOf(100));
        product.setDiscount(BigDecimal.valueOf(10));
        product.setActualPrice(BigDecimal.valueOf(90));
        product.setName("rrr");
        product.setDescription("ddd");
        product.setProductCategory(Category.ProductCategory.FRUIT);
        return product;
    }

    @Test
    public void shouldAddDiscount() {
        BigDecimal actual = victim.calculateDiscount(createProductForTests());
        BigDecimal expected = BigDecimal.valueOf(90);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateProduct() {
        long actual = 0;
        long expected = victim.createProduct(createProductForTests());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldfindProductById() {
        victim.createProduct(createProductForTests());
        Product actual = victim.findProductById((long) 0);
        Product expected = createProductForTests();
        assertEquals(expected, actual);

    }

}
