package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import shoppinglist.database.ProductShopingCartDatabase;
import shoppinglist.domain.Product;
import shoppinglist.domain.ProductShoppingCart;
import shoppinglist.domain.ShoppingCart;
import shoppinglist.service.ProductService;
import shoppinglist.service.ProductShoppingCartService;
import shoppinglist.service.ShoppingCartService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductShoppingCartServiceTest {
    @Mock
    ProductShopingCartDatabase productShopingCartDatabase;
    @InjectMocks
    ProductShoppingCartService victim;
    @Mock
    ProductService productService;
    @Mock
    ShoppingCartService shoppingCartService;

    @Test
    public void addProductInShoppinCartTest() {
        ProductShoppingCart productShoppingCart = new ProductShoppingCart();
        productShoppingCart.setProductShoppingCartId(100L);
        Product product = new Product();
        product.setProductId(100L);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppingCartId(100L);
        when(victim.addProductInShoppinCart(product.getProductId(), shoppingCart.getShoppingCartId()))
                .thenReturn(productShoppingCart.getProductShoppingCartId());
        Long result = victim.addProductInShoppinCart(product.getProductId(), shoppingCart.getShoppingCartId());
        assertEquals(result, productShoppingCart.getProductShoppingCartId());
    }
}