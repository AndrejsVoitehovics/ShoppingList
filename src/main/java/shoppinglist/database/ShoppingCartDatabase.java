package shoppinglist.database;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import shoppinglist.domain.ShoppingCart;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class ShoppingCartDatabase {
    SessionFactory sessionFactory;

    @Autowired
    public ShoppingCartDatabase(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Long createShoppingCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart.getShoppingCartId();
    }

    @Transactional
    public ShoppingCart findShoppingCartById(Long id) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
        return shoppingCart;
    }
}
