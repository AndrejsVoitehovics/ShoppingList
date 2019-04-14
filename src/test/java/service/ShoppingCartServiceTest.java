package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import shoppinglist.database.ShoppingCartDatabase;

import shoppinglist.domain.ShoppingCart;
import shoppinglist.service.ShoppingCartService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {
    @Mock
    ShoppingCartDatabase shoppingCartDatabase;
    @InjectMocks
    ShoppingCartService victim;

    @Test
    public void createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppingCartId(100L);
        when(shoppingCartDatabase.createShoppingCart(shoppingCart)).thenReturn(shoppingCart.getShoppingCartId());
        Long result = victim.createShoppingCart(shoppingCart);
        assertEquals(result, shoppingCart.getShoppingCartId());
    }

    @Test
    public void findShoppingCartById() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppingCartId(100L);
        when(shoppingCartDatabase.findShoppingCartById(100L)).thenReturn(shoppingCart);
        ShoppingCart result = victim.findShoppingCartById(100L);
        assertEquals(result, shoppingCart);
    }
}