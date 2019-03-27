package shoppinglist.database;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shoppinglist.domain.ProductShoppingCart;
import shoppinglist.domain.ShoppingCart;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<ShoppingCart> getAllProductsInUserShoppingCart(Long id) {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        shoppingCarts = sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("shoppingCartId", id)).list();
        return shoppingCarts;
    }
}