package shoppinglist.service;


import org.springframework.stereotype.Service;
import shoppinglist.database.ShoppingCartDatabase;
import shoppinglist.domain.ShoppingCart;

import java.util.Optional;
@Service
public class ShoppingCartService {
    ShoppingCartDatabase shoppingCartDatabase;

    public Long createShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDatabase.createShoppingCart(shoppingCart);
        return shoppingCart.getShoppingCartId();
    }

    public Optional<ShoppingCart> findShoppingCartById(Long shoppingCartId) {
        return shoppingCartDatabase.findShoppingCartById(shoppingCartId);

    }
}
