package shoppinglist.database;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import shoppinglist.domain.ShoppingCart;

import java.util.Optional;

@Repository
@Component
public class ShoppingCartDatabase {
    private final SessionFactory sessionFactory;

    @Autowired
    public ShoppingCartDatabase(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Long createShoppingCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart.getShoppingCartId();
    }

    public ShoppingCart findShoppingCartById(Long id) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
        return shoppingCart;
    }
}
