package shoppinglist.database;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import shoppinglist.domain.ProductShoppingCart;

import javax.transaction.Transactional;

@Repository
public class ProductShopingCartDatabase {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductShopingCartDatabase(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Long saveProductShoppingCart(ProductShoppingCart productShoppingCart) {
        sessionFactory.getCurrentSession().save(productShoppingCart);
        return productShoppingCart.getProductShoppingCartId();
    }
}
