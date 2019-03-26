package shoppinglist.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shoppinglist.database.ShoppingCartDatabase;
import shoppinglist.domain.ShoppingCart;

import javax.transaction.Transactional;

@Service
public class ShoppingCartService {
    private final ShoppingCartDatabase shoppingCartDatabase;
    @Autowired
    public ShoppingCartService(ShoppingCartDatabase shoppingCartDatabase) {
        this.shoppingCartDatabase = shoppingCartDatabase;
    }


    @Transactional
    public Long createShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDatabase.createShoppingCart(shoppingCart);
        return shoppingCart.getShoppingCartId();
    }

    public ShoppingCart findShoppingCartById(Long shoppingCartId) {
        return shoppingCartDatabase.findShoppingCartById(shoppingCartId);
    }
}
