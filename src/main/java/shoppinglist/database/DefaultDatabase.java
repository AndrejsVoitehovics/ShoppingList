package shoppinglist.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import shoppinglist.domain.Product;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
@Profile("local")
public class DefaultDatabase implements Database {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    DefaultDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long insert(Product product) {
        String query = "insert into productlist.products (productName, productCategory, productPrice, productDiscount, productActualPrice, productDescription) values (" +
                "?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getProductCategory().toString());
            ps.setBigDecimal(3, product.getProductPrice());
            ps.setBigDecimal(4, product.getProductDiscount());
            ps.setBigDecimal(5, product.getProductActualPrice());
            ps.setString(6, product.getProductDescription());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        String mySql = "SELECT * FROM products WHERE productName =" + name;
        return jdbcTemplate.query(mySql, new BeanPropertyRowMapper(Product.class)).stream().findFirst();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        String mySql = "SELECT * FROM products WHERE ProductId =" + id;
        List<Product> product = jdbcTemplate.query(mySql, new BeanPropertyRowMapper(Product.class));
        if (!product.isEmpty()) {
            return Optional.ofNullable(product.get(0));
        }
        return Optional.empty();
    }
}
