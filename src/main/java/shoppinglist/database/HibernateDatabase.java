package shoppinglist.database;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import shoppinglist.domain.Product;


import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Profile("hibernate")
@Repository
public class HibernateDatabase implements Database {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateDatabase(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public Long insert(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product.getProductId();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("productName", name)).uniqueResult();
        return Optional.ofNullable(product);
    }

    @Transactional
    @Override
    public Optional<Product> findProductById(Long id) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("ProductId", id)).uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public boolean existsByName(String name) {
        String query = "SELECT CASE WHEN COUNT(*)> 0" +
                " THEN true ELSE false" + " END FROM Product p WHERE p.productName='" + name + "'";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setMaxResults(1)
                .uniqueResult();
    }
}
