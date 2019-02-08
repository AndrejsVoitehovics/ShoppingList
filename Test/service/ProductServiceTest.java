package service;


import org.junit.Test;

import shoppinglist.domain.Category;
import shoppinglist.domain.Product;
import shoppinglist.service.ProductService;


import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest {

    ProductService victim = new ProductService();

    @Test
    public void shouldAddDiscount() {

        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(100));
        product.setDiscount(BigDecimal.valueOf(10));
        product.setName("rrr");
        product.setDescription("ddd");
        product.setProductCategory(Category.ProductCategory.FRUIT);
        BigDecimal actual = victim.calculateDiscount(product);
        BigDecimal expected = BigDecimal.valueOf(90);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateProduct() {
        ProductService victim = new ProductService();
        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(100));
        product.setDiscount(BigDecimal.valueOf(10));
        product.setName("rrr");
        product.setDescription("ddd");
        product.setProductCategory(Category.ProductCategory.FRUIT);
        long actual = 0;
        long expected = victim.createProduct(product);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldfindProductById() {
        Product product = new Product();
        product.setId((long) 0);
        product.setPrice(BigDecimal.valueOf(100));
        product.setDiscount(BigDecimal.valueOf(10));
        product.setName("rrr");
        product.setDescription("ddd");
        product.setProductCategory(Category.ProductCategory.FRUIT);
        victim.createProduct(product);
        Product actual = victim.findProductById((long) 0);
        Product expected = product;
        assertEquals(expected, actual);

    }

}
